package com.ustglobal.spring_mvc.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "retailer_table")
public class Retailer {
	
	@Id
	@Column
	@GeneratedValue    //auto increament value
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String password;
	
	@Column(unique = true)
	private String email;
	
@ManyToMany(cascade = CascadeType.ALL)
	
	//user_order is new table created automatically created by hbm2ddl.auto
	@JoinTable(name = "user_order" ,  joinColumns = @JoinColumn(name = "id"),
	inverseJoinColumns = @JoinColumn(name = "orderId"))

	private List<Hotel> hotel ;


	
	
}