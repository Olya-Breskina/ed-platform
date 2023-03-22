package ru.podgoretskaya.edplatform.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import ru.podgoretskaya.edplatform.enums.UserRole;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, CustomAuthenticationManager customAuthenticationManager) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("**/admin/**").hasAuthority(UserRole.ADMIN.name())
                                .requestMatchers("/registration","/swagger-ui/**","/v3/api-docs/**").permitAll()
                                .requestMatchers("/auth","/api/file/courses/**","/api/file/lessons/**","/api/file/test/**").authenticated()
                                .requestMatchers("/api/metric/**").authenticated())
                .httpBasic(Customizer.withDefaults())
                .authenticationManager(customAuthenticationManager);
        return http.build();
    }
}
