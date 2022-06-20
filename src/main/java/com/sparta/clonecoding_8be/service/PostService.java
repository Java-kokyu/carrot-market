package com.sparta.clonecoding_8be.service;

import com.sparta.clonecoding_8be.dto.*;
import com.sparta.clonecoding_8be.model.Post;
import com.sparta.clonecoding_8be.model.Member;
import com.sparta.clonecoding_8be.postimg.S3Uploader;
import com.sparta.clonecoding_8be.repository.CommentRepository;
import com.sparta.clonecoding_8be.repository.MemberRepository;
import com.sparta.clonecoding_8be.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
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
    private final S3Uploader s3Uploader;


    // Post 저장
    @Transactional
    public PostDetailResponseDto createPosts (MultipartFile multipartFile, PostRequestDto postRequestDto, String username) throws IOException {
        Member member = memberRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("해당 ID의 회원이 존재하지 않습니다.")
        );
        String urlHttps = s3Uploader.upload(multipartFile, "static");
        String urlHttp = "http" + urlHttps.substring(5);
        Post post = new Post(postRequestDto, member, urlHttp);
        postRepository.save(post);

        return new PostDetailResponseDto(post);
    }

    // Post 상세 조회
    public PostDetailResponseDto getPostDetail(Long id){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );

        return new PostDetailResponseDto(post);
    }


//    // Post 전체 조회 Conroller 단에서 해결
    public List<PostResponseDto> getAllPosts(){
        List<Post> postList = postRepository.findAll();
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();
        for(Post post : postList){
            postResponseDtoList.add(new PostResponseDto(
                    post.getId(),
                    post.getMember().getUsername(),
                    post.getMember().getNickname(),
                    post.getMember().getProfileImage(),
                    post.getTitle(),
                    post.getPrice(),
                    post.getContent(),
                    post.getImagefile(),
                    post.getAddress(),
                    post.getModifiedAt(),
                    post.getCommentList().size()
            ));
        }
        return postResponseDtoList;
    }


    // Post 수정
    public void editPost(Long id, EditPostRequestDto requestDto, String Username){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        if(!Objects.equals(Username, post.getMember().getUsername())){
            throw new IllegalArgumentException("본인이 작성한 글만 수정이 가능합니다.");
        }
        post.editPost(requestDto);
        postRepository.save(post);

    }

    // Post 삭제
    public String deletePost(Long id, String Username){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        if(post.getMember().getUsername().equals(Username)){
            postRepository.deleteById(id);
            return "게시글이 삭제되었습니다.";
        }else{
            return "다른 사람의 게시글입니다.";
        }
    }
}