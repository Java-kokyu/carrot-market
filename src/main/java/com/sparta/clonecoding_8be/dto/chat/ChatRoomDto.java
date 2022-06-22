//package com.sparta.clonecoding_8be.dto.chat;
//
//import com.sparta.clonecoding_8be.model.ChatRoom;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.UUID;
//
//@Getter
//@Setter
//@NoArgsConstructor
//public class ChatRoomDto {
//
//    private String roomId;
//    private String roomName;
//
//
//    public static ChatRoomDto create(String name) {
//        ChatRoomDto room = new ChatRoomDto();
//        room.roomId = UUID.randomUUID().toString();
//        room.roomName = name;
//        return room;
//    }
//
//    public ChatRoomDto(ChatRoom chatRoom) {
//        this.roomId = chatRoom.getRoomId();
//        this.roomName = chatRoom.getRoomName();
//    }
//}
