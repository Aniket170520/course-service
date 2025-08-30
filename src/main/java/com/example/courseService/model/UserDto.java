package com.example.courseService.model;

import com.example.courseService.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;

    private String username;

    private String email;

    private List<String> roles;
}
