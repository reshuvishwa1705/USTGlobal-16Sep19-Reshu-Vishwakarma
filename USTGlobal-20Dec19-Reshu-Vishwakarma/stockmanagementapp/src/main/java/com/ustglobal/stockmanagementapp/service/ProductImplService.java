package com.ustglobal.stockmanagementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustglobal.stockmanagementapp.dao.ProductImplDao;
import com.ustglobal.stockmanagementapp.dto.ProductBean;
@Service
public class ProductImplService implements ProductService{
	@Autowired
	private ProductImplDao dao;
	@Override
	public ProductBean getProductByName(String name) {
		return dao.getProductByName(name);
	}

	@Override
	public List<ProductBean> getProductByCategory(String category) {
		return dao.getProductByCategory(category);
	}

	@Override
	public List<ProductBean> getProductByCompany(String company) {
		return dao.getProductByCompany(company);
	}

	@Override
	public boolean addProduct(ProductBean bean) {
		return dao.addProduct(bean);
	}

	@Override
	public boolean modifyProduct(ProductBean bean) {
		return dao.modifyProduct(bean);
	}

	/*
	 * @Override public List<ProductBean> addProductToCart(ProductBean bean) {
	 * return dao.addProductToCart(bean); }
	 */

	@Override
	public ProductBean generateBill(List<ProductBean> beans) {
		return dao.generateBill(beans);
	}

}
