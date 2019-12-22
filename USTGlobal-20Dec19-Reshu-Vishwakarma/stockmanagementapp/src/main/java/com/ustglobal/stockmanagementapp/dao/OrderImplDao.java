package com.ustglobal.stockmanagementapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ustglobal.stockmanagementapp.dto.OrderBean;
@Repository
public class OrderImplDao implements OrderDAO{
@Autowired
private EntityManagerFactory factory;
	@Override
	public boolean addOrder(OrderBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
