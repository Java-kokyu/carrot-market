package com.sparta.clonecoding_8be.dto;

import com.sparta.clonecoding_8be.model.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class CommentResponseDto {
    private String comment;
    private String nickname;
    private LocalDateTime modifiedAtComment;

    public CommentResponseDto(Comment comment) {
        this.comment = comment.getComment();
        this.nickname = getNickname();
        this.modifiedAtComment = comment.getModifiedAt();
    }
}
