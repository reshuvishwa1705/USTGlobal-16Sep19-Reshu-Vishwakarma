package com.ustglobal.stockmanagementapp.dto;

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
@Table(name="products_info")
public class ProductBean {
	@Id
	@Column
	@GeneratedValue
	int pid;
	@Column (unique = true)
	String name;
	@Column
	String category;
	@Column
	String company;
	@Column
	int quantity;
	@Column
	double price;
	@ManyToMany (cascade = CascadeType.ALL)
	@JoinTable(name = "order_history_info", joinColumns = @JoinColumn(name = "pid"), inverseJoinColumns = @JoinColumn(name = "oid"))
	List<OrderBean> orderBeans;
}
