package com.ustglobal.mail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustglobal.mail.dao.MailDAO;
import com.ustglobal.mail.dto.MailBean;
import com.ustglobal.mail.dto.UserBean;
@Service
public class MailImplService implements MailService{
	@Autowired
	private MailDAO dao;
	@Override
	public List<MailBean> inbox(String email) {
		return dao.inbox(email);
	}

	@Override
	public String sent(String fromMail, String toMail, String msg, String sub) {
		return dao.sent(fromMail, toMail, msg, sub);
	}

	@Override
	public String draft(String fromMail, String toMail, String msg, String sub) {
		return dao.draft(fromMail, toMail, msg, sub);
	}

	@Override
	public boolean delete(MailBean bean) {
		return dao.delete(bean);
	}

}
