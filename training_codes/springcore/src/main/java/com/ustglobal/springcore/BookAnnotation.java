package com.ustglobal.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ustglobal.springcore.config.BookConfiguration;
import com.ustglobal.springcore.di.Book;

public class BookAnnotation {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BookConfiguration.class);
	Book book = context.getBean(Book.class);
	System.out.println("Book Name "+book.getName());
	System.out.println("Book Price "+book.getPrice());
	System.out.println("Book Author Name "+book.getAuthor().getName());
	System.out.println("Book Pen Name "+book.getAuthor().getPenName());
	System.out.println("****************************");
	context.close();
}
}
