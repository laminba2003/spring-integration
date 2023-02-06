package com.spring.training.config;

import com.spring.training.util.JwtConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    static final String[] whitelist = {
            "/actuator/**", "/v3/api-docs/**", "/swagger-ui.html", "/webjars/**", "/swagger-ui/**",
            "/*/v3/api-docs", "/swagger-config", "/hello"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authentication -> authentication
                        .requestMatchers(whitelist).permitAll()
                        .requestMatchers("/**").authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt().jwtAuthenticationConverter(new JwtConverter()))
                .cors().and().csrf().disable().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }


}