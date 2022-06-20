package com.sparta.clonecoding_8be.dto;


import com.sparta.clonecoding_8be.model.Comment;
import com.sparta.clonecoding_8be.model.Member;
import com.sparta.clonecoding_8be.model.Post;
import com.sparta.clonecoding_8be.util.Timestamped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostResponseDto extends Timestamped {
    private Long postID;
    private String username;
    private String nickname;
    private String profileImage;
    private String title;
    private Long price;
    private String contents;
    private String imageFile;
    private String address;
    private LocalDateTime modifiedAt;
    private Integer commentCnt;

//    public PostResponseDto(Post post, int commentCnt) {
//        this.postID = post.getId();
//        this.username = post.getMember().getUsername();
//        this.nickname = post.getMember().getNickname();
//        this.profileImage = post.getMember().getProfileImage();
//        this.title = post.getTitle();
//        this.price = post.getPrice();
//        this.contents = post.getContent();
//        this.imagefile = post.getImagefile();
//        this.address = post.getAddress();
//        this.modifiedAt = post.getModifiedAt();
//        this.commentCnt = commentCnt;
//    }


    //좋아요 한 사람들의 아이디 리스트는?
    //comment 수는?

//    this.cntComment = post.getCommentList().size();
}
