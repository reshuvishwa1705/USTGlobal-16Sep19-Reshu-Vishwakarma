package com.ustglobal.retailerapp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.bytebuddy.build.ToStringPlugin.Exclude;

@Entity
@Table(name="orderInfo")
public class OrderBean {
	@Id
	@Column
	private int orderId;
	@Column
	private int price;
	@Column
	private double quantity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pname", nullable = false)
	private ProductBean productBean;

	@Column
	private double amount;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="retailerId", nullable = false)
	private RetailerBean retailerBean;

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public ProductBean getProductBean() {
		return productBean;
	}
	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}
	public RetailerBean getRetailerBean() {
		return retailerBean;
	}
	public void setRetailerBean(RetailerBean retailerBean) {
		this.retailerBean = retailerBean;
	}






}
