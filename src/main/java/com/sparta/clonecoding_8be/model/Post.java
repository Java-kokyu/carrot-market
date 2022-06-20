package com.sparta.clonecoding_8be.model;

import com.sparta.clonecoding_8be.dto.EditPostRequestDto;
import com.sparta.clonecoding_8be.dto.PostRequestDto;
import com.sparta.clonecoding_8be.util.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
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
    private String imagefile;

    @Column(nullable = false)
    private String address;


    //address는 아직 못해봤다.

    @JsonIgnore // 안붙게함
    @ManyToOne // 포스트가 다수니까
    @JoinColumn // 다른 model과 연결하겠다
    private Member member;

    @OneToMany
    @JoinColumn
    private List<Comment> commentList;


    public Post (PostRequestDto postRequestDto, Member member, String imagefile){
        this.title = postRequestDto.getTitle();
        this.price = postRequestDto.getPrice();
        this.content = postRequestDto.getContent();
        this.imagefile = imagefile;
        this.address = postRequestDto.getAddress();
        this.member = member;
    }

    public void editPost(EditPostRequestDto editPostRequestDto){
        this.title = editPostRequestDto.getTitle();
        this.price = editPostRequestDto.getPrice();
        this.content = editPostRequestDto.getContents();
    }
}
