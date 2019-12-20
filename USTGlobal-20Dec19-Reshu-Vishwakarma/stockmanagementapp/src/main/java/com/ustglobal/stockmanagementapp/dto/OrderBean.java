package com.ustglobal.stockmanagementapp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;
@Data
@Entity
@Table(name="order_info")
public class OrderBean {
	@Id
	@Column
	@GeneratedValue
	int oid;
	@Column
	double total_price;
	@Column
	double total_price_with_gst;
	@Exclude
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "orderBeans")
	List<ProductBean> productBeans;
}
