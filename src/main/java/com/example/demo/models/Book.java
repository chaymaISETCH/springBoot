package com.example.demo.models;
import java.util.*;

import javax.persistence.*;


@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	private String title,isbn,publisher;

	@ManyToMany
	@JoinTable(name="autor_book", joinColumns= @JoinColumn(name="book_id"),
	inverseJoinColumns = @JoinColumn(name="author_id"))
	private Set<Author> authors = new HashSet<Author>();

	public Book(String title, String isbn, String publisher, Set<Author> authors) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
		this.authors = authors;
	}

	public Book(String title, String isbn, String publisher) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Set<Author> getAuthors() {
		return new HashSet(authors);
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", publisher=" + publisher;
	}





}
