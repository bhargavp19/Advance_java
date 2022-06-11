package com.country.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.country.model.CountryVO;
import com.country.model.StateVO;

@Repository
public class CountryDaoImp implements CountryDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addCountry(CountryVO countryVO) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(countryVO);
	}

	@Override
	public void addState(StateVO stateVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(stateVO);
	}

	@Override
	public List searchCountry() {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from CountryVO");
		List ls = q.list();
		return ls;
	}

	@Override
	public List searchState() {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from StateVO");
		List ls = q.list();
		return ls;
		
	}

	@Override
	public void deleteCountry(CountryVO countryVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(countryVO);
	}

	@Override
	public void deleteState(StateVO stateVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(stateVO);
	}

	@Override
	public List editCountry(CountryVO countryVO) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from CountryVO where id="+countryVO.getId());
		List ls = q.list();
		return ls;
		}

	@Override
	public List editState(StateVO stateVO) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from StateVO where id="+stateVO.getId());
		List ls = q.list();
		return ls;
	}

	@Override
	public List state(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from StateVO where countryVO_Id="+id);
		List ls = q.list();
		return ls;
	}

	
}
