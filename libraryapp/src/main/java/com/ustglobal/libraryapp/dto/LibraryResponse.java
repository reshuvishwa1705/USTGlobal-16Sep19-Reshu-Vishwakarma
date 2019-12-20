package com.ustglobal.libraryapp.dto;

import java.util.List;

import lombok.Data;


@Data
public class LibraryResponse {
	private int statusCode;
	private String message;
	private String description;
	private UserBean userBean;
	private List<BookBean> bookBeans;
}
