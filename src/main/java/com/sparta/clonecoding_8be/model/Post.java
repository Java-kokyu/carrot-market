package com.sparta.clonecoding_8be.model;

import com.sparta.clonecoding_8be.dto.post.EditPostRequestDto;
import com.sparta.clonecoding_8be.dto.post.PostRequestDto;
import com.sparta.clonecoding_8be.util.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Post extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String address;

    @JsonIgnore // 안붙게함
    @ManyToOne // 포스트가 다수니까
    @JoinColumn // 다른 model과 연결하겠다
    private Member member;

    @OneToMany(mappedBy = "post", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Imagefile> imagefiles;

    @OneToMany(mappedBy = "post", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Comment> comments;


    public Post(PostRequestDto postRequestDto, Member member) {
        this.title = postRequestDto.getTitle();
        this.price = postRequestDto.getPrice();
        this.content = postRequestDto.getContent();
        this.address = postRequestDto.getAddress();
        this.member = member;
    }

    public Post(EditPostRequestDto editpostRequestDto, Member member) {
        this.title = editpostRequestDto.getTitle();
        this.price = editpostRequestDto.getPrice();
        this.content = editpostRequestDto.getContent();
        this.address = editpostRequestDto.getAddress();
        this.member = member;
    }

    public Post update(EditPostRequestDto editPostRequestDto) {
        this.title = editPostRequestDto.getTitle();
        this.price = editPostRequestDto.getPrice();
        this.content = editPostRequestDto.getContent();
        this.address = editPostRequestDto.getAddress();
        return this;
    }

//    public Post(GoToPageDto goToPageDto, Long lastPostId, int size) {
//        this.title = goToPageDto.getPostResponseDto().getTitle();
//        this.price = goToPageDto.getPostResponseDto().getPrice();
//        this.content = goToPageDto.getPostResponseDto().getContent();
//        this.address = goToPageDto.getPostResponseDto().getAddress();
//        this.size = size;
//    }

//    public Post (GoToPageDto goToPageDto, Long lastPostId, int size){
//        this.postId = goToPageDto.getPostResponseDto().getPostID();
//        this.title = goToPageDto.getPostResponseDto().getTitle();
//        this.price = goToPageDto.getPostResponseDto().getPrice();
//        this.content = goToPageDto.getPostResponseDto().getContent();
//        this.address = goToPageDto.getPostResponseDto().getAddress();
//        this.username = goToPageDto.getPostResponseDto().getUsername();
//        this.lastPostId = lastPostId;
//}
}