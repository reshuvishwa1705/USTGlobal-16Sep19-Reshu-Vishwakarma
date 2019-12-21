package com.ustglobal.mail.dto;
import java.util.List;

import lombok.Data;
@Data
public class MailResponse {
	private int statusCode;
	private String message;
	private String description;
	private UserBean userBean;
	private List<MailBean> mailBeans;
}
