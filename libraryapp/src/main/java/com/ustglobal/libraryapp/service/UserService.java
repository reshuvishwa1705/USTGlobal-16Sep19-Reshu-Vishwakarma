package com.ustglobal.libraryapp.service;

import java.util.List;

import com.ustglobal.libraryapp.dto.BookBean;
import com.ustglobal.libraryapp.dto.UserBean;

public interface UserService {
	public UserBean login(String email, String password);
	public boolean register(UserBean bean);
	public boolean changePassword(String email,String password);
	public BookBean search(String bauthor);
	public boolean issueBook(int bid, int uid);
	public boolean returnBook(int bid, int uid);
	public boolean addBook(BookBean bean);
	public boolean deleteBook(int bid);
	public BookBean searchBook(int bid);
	public boolean updateBook(BookBean bean);
	public List<BookBean> getAllBook();
}
