//package com.sparta.clonecoding_8be.postimg;
//
//import com.coffee.miniproject.dto.PostDetailResponseDto;
//import com.coffee.miniproject.dto.PostRequestDto;
//import com.coffee.miniproject.dto.PostRequestDto4Put;
//import com.coffee.miniproject.dto.PostResponseDto;
//import com.coffee.miniproject.service.PostService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class PostController {
//
//    private final PostService postService;
//    private final S3Uploader s3Uploader;
//
//    //이미지 업로드 테스트 (S3)
//
//
//    // 게시글 등록
//    @PostMapping("/api/posts")
//    public void registerPost(@RequestBody PostRequestDto requestDto){
//        // 시큐리티 완료 후 로그인 한 유저의 닉네임으로 변경.
//        // + service에서 해당 포스트 작성자 유저 set 해주기.
//        String nickname = "testuser";
//        postService.registerPost(requestDto, nickname);
//    }
//
//    // 게시글 전체 조회, 검색 조회, 카테고리 조회
//    @GetMapping("/api/posts")
//    public List<PostResponseDto> getAllPost(@RequestParam(required = false) String category,
//                                            @RequestParam(required = false) String search){
//        return postService.getAllPost(category, search);
//    }
//
//    // 게시글 상세 조회
//    @GetMapping("/api/posts/{id}")
//    public PostDetailResponseDto getPostDetail(@PathVariable Long id){
//        return postService.getPostDetail(id);
//    }
//
//    // 게시글 수정
//    @PutMapping("/api/posts/{id}")
//    public void updatePost(@PathVariable Long id, @RequestBody PostRequestDto4Put requestDto){
//        // 시큐리티 완료 후 본인의 게시글인지 check 로직 추가
//        postService.updatePost(id, requestDto);
//    }
//
//    //게시글 삭제
//    @DeleteMapping("/api/posts/{id}")
//    public void deletePost(@PathVariable Long id){
//        // 시큐리티 완료 후 본인의 게시글인지 check 로직 추가
//        postService.deletePost(id);
//    }
//}
