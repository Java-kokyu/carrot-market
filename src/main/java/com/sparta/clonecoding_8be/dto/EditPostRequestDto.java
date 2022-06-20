package com.sparta.clonecoding_8be.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EditPostRequestDto {
    private String title;
    private String contents;
    private Long price;

}
