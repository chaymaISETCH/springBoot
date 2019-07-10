package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.models.Author;
import com.example.demo.models.Book;

@SpringBootApplication
public class AppJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppJpaApplication.class, args);
	
	}

}
