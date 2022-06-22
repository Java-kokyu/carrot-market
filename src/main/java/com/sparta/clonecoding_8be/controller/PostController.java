package com.sparta.clonecoding_8be.controller;

import com.sparta.clonecoding_8be.dto.post.*;
import com.sparta.clonecoding_8be.repository.PostRepository;
import com.sparta.clonecoding_8be.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;

    // Post 생성
    @PostMapping("/api/posts")
    public PostDetailResponseDto createPosts(@RequestPart(value = "file",required = false)
                                                 List<MultipartFile> multipartFileList,
                                             @RequestPart(value = "contents")
                                             PostRequestDto requestDto) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal=(User) authentication.getPrincipal();
        String username = principal.getUsername();

        return postService.createPosts(multipartFileList, requestDto, username);
    }

    // Post 전체조회
    @GetMapping("/api/posts")
    public List<PostResponseDto> getAllposts(){
        return postService.getAllPosts();
    }

    // Post 상세조회
    @GetMapping("/api/posts/{postID}")
    public PostDetailResponseDto getPostDetail(@PathVariable Long postID){
        return postService.getPostDetail(postID);
    }

    // Post 수정
    @PutMapping("/api/posts/{postID}")
    public EditPostResponseDto editPost (@PathVariable Long postID,
                                         @RequestPart(value = "file",required = false)
                                         List<MultipartFile> multipartFileList,
                                         @RequestPart(value = "contents")
                                         EditPostRequestDto requestDto) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal=(User) authentication.getPrincipal();
        String username = principal.getUsername();
        System.out.println(multipartFileList);

        return postService.editPost(postID, multipartFileList, requestDto, username);

    }
//    public void editPost(@PathVariable Long postID,
//                        @RequestBody EditPostRequestDto requestDto){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User principal=(User) authentication.getPrincipal();
//        String username = principal.getUsername();
//        postService.editPost(postID, requestDto, username);
//    }

    // Post 삭제
    @DeleteMapping("/api/posts/{postID}")
    public String deletePost(@PathVariable Long postID){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal=(User) authentication.getPrincipal();
        String username = principal.getUsername();
        return postService.deletePost(postID, username);
    }
}