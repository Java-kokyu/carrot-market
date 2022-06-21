package com.sparta.clonecoding_8be.repository;

import com.sparta.clonecoding_8be.model.Likes;
import com.sparta.clonecoding_8be.model.Member;
import com.sparta.clonecoding_8be.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Likes,Long> {
    Likes findByMemberAndPost(Member member, Post post);
    List<Likes> findAllByPost(Post post);
    Likes getLikeByMemberAndPost(Member member, Post post);

}
