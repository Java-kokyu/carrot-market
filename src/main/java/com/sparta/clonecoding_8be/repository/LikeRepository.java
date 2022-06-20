package com.sparta.clonecoding_8be.repository;

import com.sparta.clonecoding_8be.model.Like;
import com.sparta.clonecoding_8be.model.Member;
import com.sparta.clonecoding_8be.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like,Long> {
    Like findByMemberAndPost(Member member, Post post);
    List<Like> findAllByPost(Post post);
    Like getLikeByMemberAndPost(Member member, Post post);

}
