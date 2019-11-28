package com.ustglobal.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ustglobal.springcore.di.Hello;
import com.ustglobal.springcore.di.Pet;

public class XMLComponentScanApp {
public static void main(String[] args) {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	Hello hello = context.getBean(Hello.class);
	hello.setMsg("I Love Java");
	System.out.println(hello.getMsg());
	System.out.println("-----------------");
	Pet pet = context.getBean(Pet.class);
	pet.setName("Puepie");
	System.out.println("Pet Name "+pet.getName());
	pet.getAnimal().makeSound();
	
	
}
}
