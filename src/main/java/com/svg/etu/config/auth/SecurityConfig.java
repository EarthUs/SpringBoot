package com.svg.etu.config.auth;

import com.svg.etu.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정들을 활성화 시켜준다
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() // h2-console 화면을 사용하기 위해 해당 옵션들을 disable // h2 사용하지 않음
                .and()
                    .authorizeRequests() // URL별 권한 관리를 설정하는 옵션의 시작점
                    .antMatchers("/").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // 권한 관리 대상을 지정하는 옵션
                    .anyRequest().authenticated() // 설정된 값들 이외 나머지 URL들을 나타낸다.
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);
    }
}