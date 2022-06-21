package com.sparta.clonecoding_8be.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Post post;

    @ManyToOne
    @JoinColumn
    private Member member;


    public Likes(Member member, Post post){
        this.member = member;
        this.post = post;
    }
}
