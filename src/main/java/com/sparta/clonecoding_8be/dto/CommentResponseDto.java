package com.sparta.clonecoding_8be.dto;

import com.sparta.clonecoding_8be.model.Comment;
import com.sparta.clonecoding_8be.model.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class CommentResponseDto {
    private Long comentID;
    private String comment;
    private String nickname;

    private String profileImage;
    private LocalDateTime modifiedAtComment;

    public CommentResponseDto(Comment comment, Member member) {
        this.comentID = comment.getId();
        this.comment = comment.getComment();
        this.nickname = member.getNickname();
        this.profileImage = member.getProfileImage();
        this.modifiedAtComment = comment.getModifiedAt();
    }
}
