package com.svg.etu.config.auth;

import com.svg.etu.config.auth.dto.OAuthAttributes;
import com.svg.etu.config.auth.dto.SessionUser;
import com.svg.etu.user.UserService;
import com.svg.etu.user.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final UserService userService;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId(); // 현재 로그인 진행 중인 서비스를 구분하는 코
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName(); // OAuth2 로그인 진행 시 키가 되는 필드값

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
        // OAuthAttributes : OAuth2UserService를 통해 가져온 OAuth2User의 attribute를 담을 클래스
        UserVO user = save(attributes);
        httpSession.setAttribute("user", new SessionUser(user)); // SessonUser :

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
    }


    private UserVO save(OAuthAttributes attributes) {
        UserVO user = userService.findByEmail(attributes.getEmail())
                .orElse(attributes.toEntity());

        return userService.saveUser(user);
    }
}

// 구글 로그인 이후 구글에서 수정한 사용자의 정보는 업데이트 지원하지 않음