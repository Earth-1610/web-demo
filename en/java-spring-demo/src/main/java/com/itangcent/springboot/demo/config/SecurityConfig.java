package com.itangcent.springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security Configuration
 * Configures security settings to permit all requests while maintaining Spring Security infrastructure
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/**").permitAll() // Allow access to all endpoints
                .and()
            .csrf()
                .disable(); // Disable CSRF protection for simplicity
        
        return http.build();
    }
} 