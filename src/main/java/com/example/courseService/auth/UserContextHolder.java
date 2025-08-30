package com.example.courseService.auth;

import com.example.courseService.model.UserDto;

public class UserContextHolder {
    private static final ThreadLocal<UserDto> userHolder = new ThreadLocal<>();

    public static void set(UserDto user){
        userHolder.set(user);
    }

    public static UserDto get(){
        return userHolder.get();
    }

    public static void clear(){
        userHolder.remove();
    }
}
