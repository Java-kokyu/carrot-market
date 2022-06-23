package com.sparta.clonecoding_8be.service;

import com.sparta.clonecoding_8be.dto.post.*;
import com.sparta.clonecoding_8be.model.Imagefile;
import com.sparta.clonecoding_8be.model.Post;
import com.sparta.clonecoding_8be.model.Member;
import com.sparta.clonecoding_8be.repository.*;
import com.sparta.clonecoding_8be.service.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final ImagePathRepository imagePathRepository;
    private final S3Uploader s3Uploader;
    private final CommentRepository commentRepository;

    private static final int DEFAULT_PAGE_NUM = 0;

    private final LikeRepository likeRepository;


    // Post 저장
    @Transactional
    public PostDetailResponseDto createPosts(List<MultipartFile> multipartFileList, PostRequestDto postRequestDto, String username) throws IOException {
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


    // 상세 조회
    public PostDetailResponseDto getPostDetail(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );

        int commentCnt = commentRepository.findAllByPostId(post.getId()).size();
        int likeCnt = likeRepository.findAllByPost(post).size();

        List<Imagefile> imagefilesEntity = imagePathRepository.findByPost(post);

        List<String> imagefiles = new ArrayList<>();
        for(Imagefile imagefile : imagefilesEntity){
            imagefiles.add(imagefile.getImagefile());
        }

        return new PostDetailResponseDto(post, imagefiles, commentCnt, likeCnt);
    }

<<<<<<< HEAD
    private Page<Post> fetchPages(Long lastPostId, int size) {
        PageRequest pageRequest = PageRequest.of(DEFAULT_PAGE_NUM, size);
        return postRepository.findById(lastPostId, pageRequest);
    }

    // Post 전체
    public GoToPageDto fetchPostPagesBy(Long lastPostId, int size) {
        Page<Post> posts = fetchPages(lastPostId, size);

        List<Post> postList = postRepository.findAllByOrderByCreatedAtDesc();

=======
    public List<PostResponseDto> fetchPostPagesBy(Long lastPostId, int size) {
        Page<Post> posts = fetchPages(lastPostId, size); // followers의 게시물들을 페이지네이션해서 가져온다.
>>>>>>> minji2
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();

        for (Post post : posts) {
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

    private Page<Post> fetchPages(Long lastPostId, int size) {
        PageRequest pageRequest = PageRequest.of(DEFAULT_PAGE_NUM, size); // 페이지네이션을 위한 PageRequest, 페이지는 0으로 고정한다.
        return postRepository.findByIdLessThanOrderByModifiedAtDesc(lastPostId, pageRequest); // JPA 쿼리 메소드
    }

    @Transactional
    public EditPostResponseDto editPost(Long id, List<MultipartFile> multipartFileList,
                                        EditPostRequestDto editPostRequestDto, String username) throws IOException {
        Member member = memberRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("해당 ID의 회원이 존재하지 않습니다.")
        );
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        if(!Objects.equals(username, post.getMember().getUsername())){
            throw new IllegalArgumentException("본인이 작성한 글만 수정이 가능합니다.");
        }
        List<Imagefile> imagefiles = imagePathRepository.findByPost(post);

        List<String> imagePathList = editPostRequestDto.getImagefile();
        List<String> removedImagefiles = new ArrayList<>();

        for(int i = 0; i < imagefiles.size(); i++){
            if(!imagePathList.contains(imagefiles.get(i).getImagefile())){
                imagePathRepository.deleteById(imagefiles.get(i).getId());
                removedImagefiles.add(imagefiles.get(i).getImagefile());
            }
        }
        if(multipartFileList != null){
            for(MultipartFile multipartFile : multipartFileList) {
                String urlHttps = s3Uploader.upload(multipartFile, "static");
                String urlHttp = "http" + urlHttps.substring(5);
                Imagefile imagefile = new Imagefile(urlHttp, post);
                imagePathRepository.save(imagefile);
                imagePathList.add(urlHttp);
            }
        }

        Post editPost = post.update(editPostRequestDto);
        return new EditPostResponseDto(editPost, imagePathList);
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