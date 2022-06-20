package com.sparta.clonecoding_8be.validator;

import com.sparta.clonecoding_8be.common.Constants;
import com.sparta.clonecoding_8be.common.exception.UserException;
import com.sparta.clonecoding_8be.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SignupValidator {
    private final MemberRepository memberRepository;

    public void isValidUsername(String username) throws UserException{
        if(memberRepository.findByUsername(username).isPresent()) {
            throw new UserException(Constants.ExceptionClass.SIGNUP_USERNAME, HttpStatus.BAD_REQUEST, "이미 가입되어 있는 회원입니다.");
        }
    }

//    public static void isValidPassword(String password) throws UserException {
//        //'숫자', '문자', '특수문자' 무조건 1개 이상, 비밀번호 '최소 4자에서 최대 16자'까지 허용
//        String regexPassword = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{4,16}$\n";
//        if(!Pattern.matches(regexPassword, password)){
//            throw new UserException(Constants.ExceptionClass.SIGNUP_PASSWORD, HttpStatus.BAD_REQUEST, "비밀번호는 숫자와 문자를 1개 이상 포함해야하며 최소 6자에서 최대 20자까지 허용합니다.");
//        }
//    }

    //이메일 형식의 계정
//        String regexUsername = "[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
//        if(!Pattern.matches(regexUsername, username)){
//            throw new UserException(Constants.ExceptionClass.SIGNUP_USERNAME, HttpStatus.BAD_REQUEST, "계정은 이메일 형식이어야 합니다.");
//        }

}
