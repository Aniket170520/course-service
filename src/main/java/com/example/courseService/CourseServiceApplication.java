package com.example.courseService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class CourseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseServiceApplication.class, args);
		ApplicationContext applicationContext = new GenericApplicationContext();
		System.out.println(applicationContext.getApplicationName());
		System.out.println(applicationContext.getDisplayName());
		System.out.println(applicationContext.getId());
	}

}
