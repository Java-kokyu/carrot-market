package com.sparta.clonecoding_8be.model;

import com.sparta.clonecoding_8be.dto.chat.ChatRoomRequestDto;
import com.sparta.clonecoding_8be.model.Member;
import com.sparta.clonecoding_8be.service.MemberService;
import com.sparta.clonecoding_8be.util.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor
public class ChatRoom extends Timestamped {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String chatRoomName;

    @Column
    private String chatRoomImg;

    @ElementCollection
    private Set<String> category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Member member;

    public ChatRoom(ChatRoomRequestDto requestDto, MemberService userService) {
        this.chatRoomName = requestDto.getChatRoomName();
        this.chatRoomImg = requestDto.getChatRoomImg();
        this.category = requestDto.getCategory();
        this.member = userService.findById(requestDto.getUserId());
    }

}