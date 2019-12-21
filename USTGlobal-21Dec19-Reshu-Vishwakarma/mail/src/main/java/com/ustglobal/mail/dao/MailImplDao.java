package com.ustglobal.mail.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ustglobal.mail.dto.MailBean;
import com.ustglobal.mail.dto.UserBean;
@Repository
public class MailImplDao implements MailDAO{
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public List<MailBean> inbox(String email) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from UserBean where email=:email";
		TypedQuery<UserBean> query = manager.createQuery(jpql, UserBean.class);
		query.setParameter("email", email);
		UserBean bean;
		try {
			bean = query.getSingleResult();
			String jpql2 = "from MailBean where fromid=:fromid";
			TypedQuery<MailBean> query1 = manager.createQuery(jpql2, MailBean.class);
			query1.setParameter("fromid", bean);
			List<MailBean> beans = query1.getResultList();
			return beans;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@Override
	public String sent(String fromMail, String toMail, String msg,String sub) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		MailBean mailBean = new MailBean();
		String jpql = "from UserBean where email=:email";
		TypedQuery<UserBean> query = manager.createQuery(jpql, UserBean.class);
		query.setParameter("email", toMail);
		String jpql1 = "from UserBean where email=:email";
		TypedQuery<UserBean> query1 = manager.createQuery(jpql1, UserBean.class);
		query1.setParameter("email", fromMail);
		try {
			transaction.begin();
			UserBean bean = query1.getSingleResult();
			UserBean bean2 = query.getSingleResult();
			mailBean.setMsg(msg);
			mailBean.setFromid(bean);
			mailBean.setToid(bean2);
			mailBean.setStatus("sent");
			mailBean.setSubject(sub);
			manager.persist(mailBean);
			transaction.commit();
			return "mail sent";

		} catch (Exception e) {
			e.printStackTrace();
			return "User Does not Exist";
		}

	}
	@Override
	public String draft(String fromMail, String toMail, String msg, String sub) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		MailBean mailBean = new MailBean();
		String jpql = "from UserBean where email=:email";
		TypedQuery<UserBean> query = manager.createQuery(jpql, UserBean.class);
		query.setParameter("email", toMail);
		String jpql1 = "from UserBean where email=:email";
		TypedQuery<UserBean> query1 = manager.createQuery(jpql1, UserBean.class);
		query1.setParameter("email", fromMail);
		try {
			transaction.begin();
			UserBean bean = query1.getSingleResult();
			UserBean bean2 = query.getSingleResult();
			mailBean.setMsg(msg);
			mailBean.setFromid(bean2);
			mailBean.setToid(bean);
			mailBean.setStatus("draft");
			mailBean.setSubject(sub);
			manager.persist(mailBean);
			transaction.commit();
			return "mail saved";

		} catch (Exception e) {
			e.printStackTrace();
			return "mail not saved";
		}

	}
	@Override
	public boolean delete(MailBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			MailBean bean2 = manager.find(MailBean.class, bean.getMid());
			manager.remove(bean2);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


}
