package com.sparta.clonecoding_8be.security.auth.Provider;

public interface OAuth2UserInfo {
    String getProfileImg();
    String getProvider();
    String getEmail();
    String getName();

}
