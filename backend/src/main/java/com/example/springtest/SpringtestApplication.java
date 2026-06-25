package com.example.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringtestApplication {

	public static void main(String[] args) {
		System.out.println("Hello World");
		SpringApplication.run(SpringtestApplication.class, args);
	}

}
