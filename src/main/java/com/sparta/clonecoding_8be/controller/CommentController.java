package com.sparta.clonecoding_8be.controller;

import com.sparta.clonecoding_8be.dto.comment.CommentRequestDto;
import com.sparta.clonecoding_8be.dto.comment.CommentResponseDto;
import com.sparta.clonecoding_8be.dto.comment.EditCommentRequestDto;
import com.sparta.clonecoding_8be.model.Member;
import com.sparta.clonecoding_8be.repository.MemberRepository;
import com.sparta.clonecoding_8be.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.userdetails.User;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final MemberRepository memberRepository;

    //댓글 생성
    @PostMapping("/api/posts/{postID}/comments")
    public ResponseEntity<CommentResponseDto> registComment(@PathVariable Long postID,
                                              @RequestBody CommentRequestDto commentRequestDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();
        CommentResponseDto commentResponseDto = commentService.saveComment(postID, username, commentRequestDto);
        return ResponseEntity.ok(commentResponseDto);
    }

    //댓글 조회
    @GetMapping("/api/posts/{postID}/comments")
    public ResponseEntity<List<CommentResponseDto>> getCommentsByPostId (@PathVariable Long postID) {
        return ResponseEntity.ok().body(commentService.getCommentsByPostId(postID));
    }

    //댓글 삭제
    @DeleteMapping("/api/posts/{postID}/comments/{commentID}")
    public Boolean deleteComment(@PathVariable Long commentID){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();
        Boolean result = false;
        if (username != null) {
            result = commentService.deleteComment(commentID, username);
        }
        return result;
    }

    //댓글 수정
    @PutMapping("/api/posts/{postID}/comments/{commentID}")
    public CommentResponseDto updateComment(@PathVariable Long commentID,
                                            @RequestBody EditCommentRequestDto editCommentRequestDto) {
        //authenticaiotn을 UserDetails로 받아올 수는 없을까? DB를 다시 뒤지는 게 비효율적
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();

        Member member = memberRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 회원입니다")
        );

        return commentService.updateComment(commentID, editCommentRequestDto, member);

    }
}