package com.ustglobal.libraryapp.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString.Exclude;
@Data
@Entity
@Table(name="book")
public class BookBean {
	@Id
	@Column
	private int bid;
	@Column
	private String bname;
	@Column(unique = true,nullable = false)
	private String bauthor;
	@Column
	private int bcopies;
	@JsonIgnore
	@Exclude
	@OneToMany(mappedBy = "bookBean")
	private List<BookIssueBean> bookIssueBeans;
	
}
