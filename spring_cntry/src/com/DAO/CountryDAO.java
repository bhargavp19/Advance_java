package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.CountryVO;
import com.VO.StateVO;



@Repository
public class CountryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void insertCntry(CountryVO cntryVO) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(cntryVO);
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List cntrysearch(){	
		List ls = new ArrayList();
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query q = session.createQuery("from CountryVO");
			ls= q.list();
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	public void deleteCntry(CountryVO cntryVO) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(cntryVO);
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List editcntry(CountryVO cntryVO){	
		List ls = new ArrayList();
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query q = session.createQuery("from CountryVO where id='"+cntryVO.getId()+"'");
			ls= q.list();
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	public void insertState(StateVO stateVO) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(stateVO);
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public List statesearch() {
		List ls = new ArrayList();
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query q = session.createQuery("from StateVO");
			ls= q.list();
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	public void deletestate(StateVO stateVO) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(stateVO);
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List editstate(StateVO stateVO) {
		List ls = new ArrayList();
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query q = session.createQuery("from StateVO where id='"+stateVO.getId()+"'");
			ls= q.list();
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
}
