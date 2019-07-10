package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepo;

@Controller
public class BookController {
	
	/** hibernate object created by spring
	the same name as norme */
	private BookRepo bookRepo;

	public BookController(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	@RequestMapping(value = "/books")
	public String getBooks(Model model) {
		System.out.println(bookRepo.findById(1L));
		
		model.addAttribute("books",bookRepo.findAll());
		return "books";
		
	}
	
	
}
