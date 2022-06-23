package com.sparta.clonecoding_8be.dto.post;

import com.sparta.clonecoding_8be.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GoToPageDto {
    private List<PostResponseDto> postResponseDtoList;
    private Page<Post> posts;

    private PostResponseDto postResponseDto;

    public GoToPageDto(List<PostResponseDto> postResponseDtoList, Page<Post> posts) {
        this.postResponseDtoList = postResponseDtoList;
        this.posts = posts;
    }

    public GoToPageDto(PostResponseDto postResponseDto) {
        this.postResponseDto = postResponseDto;
    }
}
