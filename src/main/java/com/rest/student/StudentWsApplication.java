package com.rest.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;







@SpringBootApplication
@ComponentScan(basePackages = {"com.rest.student","controller","dao"})
public class StudentWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentWsApplication.class, args);
		System.out.println("hello world");
	}

}
