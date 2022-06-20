package com.sparta.clonecoding_8be.dto;

import com.sparta.clonecoding_8be.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EditPostRequestDto {
    private String title;
    private Long price;
    private String content;
    private String address;


    public EditPostRequestDto(Post post) {
        this.title = post.getTitle();
        this.price = post.getPrice();
        this.content = post.getContent();
        this.address = post.getAddress();
    }
}