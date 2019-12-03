package com.ustglobal.springrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ustglobal.springrest.dto.EmployeeBean;
@Repository
public class EmployeeDaoImpl implements EmployeeDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public boolean addEmployee(EmployeeBean bean) {
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
	public boolean modifyEmployee(EmployeeBean bean) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		EmployeeBean bean2 = entityManager.find(EmployeeBean.class, bean.getId());
		bean2.setName(bean.getName());
		bean2.setPassword(bean.getPassword());
		bean2.setGender(bean.getGender());
		bean2.setDoj(bean.getDoj());
		entityTransaction.commit();
		return true;
	}

	@Override
	public boolean deleteEmployee(int id) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		EmployeeBean bean = entityManager.find(EmployeeBean.class, id);
		if(bean!=null) {
		entityManager.remove(bean);
		entityTransaction.commit();
		return true;
		} else {
			return false;
		}
	}

	@Override
	public EmployeeBean getEmployee(int id) {
		EntityManager entityManager = factory.createEntityManager();
		EmployeeBean bean = entityManager.find(EmployeeBean.class, id);
		return bean;
	}

	@Override
	public List<EmployeeBean> getAllEmployee() {
		EntityManager entityManager = factory.createEntityManager();
		String jpql = "from EmployeeBean"; 
		//need not to downcast so we use TypedQuery<EmployeeBean> 
		TypedQuery<EmployeeBean> query =entityManager.createQuery(jpql,EmployeeBean.class);
		List<EmployeeBean> list = query.getResultList();
		return list;
	}

}
