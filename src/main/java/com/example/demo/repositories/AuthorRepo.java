package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Author;

public interface AuthorRepo extends CrudRepository<Author, Long>{

	
	
}
