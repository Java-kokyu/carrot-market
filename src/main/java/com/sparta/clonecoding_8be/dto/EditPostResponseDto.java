package com.sparta.clonecoding_8be.dto;

import com.sparta.clonecoding_8be.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EditPostResponseDto {
    private Long postId;
    private String title;
    private Long price;
    private String content;
    private String address;
    private String imagefile;


}
