package com.sparta.clonecoding_8be.repository;

import com.sparta.clonecoding_8be.model.ChatRoom;
import com.sparta.clonecoding_8be.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    List<ChatRoom> findAllByOrderByCreatedAtDesc();
    List<ChatRoom> findByCategory(String category);
}
