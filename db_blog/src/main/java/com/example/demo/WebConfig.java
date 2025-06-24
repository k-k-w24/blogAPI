package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // どのURLパスを対象にするか
                .allowedOrigins("http://127.0.0.1:5500") // ← Live ServerのURL
                .allowedMethods("GET", "POST") // 必要なHTTPメソッド
                .allowCredentials(true); // Cookie等を使う場合はtrue
    }
}
