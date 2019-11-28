package com.ustglobal.springcore.di;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Author {
	public Author() {
		System.out.println("Author Object is Created");
	}
private String name;
private String penName;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPenName() {
	return penName;
}
public void setPenName(String penName) {
	this.penName = penName;
}
@PostConstruct
public void init() {
	System.out.println("Init method executing  from Author");
}
@PreDestroy
public void destroy() {
	System.out.println("Destroy method executing  from Author");
}
}
