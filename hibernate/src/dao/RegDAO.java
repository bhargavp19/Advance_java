package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.*;
import vo.RegVO;

public class RegDAO {
	
	public void insert(RegVO regVO)
		{
			try
				{
					SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
					
					Session session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					session.save(regVO);
					
					transaction.commit();
					
					session.close();
				}
			catch(Exception ex)
				{
					ex.printStackTrace();
				}
		}
	public List search()
	{
		List ls=new ArrayList();
		try
			{
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				
				Session session = sessionFactory.openSession();
				
				Transaction transaction=session.beginTransaction();
				
				Query q = session.createQuery("from RegVO");
				
				ls = q.list();
				
				transaction.commit();
				
				session.close();
			}
		catch(Exception ex)
			{
				ex.printStackTrace();
				System.out.print("error");
			}
		return ls;
	}
	public void delete(RegVO regVO)
	{
		try
			{
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				
				Session session = sessionFactory.openSession();
				
				Transaction transaction=session.beginTransaction();
				
				session.delete(regVO);
				
				transaction.commit();
				
				session.close();
			}
		catch(Exception ex)
			{
				ex.printStackTrace();
			}
	}
	
	public List edit(RegVO v){
		List ls=new ArrayList();
		try
			{
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				
				Session session = sessionFactory.openSession();
				
				Transaction transaction=session.beginTransaction();
				
				Query q = session.createQuery("from RegVO where id='"+v.getId()+"'");
				
				ls = q.list();
				
				transaction.commit();
				
				session.close();
			}
		catch(Exception ex)
			{
				ex.printStackTrace();
				System.out.print("error");
			}
		return ls;
	}
	public void update(RegVO regVO)
	{
		try
			{
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				
				Session session = sessionFactory.openSession();
				
				Transaction transaction=session.beginTransaction();
				
				session.update(regVO);
				
				transaction.commit();
				
				session.close();
			}
		catch(Exception ex)
			{
				ex.printStackTrace();
			}
	}

}
