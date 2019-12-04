package com.ustglobal.retailerapp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.bytebuddy.build.ToStringPlugin.Exclude;

@Entity
@Table(name="retailer")
public class RetailerBean {
	@Id
	@Column
	private int retailerId;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	@Exclude
	@OneToMany(mappedBy = "retailerBean")
	private List<OrderBean> orderBean;
	public List<OrderBean> getOrderBean() {
		return orderBean;
	}
	public void setOrderBean(List<OrderBean> orderBean) {
		this.orderBean = orderBean;
	}
	public int getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
