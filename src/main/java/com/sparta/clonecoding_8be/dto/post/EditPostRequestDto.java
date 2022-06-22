package com.sparta.clonecoding_8be.dto.post;

import com.sparta.clonecoding_8be.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.JSONArray;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EditPostRequestDto {
    private String title;
    private Long price;
    private List<String> imagefile;
    private String content;
    private String address;


    public EditPostRequestDto(Post post, List<String> imagefile) {
        this.title = post.getTitle();
        this.price = post.getPrice();
        this.imagefile = imagefile;
        this.content = post.getContent();
        this.address = post.getAddress();
    }
}