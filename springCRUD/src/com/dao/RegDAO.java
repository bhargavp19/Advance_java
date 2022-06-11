package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.RegVO;

@Repository
public class RegDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void insert(RegVO regVO) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(regVO);
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List search(){	
		List ls = new ArrayList();
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query q = session.createQuery("from RegVO");
			ls= q.list();
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	public void delete(RegVO regVO) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(regVO);
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public List edit(RegVO regvo){	
		List ls = new ArrayList();
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query q = session.createQuery("from RegVO where id = '"+regvo.getId()+"'");
			ls= q.list();
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
}
