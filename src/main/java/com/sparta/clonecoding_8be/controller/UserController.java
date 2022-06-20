package com.sparta.clonecoding_8be.controller;

import com.sparta.clonecoding_8be.common.exception.UserException;
import com.sparta.clonecoding_8be.dto.*;
import com.sparta.clonecoding_8be.model.Member;
import com.sparta.clonecoding_8be.postimg.S3Uploader;
import com.sparta.clonecoding_8be.repository.MemberRepository;
import com.sparta.clonecoding_8be.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    private final S3Uploader s3Uploader;

    @PostMapping("/api/images")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile multipartFile)throws IOException {
        String url = s3Uploader.upload(multipartFile, "static");
        System.out.println("이미지 url 주소 = " + url);
        return url;
    }

    @PostMapping("/user/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) throws UserException {
        return ResponseEntity.ok(memberService.signup(memberRequestDto));
    }

    @PostMapping("/user/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(memberService.login(memberRequestDto));
    }

    @PostMapping("/user/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(memberService.reissue(tokenRequestDto));
    }

    @GetMapping("/user/userinfo")
    @ResponseBody
    public UserInfo Session(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();
        Member member = memberRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("존재하지 않는 유저입니다")
        );

//        boolean isAdmin = (role == UserRole.ADMIN);
        return new UserInfo(member.getUsername(), member.getNickname());
    }
}

