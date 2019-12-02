package com.ustglobal.retailerapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ustglobal.retailerapp.dto.OrderBean;
import com.ustglobal.retailerapp.dto.ProductBean;
import com.ustglobal.retailerapp.dto.RetailerBean;
@Repository
public class RetailerImplDao implements RetailerDAO{
	@PersistenceUnit
	EntityManagerFactory factory;
	@Override
	public boolean createProfile(RetailerBean bean) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			entityManager.persist(bean);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public RetailerBean login(int retailerId, String password) {
		EntityManager entityManager = factory.createEntityManager();
		String jpql = "from RetailerBean where retailerId=:id and password=:pwd";
		TypedQuery<RetailerBean> query = entityManager.createQuery(jpql, RetailerBean.class);
		query.setParameter("id", retailerId);
		query.setParameter("pwd", password);
		try {
			RetailerBean bean = query.getSingleResult();
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public OrderBean searchProduct(int pid) {
		EntityManager entityManager = factory.createEntityManager();
		OrderBean bean = entityManager.find(OrderBean.class, pid);
		return bean;
	}

	@Override
	public boolean updatePassword(int retailerId, String password) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		RetailerBean bean = entityManager.find(RetailerBean.class, retailerId);
		bean.setPassword(password);
		entityTransaction.commit();
		return true;
	}

	@Override
	public double sumAmount(int retailerId) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		OrderBean bean = entityManager.find(OrderBean.class, retailerId);
		return bean.getAmount() ;
	}

	@Override
	public OrderBean retrieveOrder(int retailerId) {
		EntityManager entityManager = factory.createEntityManager();
		List<OrderBean> l = (List<OrderBean>)entityManager.find(OrderBean.class, retailerId);
		OrderBean bean = new OrderBean();
		for (OrderBean orderBean : l) {
			bean.setPrice(orderBean.getOrderId());
			bean.setPrice(orderBean.getPrice());
			bean.setQuantity(orderBean.getQuantity());
			bean.setAmount(orderBean.getAmount());
		}
		return bean;
	}

}
