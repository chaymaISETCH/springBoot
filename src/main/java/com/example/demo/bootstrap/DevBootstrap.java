package com.example.demo.bootstrap;

import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.models.*;
import com.example.demo.repositories.AuthorRepo;
import com.example.demo.repositories.BookRepo;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	//event listener, ContextRefreshedEvent creation de l'app

	private AuthorRepo authorRepo;
	private BookRepo bookRepo;

	public DevBootstrap(AuthorRepo authorRepo, BookRepo bookRepo) {
		super();
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
	}

	private void initData() {

		Author a = new Author("chaima","trabelsi");
		Book b = new Book("uml par la pratique","123456","chaimaP");

		a.getBooks().add(b);
		Set<Author> s =b.getAuthors();
		s.add(a);
		b.setAuthors(s);

		authorRepo.save(a);
		bookRepo.save(b);

		Book b2 = new Book("javascript ninja","123456789","ninja");
		Author a2 = new Author("ahlem","trabelsi");
		System.out.println("app refresh hello bootstrap class");

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//
		initData();
		
	}


}
