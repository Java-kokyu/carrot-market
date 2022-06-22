//package com.sparta.clonecoding_8be.dto;
//
//import com.sparta.clonecoding_8be.model.Comment;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//
//@NoArgsConstructor
//@Getter
//public class PostCommentResponseDto {
//    private Long id;
//    private Long postingid;
//    private String username;
//    private String comment;
//    private LocalDateTime createdAtComment;
//    private LocalDateTime modifiedAtComment;
//
//
//    public PostCommentResponseDto(Comment comment){
//        this.id = comment.getId();
//        this.postingid = comment.getPost().getId();
//        this.username = comment.getMember().getUsername();
//        this.comment = comment.getComment();
//        this.createdAtComment = comment.getCreatedAt();
//        this.modifiedAtComment = comment.getModifiedAt();
//    }
//}
