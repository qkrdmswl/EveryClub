package com.example.everyclub.config;

import com.example.everyclub.service.user.CustomOAuth2UserService;
import com.example.everyclub.service.user.UserDetailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor // 생성자가 필요한 이유 -> 필드 자동 초기화
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;
    private  final UserDetailServiceImpl authUserService;

    @Override
    @Bean // 개발자가 직접 제어가 불가능한 외부 라이브러리를 Bean으로 만들 때
    public AuthenticationManager authenticationManagerBean() throws Exception { // 원화는 시점에서 로그인 처리
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                    .headers().frameOptions().disable()

                .and()
                .authorizeRequests()
                    .antMatchers("/", "/css/**", "/images/**", "/js/**",  "h2-console/**", "/auth/**", "/user/**").permitAll()
                    .anyRequest().authenticated()

                .and()
                .formLogin()
                    .loginPage("/user/login")
                    .defaultSuccessUrl("/")

                .and()
                .logout()
                    .logoutSuccessUrl("/")

                .and()
                .oauth2Login()
                    .userInfoEndpoint()
                    .userService(customOAuth2UserService);
    }
}