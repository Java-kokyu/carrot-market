//package com.sparta.clonecoding_8be.service;
//
//import com.sparta.clonecoding_8be.model.ChatMessage;
//import com.sparta.clonecoding_8be.model.ChatRoom;
//import com.sparta.clonecoding_8be.repository.ChatMessageRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.listener.ChannelTopic;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class ChatMessageService {
//
//    private final ChannelTopic channelTopic;
//    private final RedisTemplate redisTemplate;
//    private final ChatMessageRepository chatMessageRepository;
//    private final MemberService memberService;
//
//    // destination 정보에서 roomId 추출
//    public String getRoomId(String destination) {
//        int lastIndex = destination.lastIndexOf('/');
//        if (lastIndex != -1)
//            return destination.substring(lastIndex + 1);
//        else
//            return "";
//    }
//
//    // 채팅방에 메시지 발송
//    public void sendChatMessage(ChatMessage chatMessage) {
//        if (ChatMessage.MessageType.ENTER.equals(chatMessage.getType())) {
//            chatMessage.setMessage(chatMessage.getSender() + "님이 방에 입장했습니다.");
//            chatMessage.setSender("[알림]");
//        } else if (ChatMessage.MessageType.QUIT.equals(chatMessage.getType())) {
//            chatMessage.setMessage(chatMessage.getSender() + "님이 방에서 나갔습니다.");
//            chatMessage.setSender("[알림]");
//        }
//        redisTemplate.convertAndSend(channelTopic.getTopic(), chatMessage);
//    }
//
//    public void save(ChatMessage chatMessage) {
//        ChatMessage message = new ChatMessage();
//        message.setType(chatMessage.getType());
//        message.setRoomId(chatMessage.getRoomId());
//        message.setMember(memberService.findById(chatMessage.getUserId()));
//        message.setUserId(chatMessage.getUserId());
//        message.setSender(chatMessage.getSender());
//        message.setMessage(chatMessage.getMessage());
//        message.setCreatedAt(chatMessage.getCreatedAt());
//        chatMessageRepository.save(message);
//    }
//
//    public Page<ChatMessage> getChatMessageByRoomId(String roomId, Pageable pageable) {
//        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() -1);
//        pageable = PageRequest.of(page, 150);
//        return chatMessageRepository.findByRoomId(roomId, pageable);
//    }
//
//}
