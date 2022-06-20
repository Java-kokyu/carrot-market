package com.sparta.clonecoding_8be.dto;

import com.sparta.clonecoding_8be.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EditPostRequestDto {
//    private Long postId;
    private String title;
    private Long price;
    private String content;
    private String address;
//    private String imagefile;

    public EditPostRequestDto(Post post) {
//        this.postId = post.getId();
        this.title = post.getTitle();
        this.price = post.getPrice();
        this.content = post.getContent();
//        this.imagefile = post.getImagefile();
        this.address = post.getAddress();
    }
}
