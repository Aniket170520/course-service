package com.example.courseService.controller;

import com.example.courseService.auth.Authenticated;
import com.example.courseService.auth.UserContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/courses")
@RestController
public class CourseController {

    @GetMapping
    @Authenticated()
    public ResponseEntity<String> getCourses(){
        return new ResponseEntity<>("User Authenticated" + UserContextHolder.get().getId(), HttpStatus.OK);
    }

    @PostMapping
    @Authenticated()
    public ResponseEntity<String> addCourses(){
        return new ResponseEntity<>("User Authenticated" + UserContextHolder.get().getId(), HttpStatus.OK);
    }
}
