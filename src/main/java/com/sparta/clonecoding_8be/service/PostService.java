package com.sparta.clonecoding_8be.service;

import com.sparta.clonecoding_8be.dto.*;
import com.sparta.clonecoding_8be.model.Comment;
import com.sparta.clonecoding_8be.model.Imagefile;
import com.sparta.clonecoding_8be.model.Post;
import com.sparta.clonecoding_8be.model.Member;
import com.sparta.clonecoding_8be.postimg.S3Uploader;
import com.sparta.clonecoding_8be.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final ImagePathRepository imagePathRepository;
    private final S3Uploader s3Uploader;
    private final CommentRepository commentRepository;
    private final LikeRepository likeRepository;


    // Post 저장
    @Transactional
    public PostDetailResponseDto createPosts(List<MultipartFile> multipartFileList,
                                             PostRequestDto postRequestDto,
                                             String username) throws IOException {
        Member member = memberRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("해당 ID의 회원이 존재하지 않습니다.")
        );
        List<String> imagePathList = new ArrayList<>();

        Post post = postRepository.save(new Post(postRequestDto, member));

        for(MultipartFile multipartFile: multipartFileList) {
            String urlHttps = s3Uploader.upload(multipartFile, "static");
            String urlHttp = "http" + urlHttps.substring(5);
            Imagefile imagefile = new Imagefile(urlHttp, post);
            System.out.println(imagefile);
            imagePathRepository.save(imagefile);
            imagePathList.add(urlHttp);
        }
        return new PostDetailResponseDto(post, imagePathList);
    }

    // Post 상세조회
    public PostDetailResponseDto getPostDetail(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );

        List<Imagefile> imagefilesEntity = imagePathRepository.findByPost(post);

        List<String> imagefiles = new ArrayList<>();
        for(Imagefile imagefile : imagefilesEntity){
            imagefiles.add(imagefile.getImagefile());
        }
        return new PostDetailResponseDto(post, imagefiles);
    }


    // Post 전체조회
    @Transactional(readOnly = true)
    public List<PostResponseDto> getAllPosts() {
        List<Post> postList = postRepository.findAllByOrderByCreatedAtDesc();

        List<PostResponseDto> postResponseDtoList = new ArrayList<>();
        for (Post post : postList) {
            int commentCnt = commentRepository.findAllByPostId(post.getId()).size();
            List<String> imagefiles = new ArrayList<>();

            List<Imagefile> imagefilesEntity = imagePathRepository.findByPost(post);
            for(Imagefile imagefile : imagefilesEntity){
                imagefiles.add(imagefile.getImagefile());
            }

            int likeCnt = likeRepository.findAllByPost(post).size();

            postResponseDtoList.add(new PostResponseDto(
                    post.getId(),
                    post.getMember().getUsername(),
                    post.getMember().getNickname(),
                    post.getMember().getProfileImage(),
                    post.getTitle(),
                    post.getPrice(),
                    post.getContent(),
                    imagefiles,
                    post.getAddress(),
                    post.getModifiedAt(),
                    commentCnt,
                    likeCnt
            ));
        }
        return postResponseDtoList;
    }

    // Post 수정
    @Transactional
    public EditPostRequestDto editPost(Long id, MultipartFile multipartFile,
                                       EditPostRequestDto postRequestDto, String username) throws IOException {
        Member member = memberRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("해당 ID의 회원이 존재하지 않습니다.")
        );
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        if(!Objects.equals(username, post.getMember().getUsername())){
            throw new IllegalArgumentException("본인이 작성한 글만 수정이 가능합니다.");
        }
        String urlHttps = s3Uploader.upload(multipartFile, "static");
        String urlHttp = "http" + urlHttps.substring(5);
        post.update(postRequestDto);

        return postRequestDto;
    }


    // Post 삭제
    @Transactional
    public String deletePost(Long id, String Username){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        commentRepository.deleteByPostId(id);
        if(post.getMember().getUsername().equals(Username)){
            postRepository.deleteById(id);
            return "게시글이 삭제되었습니다.";
        }else{
            return "다른 사람의 게시글입니다.";
        }
    }
}