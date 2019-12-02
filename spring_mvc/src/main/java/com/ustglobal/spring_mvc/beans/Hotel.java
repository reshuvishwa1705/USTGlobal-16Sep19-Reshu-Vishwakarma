package com.ustglobal.spring_mvc.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Entity
@Table(name="menucard")
public class Hotel {
	@Id
	@Column
	@GeneratedValue
	private int orderId;
	@Column
	private String productName;
	@Column
	private int pricePerUnit;
	@Column
	private int quantity;
	@Column
	private int amount;
	@Column
	private int retailerId;
	
	@Exclude
	@ManyToMany(cascade = CascadeType.ALL , mappedBy = "hotel")
	private List<Retailer> retailer;

}
