package com.ustglobal.spring_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustglobal.spring_mvc.beans.Hotel;
import com.ustglobal.spring_mvc.beans.Retailer;
import com.ustglobal.spring_mvc.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	public ProductDao dao;
	
	@Override
	public Retailer login(int id, String password) {
		
		return dao.login(id, password);
	}

	@Override
	public int create(Retailer bean) {
		
		return dao.create(bean);
	}

	@Override
	public Retailer searchByProductId(int id) {
		
		return dao.searchByProductId(id);
	}

	@Override
	public boolean updatePassword(int id, String password) {
		
		return dao.updatePassword(id, password);
	}

	
	

	@Override
	public Hotel searchById(int retailerId) {
		
		return dao.searchById(retailerId);
	}

	@Override
	public double totalAmount(double amount) {
		
		return dao.totalAmount(amount);
	}

	@Override
	public boolean deleteProfile(int id) {
		
		return dao.deleteProfile(id);
	}


	

}
