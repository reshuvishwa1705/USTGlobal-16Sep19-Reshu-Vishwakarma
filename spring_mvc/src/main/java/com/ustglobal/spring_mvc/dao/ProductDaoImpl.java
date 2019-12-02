package com.ustglobal.spring_mvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ustglobal.spring_mvc.beans.Hotel;
import com.ustglobal.spring_mvc.beans.Retailer;

@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceUnit
	private EntityManagerFactory factory;


	@Override
	public Retailer login(int id, String password) {
		String jpql = "from Retailer where id=:id and password=:password";
		EntityManager entityManager = factory.createEntityManager();
		TypedQuery<Retailer> query = entityManager.createQuery(jpql, Retailer.class);
		query.setParameter("id", id);
		query.setParameter("password", password);
		try {
			Retailer re = query.getSingleResult();
			return re;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}// end of login

	@Override
	public int create(Retailer bean) {
		
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			entityManager.persist(bean);
			entityTransaction.commit();
			return bean.getId();

		} catch (Exception e) {
			
			e.printStackTrace();
			entityTransaction.rollback();
			return -1;
		}

	}//end of create profile

	@Override
	public Retailer searchByProductId(int id) {
		EntityManager entityManager = factory.createEntityManager();
		return  entityManager.find(Retailer.class, id);
	}//end of searchById

	@Override
	public boolean updatePassword(int id, String password) {
		
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Retailer bean = entityManager.find(Retailer.class, id);
		bean.setPassword(password);
		entityTransaction.commit();
		return true;
	}//end of updatePassword

	@Override
	public boolean deleteProfile(int id) {
		
		EntityManager entityManager = factory.createEntityManager();
	                     	EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Retailer bean = entityManager.find(Retailer.class, id);
		entityManager.remove(bean);

		entityTransaction.commit();

		return true;
	}

	@Override
	public Hotel searchById(int retailerId) {
		
		EntityManager entityManager = factory.createEntityManager();
		return  entityManager.find(Hotel.class, retailerId);
	}

	@Override
	public double totalAmount(double amount) {
		
		return 0;
	}

}