package com.sparta.clonecoding_8be.dto.chat;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ChatRoomRequestDto {

    private String chatRoomName;
    private String chatRoomImg;
    private Set<String> category;
    private Long userId;

}
