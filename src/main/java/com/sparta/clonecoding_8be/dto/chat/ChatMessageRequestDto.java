package com.sparta.clonecoding_8be.dto.chat;

import com.sparta.clonecoding_8be.model.ChatMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageRequestDto {

    private ChatMessage.MessageType type;
    private String roomId;
    private Long userId;
    private String sender;
    private String message;
    private String createdAt;

}
