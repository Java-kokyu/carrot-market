//package com.sparta.clonecoding_8be;
//
//import com.sparta.clonecoding_8be.model.ChatMessage;
//import com.sparta.clonecoding_8be.security.jwt.TokenProvider;
//import com.sparta.clonecoding_8be.service.ChatMessageService;
//import com.sparta.clonecoding_8be.service.ChatRoomService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.simp.stomp.StompCommand;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.messaging.support.ChannelInterceptor;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Slf4j
//@RequiredArgsConstructor
//@Component
//public class StompHandler implements ChannelInterceptor {
//
//    private final TokenProvider jwtTokenProvider;
//    private final ChatRoomService chatRoomService;
//    private final ChatMessageService chatService;
//
//    @Override
//    public Message<?> preSend(Message<?> message, MessageChannel channel) {
//        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
//
//        if (StompCommand.CONNECT == accessor.getCommand()) { // websocket 연결요청
//            String jwtToken = accessor.getFirstNativeHeader("token");
//            log.info("CONNECT {}", jwtToken);
//            // Header의 jwt token 검증
//            jwtTokenProvider.validateToken(jwtToken);
//        }
//
//        else if (StompCommand.SUBSCRIBE == accessor.getCommand()) { // 채팅룸 구독요청
//            // header정보에서 구독 destination정보를 얻고, roomId를 추출한다.
//            // roomId를 URL로 전송해주고 있어 추출 필요
//            String roomId = chatService.getRoomId(Optional.ofNullable((String) message.getHeaders().get("simpDestination")).orElse("InvalidRoomId"));
//
//            // 채팅방에 들어온 클라이언트 sessionId를 roomId와 맵핑해 놓는다.(나중에 특정 세션이 어떤 채팅방에 들어가 있는지 알기 위함)
//            // sessionId는 정상적으로 들어가고있음
//            String sessionId = (String) message.getHeaders().get("simpSessionId");
//            chatRoomService.setUserEnterInfo(sessionId, roomId);
//
//            // 클라이언트 입장 메시지를 채팅방에 발송한다.(redis publish)
//            String token = Optional.ofNullable(accessor.getFirstNativeHeader("token")).orElse("UnknownUser");
//            String name = String.valueOf(jwtTokenProvider.validateToken(token));
//            chatService.sendChatMessage(ChatMessage.builder().type(ChatMessage.MessageType.ENTER).roomId(roomId).sender(name).build());
//
//            log.info("SUBSCRIBED {}, {}", name, roomId);
//        }
//
//        else if (StompCommand.DISCONNECT == accessor.getCommand()) { // Websocket 연결 종료
//
//            // 연결이 종료된 클라이언트 sesssionId로 채팅방 id를 얻는다.
//            String sessionId = (String) message.getHeaders().get("simpSessionId");
//            String roomId = chatRoomService.getUserEnterRoomId(sessionId);
//
//            // 클라이언트 퇴장 메시지를 채팅방에 발송한다.(redis publish)
//            String token = Optional.ofNullable(accessor.getFirstNativeHeader("token")).orElse("UnknownUser");
//
//            if(accessor.getFirstNativeHeader("token") != null) {
//                String name = String.valueOf(jwtTokenProvider.validateToken(token));
//                chatService.sendChatMessage(ChatMessage.builder().type(ChatMessage.MessageType.QUIT).roomId(roomId).sender(name).build());
//            }
//
//            // 퇴장한 클라이언트의 roomId 맵핑 정보를 삭제한다.
//            chatRoomService.removeUserEnterInfo(sessionId);
//            log.info("DISCONNECT {}, {}", sessionId, roomId);
//        }
//        return message;
//    }
//
//}
