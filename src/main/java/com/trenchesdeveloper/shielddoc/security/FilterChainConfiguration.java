package com.trenchesdeveloper.shielddoc.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class FilterChainConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/user/login").permitAll()
                .anyRequest().authenticated()
            );


        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) throws Exception {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(userDetailsService);
        return daoAuthenticationProvider;

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        // Let Spring build the AuthenticationManager automatically
        return configuration.getAuthenticationManager();
    }
}
