package com.sparta.clonecoding_8be.validator;

import com.sparta.clonecoding_8be.common.Constants;
import com.sparta.clonecoding_8be.common.exception.UserException;
import com.sparta.clonecoding_8be.model.Member;
import com.sparta.clonecoding_8be.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginValidator {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member isValidUsername(String username) throws UserException {
        return memberRepository.findByUsername(username).orElseThrow(
                () -> new UserException(Constants.ExceptionClass.LOGIN_USERNAME, HttpStatus.BAD_REQUEST, "등록되지 않은 이메일입니다.")
        );
    }

    public void isValidPassword(String password, String encodedPassword) throws UserException {
        if (!passwordEncoder.matches(password, encodedPassword)) {
            throw new UserException(Constants.ExceptionClass.LOGIN_PASSWORD, HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다.");
        }
    }
}
