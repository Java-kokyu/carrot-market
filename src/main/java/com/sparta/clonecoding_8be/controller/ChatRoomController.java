//package com.sparta.clonecoding_8be.controller;
//
//import com.sparta.clonecoding_8be.dto.chat.ChatRoomDto;
//import com.sparta.clonecoding_8be.model.ChatRoom;
//import com.sparta.clonecoding_8be.service.ChatService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.stereotype.Controller;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/chat")
//public class ChatRoomController {
//    private final ChatService chatService;
//
//    // 채팅방 생성
//    @PostMapping("/rooms")
//    @ResponseBody
//    public ChatRoomDto createRoom(@RequestBody String name) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User principal = (User) authentication.getPrincipal();
//        String username = principal.getUsername();
//
//        return chatService.createRoom(name, username);
//    }
//    //
//    @GetMapping("/rooms")
//    @ResponseBody
//    public List<ChatRoomDto> getRooms() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User principal = (User) authentication.getPrincipal();
//        String username = principal.getUsername();
//
//        return chatService.findByUsername(username);
//    }
//
//    // 채팅방 입장 화면
//    @PostMapping("/rooms/enter/{roomId}")
//    public String roomDetail(@PathVariable String roomId) {
//        return "";
//    }
//
//    @GetMapping("/rooms/{roomId}")
//    @ResponseBody
//    public ChatRoom roomInfo(@PathVariable String roomId) {
//        return chatService.findById(roomId);
//    }
//}
