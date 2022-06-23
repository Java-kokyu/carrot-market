package com.sparta.clonecoding_8be.repository;

import com.sparta.clonecoding_8be.dto.post.PostResponseDto;
import com.sparta.clonecoding_8be.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
<<<<<<< HEAD
    List<Post> findAllByOrderByCreatedAtDesc();
    Page<Post> findById(Long lastPostId, Pageable pageable);
=======
    Page<Post> findByIdLessThanOrderByModifiedAtDesc(Long lastArticleId, Pageable pageable);
    List<Post> findAllByOrderByModifiedAtDesc();
//    Page<Post> findById(Long lastPostId, Pageable pageable);
//    Page<Post> findById(Long lastPostId, Pageable pageable);
>>>>>>> minji2
}
