package com.ustglobal.retailerapp.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.bytebuddy.build.ToStringPlugin.Exclude;


@Entity 
@Table (name="product")
public class ProductBean {

	@Column(unique = true)
	private int pid;
	@Id
	@Column
	private String pname;
	@Exclude
	@OneToMany(mappedBy = "productBean")
	private List<OrderBean> orderBeans;
	public List<OrderBean> getOrderBeans() {
		return orderBeans;
	}
	public void setOrderBeans(List<OrderBean> orderBeans) {
		this.orderBeans = orderBeans;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
}
