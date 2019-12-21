package com.ustglobal.mail.dao;

import com.ustglobal.mail.dto.UserBean;

public interface UserDAO {
	public boolean register(UserBean userBean);
	public UserBean login(String email, String password);
	public boolean changePassword(UserBean bean);
}
