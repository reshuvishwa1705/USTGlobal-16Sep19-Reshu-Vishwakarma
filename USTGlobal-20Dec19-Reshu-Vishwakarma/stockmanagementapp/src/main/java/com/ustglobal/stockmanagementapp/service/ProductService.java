package com.ustglobal.stockmanagementapp.service;

import java.util.List;

import com.ustglobal.stockmanagementapp.dto.ProductBean;

public interface ProductService {
	public ProductBean getProductByName(String name);
	public List<ProductBean> getProductByCategory(String category);
	public List<ProductBean> getProductByCompany(String company);
	public boolean addProduct(ProductBean bean);
	public boolean modifyProduct(ProductBean bean);
//	public List<ProductBean> addProductToCart(ProductBean bean);
	public ProductBean generateBill(List<ProductBean> beans);
}
