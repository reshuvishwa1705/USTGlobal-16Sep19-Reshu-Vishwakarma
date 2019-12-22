package com.ustglobal.stockmanagementapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ustglobal.stockmanagementapp.dto.ProductBean;
@Repository
public class ProductImplDao implements ProductDAO{
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public ProductBean getProductByName(String name) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from ProductBean where name=:name";
		TypedQuery<ProductBean> query = manager.createQuery(jpql, ProductBean.class);
		query.setParameter("name", name);
		try {
			ProductBean bean = query.getSingleResult();
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ProductBean> getProductByCategory(String category) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from ProductBean where category=:category";
		TypedQuery<ProductBean> query = manager.createQuery(jpql, ProductBean.class);
		query.setParameter("category", category);
		try {
			List<ProductBean> beans = query.getResultList();
			return beans;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ProductBean> getProductByCompany(String company) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from ProductBean where company=:company";
		TypedQuery<ProductBean> query = manager.createQuery(jpql, ProductBean.class);
		query.setParameter("company", company);
		try {
			List<ProductBean> beans = query.getResultList();
			return beans;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addProduct(ProductBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		int qty = 0;
		String jpql = "from ProductBean where name=:name";
		TypedQuery<ProductBean> query = manager.createQuery(jpql, ProductBean.class);
		query.setParameter("name", bean.getName());
		transaction.begin();
		try {
			ProductBean bean2 = query.getSingleResult();
			qty = bean2.getQuantity() + bean.getQuantity();
			ProductBean productBean = manager.find(ProductBean.class, bean2.getPid());
			productBean.setQuantity(qty);
			return false;
		} catch (Exception e) {
			manager.persist(bean);
			transaction.commit();
			return true;
		}
	}

	@Override
	public boolean modifyProduct(ProductBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			ProductBean productBean = manager.find(ProductBean.class, bean.getPid());
			productBean.setName(bean.getName());
			productBean.setCategory(bean.getCategory());
			productBean.setCompany(bean.getCompany());
			productBean.setPrice(bean.getPrice());
			productBean.setQuantity(bean.getQuantity());
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.out.println("Product Not Found "+e);
			return false;
		}
	}
	
	/*
	 * @Override public List<ProductBean> addProductToCart(ProductBean bean) { int
	 * qty; List<ProductBean> list = new ArrayList<ProductBean>(); EntityManager
	 * manager = factory.createEntityManager(); String jpql =
	 * "from ProductBean name=:name"; TypedQuery<ProductBean> query =
	 * manager.createQuery(jpql, ProductBean.class); query.setParameter("name",
	 * bean.getName()); ProductBean productBean = query.getSingleResult(); qty =
	 * productBean.getQuantity(); if(qty>0) { qty--; productBean.setQuantity(qty);
	 * boolean check = modifyProduct(productBean); }else { return null; }
	 * list.add(bean); return true; }
	 */

	@Override
	public ProductBean generateBill(List<ProductBean> beans) {
		double price = 0.0;
		int qty = 0;
		int quant = 0;
		boolean b = false;
		String pname = "";
		for (ProductBean productBean : beans) {
			price = price + productBean.getPrice();
			qty = qty + productBean.getQuantity();
			pname = pname + productBean.getName() + ",";
			quant = productBean.getQuantity();
			--quant;
			productBean.setQuantity(quant);
			b = modifyProduct(productBean);
		}
		ProductBean bean = new ProductBean();
		bean.setPrice(price);
		bean.setQuantity(qty);
		bean.setName(pname);
		return bean;
	}

	@Override
	public List<ProductBean> getAllProduct() {
	 EntityManager manager  = factory.createEntityManager();
	 String jpql = "from ProductBean";
	 TypedQuery<ProductBean> query = manager.createQuery(jpql,ProductBean.class);
	 List<ProductBean> beans = query.getResultList();
	 return beans;
	}

}
