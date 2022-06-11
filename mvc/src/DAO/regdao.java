package DAO;
import java.util.*;
import java.sql.*;


import VO.regvo;
public class regdao {

	public void insert(regvo v){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/bhargav","root","root");
		Statement s = c.createStatement();
		s.executeUpdate("INSERT INTO student (firstname,lastname) VALUES('"+v.getFn()+"','"+v.getLn()+"') ");
		s.close();
		c.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List search(regvo v){
		List ls= new ArrayList();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/bhargav","root","root");
			Statement s = c.createStatement();
			ResultSet r=s.executeQuery("select * from student");
			while(r.next()){
				regvo v1=new regvo();
				int id= r.getInt("id");
				String fn = r.getString("firstname");
				String ln = r.getString("lastname");
				v1.setId(id);
				v1.setFn(fn);
				v1.setLn(ln);
				ls.add(v1);
			}
			r.close();
			s.close();
			c.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return ls;
	}
	
	public void delete(regvo v){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/bhargav","root","root");
			Statement s = c.createStatement();
			s.executeUpdate("delete from student where id='"+v.getId()+"'");
			s.close();
			c.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
	}
	
	public List edit(regvo v){
		List ls= new ArrayList();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/bhargav","root","root");
			Statement s = c.createStatement();
			ResultSet r=s.executeQuery("select * from student where id='"+v.getId()+"'");
			while(r.next()){
				regvo v1=new regvo();
				int id= r.getInt("id");
				String fn = r.getString("firstname");
				String ln = r.getString("lastname");
				v1.setId(id);
				v1.setFn(fn);
				v1.setLn(ln);
				ls.add(v1);
			}
			r.close();
			s.close();
			c.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	return ls;
	}
	
	public void update(regvo v){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/bhargav","root","root");
		Statement s = c.createStatement();
		s.executeUpdate("update student set firstname='"+v.getFn()+"',lastname='"+v.getLn()+"' where id='"+v.getId()+"'");
		s.close();
		c.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
