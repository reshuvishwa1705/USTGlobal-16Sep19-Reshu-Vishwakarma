package com.ustglobal.mail.service;

import java.util.List;

import com.ustglobal.mail.dto.MailBean;
import com.ustglobal.mail.dto.UserBean;

public interface MailService {
	public List<MailBean> inbox(String email);
	public String sent(String fromMail, String toMail, String msg,String sub);
	public String draft(String fromMail, String toMail, String msg,String sub);
	public boolean delete(MailBean bean);
}
