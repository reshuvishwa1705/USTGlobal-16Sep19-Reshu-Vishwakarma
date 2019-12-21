package com.ustglobal.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustglobal.mail.dao.UserDAO;
import com.ustglobal.mail.dto.UserBean;
@Service
public class UserImplService implements UserService{
	@Autowired
	private UserDAO dao;
	@Override
	public boolean register(UserBean userBean) {
		return dao.register(userBean);
	}

	@Override
	public UserBean login(String email, String password) {
		return dao.login(email, password);
	}

	@Override
	public boolean changePassword(UserBean bean) {
		return dao.changePassword(bean);
	}

}
