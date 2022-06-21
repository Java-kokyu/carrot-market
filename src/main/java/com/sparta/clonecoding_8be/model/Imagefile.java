package com.sparta.clonecoding_8be.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Imagefile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String imagefile;

    @ManyToOne
    @JoinColumn
    private Post post;

    public Imagefile(String imagefile, Post post){
        this.imagefile = imagefile;
        this.post = post;
    }
}
