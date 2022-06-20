package com.sparta.clonecoding_8be.security.auth;


import com.sparta.clonecoding_8be.model.Member;
import com.sparta.clonecoding_8be.model.UserRole;
import com.sparta.clonecoding_8be.repository.MemberRepository;
import com.sparta.clonecoding_8be.security.UserDetailsImpl;
import com.sparta.clonecoding_8be.security.auth.Provider.GoogleUserInfo;
import com.sparta.clonecoding_8be.security.auth.Provider.KakaoUserInfo;
import com.sparta.clonecoding_8be.security.auth.Provider.NaverUserInfo;
import com.sparta.clonecoding_8be.security.auth.Provider.OAuth2UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@RequiredArgsConstructor
public class OAuthUserDeatilsServiceImpl extends DefaultOAuth2UserService {
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);


        OAuth2UserInfo oAuth2UserInfo = null;

        if(userRequest.getClientRegistration().getRegistrationId().equals("google")) {
            System.out.println("구글 로그인 요청");
            System.out.println(oAuth2User.getAttributes());
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        } else if(userRequest.getClientRegistration().getRegistrationId().equals("naver")){
            System.out.println("네이버 로그인 요청");
            System.out.println(oAuth2User.getAttributes());
            oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));
        } else if(userRequest.getClientRegistration().getRegistrationId().equals("kakao")){
            System.out.println("카카오 로그인 요청");
            System.out.println(oAuth2User.getAttributes());
            oAuth2UserInfo = new KakaoUserInfo((Map)oAuth2User.getAttributes().get("kakao_account"));
        }
        else{
            System.out.println("구글과 카카오톡, 네이버 아님!");
        }

        String provider = oAuth2UserInfo.getProvider(); //google,facebook
        String password = passwordEncoder.encode("당근마켓클론");
        UserRole userRole = UserRole.USER;
        String nickname = oAuth2UserInfo.getName();
        String email = oAuth2UserInfo.getEmail();
        String profileImg = oAuth2UserInfo.getProfileImg();

        Member member = memberRepository.findByUsername(email)
                .orElse(new Member(email, password, nickname, userRole, provider, profileImg));
        memberRepository.save(member);

//        Authentication auth = new UsernamePasswordAuthenticationToken(member, null);
//        SecurityContextHolder.getContext().setAuthentication(auth);

        return new UserDetailsImpl(member, oAuth2User.getAttributes());
    }
}
