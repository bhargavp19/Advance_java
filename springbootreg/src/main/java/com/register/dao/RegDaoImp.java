package com.register.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.register.model.LoginVO;
import com.register.model.NewRegVo;
import com.register.model.RegVO;

@Repository
public class RegDaoImp implements RegDao{
	
	@Autowired
	SessionFactory sessionFactory;

	public void insert(RegVO regVo) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(regVo.getLoginVo());
		session.saveOrUpdate(regVo);
	}

	public List search() {
		Session session = this.sessionFactory.openSession();
		
		Query q = session.createQuery("from RegVO");
		
		List ls = q.list();
		return ls;
	}

	public void delete(RegVO regVo,LoginVO loginVo) {
		Session session = this.sessionFactory.getCurrentSession();
		
		session.delete(regVo);
		session.delete(loginVo);
		
	}

	public List edit(RegVO regVo) {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from RegVO where id='"+regVo.getId()+"'");
		
		List ls = q.list();
		return ls;
	}

	//new 
	
	
	public void save(NewRegVo regvo) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(regvo);
	}

}
