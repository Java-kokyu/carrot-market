package com.sparta.clonecoding_8be.repository;

import com.sparta.clonecoding_8be.model.Imagefile;
import com.sparta.clonecoding_8be.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagePathRepository extends JpaRepository<Imagefile, Long> {
    List<Imagefile> findByPost(Post post);
}
