package com.sparta.clonecoding_8be.controller;

import com.sparta.clonecoding_8be.dto.chat.ChatRoomRequestDto;
import com.sparta.clonecoding_8be.model.ChatRoom;
import com.sparta.clonecoding_8be.service.ChatMessageService;
import com.sparta.clonecoding_8be.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (origins = "*")
@RestController
@RequestMapping("/chat")
public class ChatRoomController {


    private final ChatMessageService chatMessageService;
    private final ChatRoomService chatRoomService;

    @Autowired
    public ChatRoomController(ChatMessageService chatMessageService, ChatRoomService chatRoomService) {
        this.chatMessageService = chatMessageService;
        this.chatRoomService = chatRoomService;
    }

    // 채팅방 생성
    @PostMapping("/rooms")
    public ChatRoom createChatRoom(@RequestBody ChatRoomRequestDto requestDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal=(User) authentication.getPrincipal();
        String username = principal.getUsername();

        ChatRoom chatRoom = chatRoomService.createChatRoom(requestDto);
        return chatRoom;
    }

    // 전체 채팅방 목록 조회
    @GetMapping("/rooms")
    public List<ChatRoom> getAllChatRooms() {
        return chatRoomService.getAllChatRooms();
    }

    // 채팅팅방 카테고리별 조회
    @GetMapping("/rooms/search/{category}")
    public List<ChatRoom> getChatRoomsByCategory(@PathVariable String category) {
        return chatRoomService.getAllChatRoomsByCategory(category);
    }

    // 채팅방 상세 조회
    @GetMapping("/rooms/{roomId}")
    public ChatRoom getEachChatRoom(@PathVariable Long roomId) {
        return chatRoomService.getEachChatRoom(roomId);
    }

    // 채팅방 내 메시지 전체 조회
//    @GetMapping("/rooms/{roomId}/messages")
//    public Page<ChatMessage> getEachChatRoomMessages(@PathVariable String roomId, @PageableDefault Pageable pageable) {
//        return chatMessageService.getChatMessageByRoomId(roomId, pageable);
//    }

}
