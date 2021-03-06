package com.ustglobal.retailerapp.service;

import com.ustglobal.retailerapp.dto.OrderBean;
import com.ustglobal.retailerapp.dto.RetailerBean;

public interface RetailerService{
	public boolean createProfile(RetailerBean bean);
	public RetailerBean login(int retailerId, String password);
	public OrderBean searchProduct(int pid);
	public boolean updatePassword(int retailerId, String password);
	public double sumAmount(int  retailerId);
	public OrderBean retrieveOrder(int retailerId);
}
