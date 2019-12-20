package com.ustglobal.stockmanagementapp.dto;

import java.util.List;

import lombok.Data;

@Data
public class StockResponse {
	private int statusCode;
	private String message;
	private String description;
	private ProductBean bean;
	private List<ProductBean> beans;
}
