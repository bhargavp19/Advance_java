package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import java.util.*;
import vo.LoginVo;
import vo.RegVo;

public class RegDao {
	
	public void insertlogin(LoginVo loginVo){
		try{
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(loginVo);
			
			transaction.commit();
			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void insertreg(RegVo regVo){
		try{
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(regVo);
			
			transaction.commit();
			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List search(){
		List ls = new ArrayList();
		try{
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q= session.createQuery("from RegVo");
			
			ls = q.list();
			
			transaction.commit();
			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}
	
	public void delete(RegVo regVo,LoginVo loginVo){
		try{
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.delete(regVo);
			session.delete(loginVo);
			
			transaction.commit();
			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List edit(RegVo regVo){
		List ls = new ArrayList();
		try{
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Query q = session.createQuery("from RegVo where id='"+regVo.getId()+"'");
			
			ls=q.list();
			
			transaction.commit();
			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}
	public void update(RegVo regVo,LoginVo loginVo){
		try{
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.update(regVo);
			session.update(loginVo);
			
			transaction.commit();
			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
