package com.ustglobal.stockmanagementapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustglobal.stockmanagementapp.dao.OrderDAO;
import com.ustglobal.stockmanagementapp.dto.OrderBean;

@Service
public class OrderImplService implements OrderService{
@Autowired
OrderDAO dao;

@Override
public boolean addOrder(OrderBean bean) {
	return dao.addOrder(bean);
}

}
