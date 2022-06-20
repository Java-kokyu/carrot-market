package com.sparta.clonecoding_8be.dto;

import com.sparta.clonecoding_8be.model.Comment;
import com.sparta.clonecoding_8be.model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class CommentResponseDto {
    private Long commentID;
    private String comment;
    private String nickname;

    private String profileImage;
    private LocalDateTime modifiedAtComment;

    public CommentResponseDto(Comment comment) {
        this.commentID = comment.getId();
        this.comment = comment.getComment();
        this.nickname = comment.getMember().getNickname();
        this.profileImage = comment.getMember().getProfileImage();
        this.modifiedAtComment = comment.getModifiedAt();
    }
}
