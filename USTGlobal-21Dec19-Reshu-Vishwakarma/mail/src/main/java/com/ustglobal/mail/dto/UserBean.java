package com.ustglobal.mail.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_info")
public class UserBean {
	@Id
	@Column
	@GeneratedValue
	private int uid;
	@Column
	private String uname;
	@Column(unique = true)
	private String email;
	@Column
	private String password;
	@OneToMany
	private List<MailBean> mailBeans;
	
	
	
}
