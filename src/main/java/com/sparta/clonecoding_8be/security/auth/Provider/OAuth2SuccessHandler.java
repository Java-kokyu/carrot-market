package com.sparta.clonecoding_8be.security.auth.Provider;

import com.sparta.clonecoding_8be.dto.TokenDto;
import com.sparta.clonecoding_8be.model.RefreshToken;
import com.sparta.clonecoding_8be.repository.RefreshTokenRepository;
import com.sparta.clonecoding_8be.security.UserDetailsImpl;
import com.sparta.clonecoding_8be.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {
        String targetUrl;

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // 최초 로그인이라면 회원가입 처리를 한다.

        TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);

        tokenDto.setUsername(userDetails.getUsername());
        tokenDto.setUsername(userDetails.getNickname());

        RefreshToken refreshToken = RefreshToken.builder()
                .key(authentication.getName())
                .value(tokenDto.getRefreshToken())
                .build();

        refreshTokenRepository.save(refreshToken);

        // 5. 토큰 발급
        targetUrl = UriComponentsBuilder.fromUriString("http://localhost:8080/api")
                .queryParam("Authorization", tokenDto.getAccessToken())
                .build().toUriString();
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}
