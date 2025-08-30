package com.example.courseService.auth;

import com.example.courseService.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AuthClient {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public UserDto getUserFromToken(String token){
        return webClientBuilder.build().get()
                .uri("http://localhost:8080/user")
                .header(HttpHeaders.AUTHORIZATION, token)
                .retrieve()
                .bodyToMono(UserDto.class)
                .block();
    }
}
