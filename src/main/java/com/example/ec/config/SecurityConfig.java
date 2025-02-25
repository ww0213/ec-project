package com.example.ec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // 允許所有請求，無需登入
                )
                .csrf(csrf -> csrf.disable()) // 關閉 CSRF 防護，避免表單提交問題
                .formLogin(login -> login.disable()) // 關閉登入畫面
                .logout(logout -> logout.disable()); // 關閉登出功能

        return http.build();
    }
}