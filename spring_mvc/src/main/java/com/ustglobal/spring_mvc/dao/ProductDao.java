package com.ustglobal.spring_mvc.dao;

import com.ustglobal.spring_mvc.beans.Hotel;
import com.ustglobal.spring_mvc.beans.Retailer;

public interface ProductDao {
	
	public Retailer login(int id , String password);

	public int create(Retailer bean);
	
	public Retailer searchByProductId(int id);
	
	public boolean updatePassword(int id , String password);
	
	public double totalAmount(double amount);
	
	public boolean deleteProfile(int id);
	
	public Hotel searchById(int retailerId);
	
}
