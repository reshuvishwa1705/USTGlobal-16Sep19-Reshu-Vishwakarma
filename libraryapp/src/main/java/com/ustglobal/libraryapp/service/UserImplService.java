package com.ustglobal.libraryapp.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustglobal.libraryapp.dao.UserBeanDAO;
import com.ustglobal.libraryapp.dto.BookBean;
import com.ustglobal.libraryapp.dto.UserBean;

@Service
public class UserImplService implements UserService{
@Autowired
UserBeanDAO dao;
	@Override
	public UserBean login(String email, String password) {
		return dao.login(email, password);
	}

	@Override
	public boolean register(UserBean bean) {
		return dao.register(bean);
	}

	@Override
	public boolean changePassword(String email, String password) {
		return dao.changePassword(email, password);
	}

	@Override
	public BookBean search(String bauthor) {
		return dao.search(bauthor);
	}

	@Override
	public boolean issueBook(int bid, int uid) {
		return dao.issueBook(bid, uid);
	}

	@Override
	public boolean returnBook(int bid, int uid) {
		return dao.returnBook(bid, uid);
	}

	@Override
	public boolean addBook(BookBean bean) {
		return dao.addBook(bean);
	}

	@Override
	public boolean deleteBook(int bid) {
		return dao.deleteBook(bid);
	}

	@Override
	public BookBean searchBook(int bid) {
		return dao.searchBook(bid);
	}

	@Override
	public boolean updateBook(BookBean bean) {
		return dao.updateBook(bean);
	}

	@Override
	public List<BookBean> getAllBook() {
		return dao.getAllBook();
	}

}
