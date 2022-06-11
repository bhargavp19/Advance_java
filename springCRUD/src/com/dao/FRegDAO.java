package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.FRegVO;
import com.model.LoginVO;
import com.model.RegVO;


@Repository
public class FRegDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(FRegVO fregVO){
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(fregVO.getLoginVO());
			session.saveOrUpdate(fregVO);
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List search(){
		
		List ls =(List) new ArrayList();
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query q = session.createQuery("from FRegVO");
			ls = (List) q.list();
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ls;
	}

	public void delete(FRegVO fregVO,LoginVO loginVO) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.delete(fregVO);
			session.delete(loginVO);
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List edit(FRegVO fregVO){
		
		List ls = new ArrayList();
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query q = session.createQuery("from FRegVO where id='"+fregVO.getId()+"'");
			ls =  q.list();
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ls;
	}

}
