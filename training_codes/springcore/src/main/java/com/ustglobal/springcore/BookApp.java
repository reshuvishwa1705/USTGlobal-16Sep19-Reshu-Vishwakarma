package com.ustglobal.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ustglobal.springcore.di.Author;
import com.ustglobal.springcore.di.Book;

public class BookApp {
public static void main(String[] args) {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bookbean.xml");
	Book book = context.getBean(Book.class);
	System.out.println("Book Name "+book.getName());
	System.out.println("Book Price "+book.getPrice());
	System.out.println("Book Author Name "+book.getAuthor().getName());
	System.out.println("Book Pen Name "+book.getAuthor().getPenName());
	System.out.println("****************************");
	Author author = context.getBean(Author.class);
	System.out.println(author.getName());
	System.out.println(author.getPenName());
	context.close();
}
}
