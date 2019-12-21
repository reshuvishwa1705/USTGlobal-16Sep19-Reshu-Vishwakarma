package com.ustglobal.mail.service;

import com.ustglobal.mail.dto.UserBean;

public interface UserService {
	public boolean register(UserBean userBean);
	public UserBean login(String email, String password);
	public boolean changePassword(UserBean bean);

}
