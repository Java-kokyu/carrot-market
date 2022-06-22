package com.sparta.clonecoding_8be.dto.post;

import com.sparta.clonecoding_8be.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EditPostResponseDto {
    private Long postId;
    private String title;
    private Long price;
    private String content;
    private String address;
    private List<String> imagefile;

    public EditPostResponseDto(Post post, List<String> imagefile){
        this.postId = post.getId();
        this.title = post.getTitle();
        this.price = post.getPrice();
        this.content = post.getContent();
        this.address = post.getAddress();
        this.imagefile = imagefile;
    }


}
