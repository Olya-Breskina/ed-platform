package ru.podgoretskaya.edplatform.config;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ru.podgoretskaya.edplatform.enums.UserRole;
import ru.podgoretskaya.edplatform.service.UserService;

import java.util.Collections;

@RequiredArgsConstructor
@Component
@Slf4j
//получаю от пользователя
public class CustomAuthenticationManager implements AuthenticationManager {
    private final UserService userService;
    @Value("${name}")
    private String defaultAdminUsername;
    @Value("${password}")
    private String defaultAdminPassword;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = String.valueOf(authentication.getPrincipal());//логин
        String password = String.valueOf(authentication.getCredentials());//пароль
        UserRole role;
        if (isDefaultAdmin(login, password)) {
            role = UserRole.ADMIN;
        } else {
            role = userService.login(login, password);
        }
        log.info("\n >>>\n  user: {} с ролью {} пытается получить достук к {} \n >>>", login, role, getRequestPath());
        return new UsernamePasswordAuthenticationToken(login, password, Collections.singletonList(new SimpleGrantedAuthority(role.name())));
    }

    public boolean isDefaultAdmin(String username, String password) {
        return username.equals(defaultAdminUsername) && password.equals(defaultAdminPassword);
    }

    public String getRequestPath() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return request.getServletPath();
    }
}
