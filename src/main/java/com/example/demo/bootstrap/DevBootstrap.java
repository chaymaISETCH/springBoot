package com.example.demo.bootstrap;

import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.models.*;
import com.example.demo.repositories.AuthorRepo;
import com.example.demo.repositories.BookRepo;
import com.example.demo.repositories.PublisherRepo;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	//event listener, ContextRefreshedEvent creation de l'app

	private AuthorRepo authorRepo;
	private BookRepo bookRepo;
	private PublisherRepo publisherRepo;

	public DevBootstrap(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
		super();
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.publisherRepo = publisherRepo;
	}

	private void initData() {

		Author a = new Author("chaima","trabelsi");
		Publisher pp = new Publisher("chaimmaaa","tunis");
		publisherRepo.save(pp);
		Book b = new Book("uml par la pratique","123456",pp);
		a.getBooks().add(b);
		Set<Author> s =b.getAuthors();
		s.add(a);
		b.setAuthors(s);

		authorRepo.save(a);
		bookRepo.save(b);
		System.out.println(a.getId());
		Publisher p = new Publisher("chaimmaaa","tunis",b);
		System.out.println(p.getBook());
		publisherRepo.save(p);

		Book b2 = new Book("javascript ninja","123456789",p);
		Author a2 = new Author("ahlem","trabelsi");
		System.out.println("app refresh hello bootstrap class");
		authorRepo.save(a2);
		bookRepo.save(b2);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//
		initData();
		
	}


}
