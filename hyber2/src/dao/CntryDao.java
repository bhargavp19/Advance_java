package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.*;



public class CntryDao {

	public void insertcntry(CntryVo cntryVo){
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(cntryVo);
			
			transaction.commit();
			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void insertstate(StateVo stateVo){
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(stateVo);
			
			transaction.commit();
			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void delete(CntryVo cntryVo){
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.delete(cntryVo);
			
			
			transaction.commit();
			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public List edit(CntryVo cntryVo){
		List ls = new ArrayList();
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from CntryVo where id='"+cntryVo.getId()+"'");
			
			ls=q.list();
			
			transaction.commit();
			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}
	public List editstate(StateVo stateVo){
		List ls = new ArrayList();
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from StateVo where id='"+stateVo.getId()+"'");
			
			ls=q.list();
			
			transaction.commit();
			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}
	public List searchCntry(){
		List ls = new ArrayList();
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q= session.createQuery("from CntryVo");
			
			ls = q.list();
			
			transaction.commit();
			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}
	public List searchState(){
		List ls = new ArrayList();
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q= session.createQuery("from StateVo");
			
			ls = q.list();
			
			transaction.commit();
			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}
	public void update(CntryVo cntryVo){
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.update(cntryVo);
			
			
			transaction.commit();
			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void updatestate(StateVo stateVo){
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.update(stateVo);
			
			
			transaction.commit();
			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
