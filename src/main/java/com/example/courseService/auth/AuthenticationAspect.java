package com.example.courseService.auth;

import com.example.courseService.model.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

@Aspect
@Component
public class AuthenticationAspect {

    @Autowired
    private AuthClient authClient;

    @Around("@annotation(authenticated)")
    public Object authenticateMethod(ProceedingJoinPoint pjp, Authenticated authenticated) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (token == null || !token.startsWith("Bearer ")) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Missing or invalid token");
        }

        UserDto user = authClient.getUserFromToken(token);

        if (authenticated.roles().length > 0 &&
                Arrays.stream(authenticated.roles()).noneMatch(user.getRoles()::contains)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User does not have required role");
        }

        try {
            UserContextHolder.set(user); // store in ThreadLocal
            return pjp.proceed();
        } finally {
            UserContextHolder.clear();
        }
    }
}

