package com.sparta.clonecoding_8be.service;


import com.sparta.clonecoding_8be.dto.chat.ChatRoomRequestDto;
import com.sparta.clonecoding_8be.model.ChatRoom;
import com.sparta.clonecoding_8be.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


@Service
public class ChatRoomService {
    private HashOperations<String, String, String> hashOpsEnterInfo;

    private final ChatRoomRepository chatRoomRepository;
    private final MemberService memberService;
    public static final String ENTER_INFO = "ENTER_INFO"; // 채팅룸에 입장한 클라이언트의 sessionId 와 채팅룸 id 를 맵핑한 정보 저장

    @Autowired
    public ChatRoomService(ChatRoomRepository chatRoomRepository, MemberService memberService) {
        this.chatRoomRepository = chatRoomRepository;
        this.memberService = memberService;
    }

    // 채팅방 생성
    public ChatRoom createChatRoom(ChatRoomRequestDto requestDto) {
        ChatRoom chatRoom = new ChatRoom(requestDto, memberService);
        chatRoomRepository.save(chatRoom);
        return chatRoom;
    }

    // 전체 채팅방 조회
    public List<ChatRoom> getAllChatRooms() {
        return chatRoomRepository.findAllByOrderByCreatedAtDesc();
    }

    // 카테고리별 채팅방 조회
    public List<ChatRoom> getAllChatRoomsByCategory(String category) {
        return chatRoomRepository.findByCategory(category);
    }

    // 개별 채팅방 조회
    public ChatRoom getEachChatRoom(Long id) {
        ChatRoom chatRoom = chatRoomRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("찾는 채팅방이 존재하지 않습니다.")
        );
        return chatRoom;
    }

    // 유저가 입장한 채팅방 ID 와 유저 세션 ID 맵핑 정보 저장
    public void setUserEnterInfo(String sessionId, String roomId) {
        hashOpsEnterInfo.put(ENTER_INFO, sessionId, roomId);
    }

    // 유저 세션으로 입장해 있는 채팅방 ID 조회
    public String getUserEnterRoomId(String sessionId) {
        return hashOpsEnterInfo.get(ENTER_INFO, sessionId);
    }

    // 유저 세션정보와 맵핑된 채팅방 ID 삭제
    public void removeUserEnterInfo(String sessionId) {
        hashOpsEnterInfo.delete(ENTER_INFO, sessionId);
    }

}

