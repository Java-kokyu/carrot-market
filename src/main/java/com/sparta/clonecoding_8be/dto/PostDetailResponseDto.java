package com.sparta.clonecoding_8be.dto;

import com.sparta.clonecoding_8be.model.Member;
import com.sparta.clonecoding_8be.model.Post;
import com.sparta.clonecoding_8be.util.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostDetailResponseDto extends Timestamped {
    private Long postID;
    private String username;
    private String nickname;
    private String title;
    private Long price;
    private String content;
    private List<String> imagefile;
    private String address;
    private LocalDateTime modifiedAt;
    private String profileImage;

    private int commentCnt;
    private int likeCnt;

    //좋아요 한 사람들의 아이디 리스트는?


    public PostDetailResponseDto(Post post, List<String> imagefile){
        this.postID = post.getId();
        this.username = post.getMember().getUsername();
        this.nickname = post.getMember().getNickname();
        this.title = post.getTitle();
        this.price = post.getPrice();
        this.content = post.getContent();
        this.imagefile = imagefile;
        this.modifiedAt = post.getModifiedAt();
        this.address = post.getAddress();
        this.profileImage = post.getMember().getProfileImage();
    }
    public PostDetailResponseDto(Post post, List<String> imagefile, int commentCnt, int likeCnt){
        this.postID = post.getId();
        this.username = post.getMember().getUsername();
        this.nickname = post.getMember().getNickname();
        this.title = post.getTitle();
        this.price = post.getPrice();
        this.content = post.getContent();
        this.imagefile = imagefile;
        this.modifiedAt = post.getModifiedAt();
        this.address = post.getAddress();
        this.profileImage = post.getMember().getProfileImage();
        this.commentCnt = commentCnt;
        this.likeCnt = likeCnt;
    }
}
