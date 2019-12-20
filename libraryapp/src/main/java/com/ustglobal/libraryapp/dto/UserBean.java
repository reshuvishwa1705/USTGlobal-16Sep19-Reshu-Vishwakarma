package com.ustglobal.libraryapp.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name="user")
public class UserBean {
@Id
@GeneratedValue
@Column
private int uid;
@Column
private String uname;
@Column(unique = true)
private String email;
@Column
private String password;
@Column
private String role;
@JsonIgnore
@Exclude
@OneToMany(mappedBy = "userBean")
private List<BookIssueBean> bookIssueBeans ;

}
