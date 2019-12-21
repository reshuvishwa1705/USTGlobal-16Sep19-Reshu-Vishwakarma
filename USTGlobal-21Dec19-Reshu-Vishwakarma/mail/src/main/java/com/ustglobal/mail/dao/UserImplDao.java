package com.ustglobal.mail.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ustglobal.mail.dto.UserBean;
@Repository
public class UserImplDao implements UserDAO{
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public boolean register(UserBean userBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String jpql = "from UserBean where email=:email";
		TypedQuery<UserBean> query = manager.createQuery(jpql, UserBean.class);
		query.setParameter("email", userBean.getEmail());
		try {
			transaction.begin();
			UserBean bean = query.getSingleResult();
			return false;

		}catch(Exception e) {
			manager.persist(userBean);
			transaction.commit();
			return true;
		}
	}
	@Override
	public UserBean login(String email, String password) {
		String jpql = "from UserBean where email=:email and password=:password";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<UserBean> query = manager.createQuery(jpql, UserBean.class);

		query.setParameter("email", email);
		query.setParameter("password", password);
		try {
			UserBean userBean = query.getSingleResult();
			return userBean;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean changePassword(UserBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String jpql = "from UsersBean where email=:email";
		EntityManager em = factory.createEntityManager();
		TypedQuery<UserBean> query = em.createQuery(jpql, UserBean.class);
		query.setParameter("email", bean.getEmail());
		try {
			transaction.begin();
			UserBean userbean1 = query.getSingleResult();
			UserBean bean1 = manager.find(UserBean.class, userbean1.getUid());
			bean1.setPassword(bean.getPassword());
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}	}

}
