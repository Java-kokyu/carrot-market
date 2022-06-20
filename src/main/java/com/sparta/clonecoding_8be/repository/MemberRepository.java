package com.sparta.clonecoding_8be.repository;


import com.sparta.clonecoding_8be.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);
//    Optional<Member> findByNickname(String nickname);

    boolean existsByUsername(String username);
}