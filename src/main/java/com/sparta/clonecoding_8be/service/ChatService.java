//package com.sparta.clonecoding_8be.service;
//
//import com.sparta.clonecoding_8be.dto.chat.ChatRoomDto;
//import com.sparta.clonecoding_8be.model.ChatRoom;
//import com.sparta.clonecoding_8be.model.Member;
//import com.sparta.clonecoding_8be.repository.ChatRoomRepository;
//import com.sparta.clonecoding_8be.repository.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.util.*;
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class ChatService {
//    private final MemberRepository memberRepository;
//    private final ChatRoomRepository chatRoomRepository;
//
//    private Map<String, ChatRoom> chatRooms;
//
//    @PostConstruct
//    //의존관게 주입완료되면 실행되는 코드
//    private void init() {
//        chatRooms = new LinkedHashMap<>();
//    }
//
//    //채팅방 생성
//    public ChatRoomDto createRoom(String roomName, String username) {
//        Member member = memberRepository.findByUsername(username).orElseThrow(
//                () -> new UsernameNotFoundException("존재하지 않는 회원입니다")
//        );
//        ChatRoomDto chatRoomDto = ChatRoomDto.create(roomName);
//        ChatRoom chatRoom = new ChatRoom(chatRoomDto, member);
//        chatRoomRepository.save(chatRoom);
//        chatRooms.put(chatRoom.getRoomId(), chatRoom);
//        return chatRoomDto;
//    }
//
//    public List<ChatRoomDto> findByUsername(String username){
//        Member member = memberRepository.findByUsername(username).orElseThrow(
//                () -> new UsernameNotFoundException("존재하지 않는 회원입니다")
//        );
//        List<ChatRoom> chatRooms = chatRoomRepository.findByMember(member);
//        List<ChatRoomDto> chatRoomDtoList = new ArrayList<>();
//        for(ChatRoom chatRoom : chatRooms){
//            ChatRoomDto chatRoomDto = new ChatRoomDto(chatRoom);
//            chatRoomDtoList.add(chatRoomDto);
//        }
//
//        return chatRoomDtoList;
//    }
//
//    //채팅방 불러오기
//    public List<ChatRoom> findAllRoom() {
//        //채팅방 최근 생성 순으로 반환
//        List<ChatRoom> result = new ArrayList<>(chatRooms.values());
//        Collections.reverse(result);
//
//        return result;
//    }
//
//    //채팅방 하나 불러오기
//    public ChatRoom findById(String roomId) {
//        return chatRooms.get(roomId);
//    }
//
//
//}
