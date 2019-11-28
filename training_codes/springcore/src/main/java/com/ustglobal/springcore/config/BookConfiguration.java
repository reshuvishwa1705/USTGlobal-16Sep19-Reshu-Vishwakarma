package com.ustglobal.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ustglobal.springcore.di.Author;
import com.ustglobal.springcore.di.Book;

@Configuration
public class BookConfiguration {
	@Bean(name="book")
	public Book getBook() {
		Book book = new Book();
		book.setAuthor(getAuthor());
		book.setName("Rinki");
		book.setPrice(200);
		return book;
	}
	@Bean(name="author")
public Author getAuthor() {
	Author author = new Author();
	author.setName("RS Sharma");
	author.setPenName("xyz");
	return author;
}
}
