package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Author;
import com.example.demo.repositories.AuthorRepo;

@Controller
public class AuthorController {
	
	/** hibernate object created by spring
	the same name as norme */
	private AuthorRepo authorRepo;

	public AuthorController(AuthorRepo authorRepo) {
		this.authorRepo = authorRepo;
	}

	@RequestMapping(value = "/authors")
	public String getAuthors(Model model) {
		System.out.println(authorRepo.findById(1L));
		
		model.addAttribute("authors",authorRepo.findAll());
		return "authors";
		
	}
	
	
}
