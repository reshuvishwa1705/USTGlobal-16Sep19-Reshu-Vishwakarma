package com.ustglobal.libraryapp.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ustglobal.libraryapp.dto.BookBean;
import com.ustglobal.libraryapp.dto.BookIssueBean;
import com.ustglobal.libraryapp.dto.UserBean;
@Repository
public class UserImplDao implements UserBeanDAO{
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public UserBean login(String email, String password) {
		EntityManager entityManager = factory.createEntityManager();
		String jpql = "from UserBean where email=:eml and password=:pwd";
		TypedQuery<UserBean> query = entityManager.createQuery(jpql, UserBean.class);
		query.setParameter("eml", email);
		query.setParameter("pwd", password);
		try {
			UserBean bean = query.getSingleResult();
			return bean;
		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean register(UserBean bean) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		String jpql = "from UserBean where email=:eml";
		TypedQuery<UserBean> query = entityManager.createQuery(jpql, UserBean.class);
		query.setParameter("eml", bean.getEmail());
		try {
			UserBean bean2 = query.getSingleResult();
			return false;
		} catch (Exception e) {
			entityTransaction.begin();
			bean.setRole("student");
			entityManager.persist(bean);
			entityTransaction.commit();
			return true;
		}

	}

	@Override
	public boolean changePassword(String email, String password) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		String jpql = "from UserBean where email=:email";
		TypedQuery<UserBean> query = entityManager.createQuery(jpql,UserBean.class);
		query.setParameter("email", email);
		entityTransaction.begin();
		try {
			UserBean bean = query.getSingleResult();
			bean.setPassword(password);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public BookBean search(String bauthor) {
		EntityManager entityManager = factory.createEntityManager();
		String jpql = "from BookBean where bauthor=:author";
		TypedQuery<BookBean> query = entityManager.createQuery(jpql,BookBean.class);
		query.setParameter("author", bauthor);
		BookBean bean =  query.getSingleResult();
		return bean;
	}

	@Override
	public boolean issueBook(int bid, int uid) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			BookIssueBean bean = new BookIssueBean();
			BookBean bookBean = entityManager.find(BookBean.class, bid);
			UserBean userBean = entityManager.find(UserBean.class, uid);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date d = new Date();
			String s = simpleDateFormat.format(d);
			Date date = new SimpleDateFormat("yyyy/MM/dd").parse(s);
			bean.setIssueDate(date);
			bean.setBookBean(bookBean);
			bean.setUserBean(userBean);
			entityManager.persist(bean);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean returnBook(int bid, int uid) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		String jpql = "from BookIssueBean where bid=:boid and uid=:suid";
		entityTransaction.begin();
		try {
			TypedQuery<BookIssueBean> query = entityManager.createQuery(jpql,BookIssueBean.class);
			query.setParameter("boid", bid);
			query.setParameter("suid",uid);
			BookIssueBean bean = query.getSingleResult();
			BookIssueBean bean2 = entityManager.find(BookIssueBean.class, bean.getIsid());
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date d = new Date();
			String s = simpleDateFormat.format(d);
			Date date = new SimpleDateFormat("yyyy/MM/dd").parse(s);
			bean2.setReturnDate(date);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addBook(BookBean bean) {
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
	public boolean deleteBook(int bid) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			BookBean bean = entityManager.find(BookBean.class, bid);
			entityManager.remove(bean);
			entityTransaction.commit();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;		
		}
	}

	@Override
	public BookBean searchBook(int bid) {
		EntityManager entityManager = factory.createEntityManager();
		BookBean bean = entityManager.find(BookBean.class, bid);
		return bean;
	}

	@Override
	public boolean updateBook(BookBean bean) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			BookBean bean2 = entityManager.find(BookBean.class, bean.getBid());
			bean2.setBname(bean.getBname());
			bean2.setBauthor(bean.getBauthor());
			bean2.setBcopies(bean.getBcopies());
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<BookBean> getAllBook() {
		EntityManager entityManager = factory.createEntityManager();
		String jpql = "from BookBean";
		TypedQuery<BookBean> query = entityManager.createQuery(jpql,BookBean.class);
		List<BookBean> list = query.getResultList();
		return list;
	}

}
