package com.sparta.clonecoding_8be.controller;

import com.sparta.clonecoding_8be.repository.MemberRepository;
import com.sparta.clonecoding_8be.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LikeController {

    private final LikeService likeService;
    private final MemberRepository memberRepository;

    @PostMapping("/like/{postID}")
    public void uplike(@PathVariable Long postID){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();
        likeService.uplike(postID, username);
    }

    @GetMapping("/like/{postID}")
    public boolean checkLike(@PathVariable Long postID){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();
        return likeService.checkLike(postID, username);
    }
}
