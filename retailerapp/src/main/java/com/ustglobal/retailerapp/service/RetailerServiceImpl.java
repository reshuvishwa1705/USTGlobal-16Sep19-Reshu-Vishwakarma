package com.ustglobal.retailerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustglobal.retailerapp.dao.RetailerImplDao;
import com.ustglobal.retailerapp.dto.OrderBean;
import com.ustglobal.retailerapp.dto.RetailerBean;
@Service
public class RetailerServiceImpl implements RetailerService{
@Autowired
RetailerImplDao dao;
	@Override
	public boolean createProfile(RetailerBean bean) {
		return dao.createProfile(bean);
	}

	@Override
	public RetailerBean login(int retailerId, String password) {
		return dao.login(retailerId, password);
	}

	@Override
	public OrderBean searchProduct(int pid) {
		return dao.searchProduct(pid);
	}

	@Override
	public boolean updatePassword(int retailerId, String password) {
		return dao.updatePassword(retailerId, password);
	}

	@Override
	public double sumAmount(int retailerId) {
		return dao.sumAmount(retailerId);
	}

	@Override
	public OrderBean retrieveOrder(int retailerId) {
		return dao.retrieveOrder(retailerId);
	}

}
