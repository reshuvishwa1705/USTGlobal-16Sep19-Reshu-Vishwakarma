package com.ustglobal.libraryapp.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
@Entity 
@Table(name="bookissue")
public class BookIssueBean {
	@Id
	@Column
	@GeneratedValue
	private int isid;
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date issueDate;
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date returnDate;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bid")
	private BookBean bookBean;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="uid")
	private UserBean userBean;

}
