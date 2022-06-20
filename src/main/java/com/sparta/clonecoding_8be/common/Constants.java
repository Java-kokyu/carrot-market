package com.sparta.clonecoding_8be.common;


public class Constants {
    public enum ExceptionClass {

        LOGIN_USERNAME("로그인 아이디"), LOGIN_PASSWORD("로그인 비밀번호"), NICKNAME("닉네임"),
        SIGNUP_USERNAME("회원 가입 아이디"), SIGNUP_PASSWORD("로그인 패스워드"), SIGNUP_PASSWORDCHECK("로그인 패스워드 확인");
        private String exceptionClass;

        ExceptionClass(String exceptionClass) {
            this.exceptionClass = exceptionClass;
        }

        public String getExceptionClass() {
            return exceptionClass;
        }

        @Override
        public String toString() {
            return getExceptionClass() + " 오류 발생. ";
        }

    }
}