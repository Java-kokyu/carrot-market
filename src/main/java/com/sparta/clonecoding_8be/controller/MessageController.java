//package com.sparta.clonecoding_8be.controller;
//
//import com.sparta.clonecoding_8be.dto.chat.MessageType;
//import com.sparta.clonecoding_8be.model.ChatMessage;
//import lombok.RequiredArgsConstructor;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.simp.SimpMessageSendingOperations;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class MessageController {
//
//    private final SimpMessageSendingOperations sendingOperations;
//
//    @MessageMapping("/chat/message")
//    public void enter(ChatMessage message) {
//        if (MessageType.ENTER.equals(message.getType())) {
//            message.setMessage(message.getSender()+"님이 입장하였습니다.");
//        }
//        sendingOperations.convertAndSend("/sub/chat/room/"+message.getChatRoom().getRoomId(),message);
//    }
//
//    @MessageMapping(value = "/chat/message")
//    public void message(ChatMessage message){
//        sendingOperations.convertAndSend("/sub/chat/room/" + message.getChatRoom().getRoomId(), message);
//    }
//}
