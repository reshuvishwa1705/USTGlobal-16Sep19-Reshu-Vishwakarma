package com.ustglobal.mail.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name = "mail_info")
public class MailBean {
	@Id
	@Column
	@GeneratedValue
	private int mid;
	@Column
	private String subject;
	@Column
	private String msg;
	@Column
	private String status;
	@Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	private UserBean fromid;
	@Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	private UserBean toid;
	


}
