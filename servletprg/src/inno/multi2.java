package inno;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class multi2
 */
@WebServlet("/multi2")
public class multi2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public multi2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String f = request.getParameter("flag");
		
		
		if(f!=null){
			if(f.equals("search")){
				search(request, response);
			}
		if(f.equals("delete")) {
			delete(request, response);
		}
		if(f.equals("edit")){
			edit(request, response);
			
		}
		}
		if(f==null){
			search(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String f = request.getParameter("flag");
		
		
		if(f.equals("insert")){
			insert(request,response);
		}
		if(f.equals("update")){
			update(request, response);
			
		}
		
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s1 = request.getParameter("firstname");
		String s2 = request.getParameter("lastname");
		String s3 = request.getParameter("username");
		String s4 = request.getParameter("password");
		HttpSession h = request.getSession();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/bhargav", "root", "root");
			Statement s = c.createStatement();
			s.executeUpdate("INSERT INTO login (firstname,lastname,username,password) VALUES('" + s1 + "','" + s2
					+ "','" + s3 + "','" + s4 + "') ");
			s.close();
			c.close();
			response.sendRedirect("multi2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter x = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/bhargav", "root", "root");
			Statement s = c.createStatement();
			ResultSet r = (ResultSet) s.executeQuery("select * from login");
			x.write("<table border=1>");
			while (r.next()) {
				int id = r.getInt("id");
				String fn = r.getString("firstname");
				String ln = r.getString("lastname");
				String un = r.getString("username");
				String pw = r.getString("password");
				x.write("<tr><td>");
				x.write(fn);
				x.write("</td><td>");
				x.write(ln);
				x.write("</td><td>");
				x.write(un);
				x.write("</td><td>");
				x.write(pw);
				x.write("</td><td><a href='multi2?id=" + id + "&flag=delete'>delete</a></td>");
				x.write("</td><td><a href='multi2?id=" + id + "&flag=edit'>edit</a>");
				x.write("</td></tr>");
			}
			x.write("</table>");

			s.close();
			c.close();
		} catch (Exception e) {
			x.write("error");
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String id = request.getParameter("id");
		// PrintWriter x = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/bhargav", "root", "root");
			Statement s = c.createStatement();
			s.executeUpdate("delee from login where id='" + id + "'");
			s.close();
			c.close();
			response.sendRedirect("multi2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession h = request.getSession();
		response.setContentType("text/html");
		PrintWriter x = response.getWriter();
		String id = request.getParameter("id");
		h.setAttribute("id", id);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/bhargav", "root", "root");
			Statement s = c.createStatement();
			ResultSet r = (ResultSet) s.executeQuery("select * from login where id='" + id + "'");
			while (r.next()) {
				String fn = r.getString("firstname");
				String ln = r.getString("lastname");
				x.write("<form action='multi2' method=post>");
				x.write("firstname : <input type='text' name='firstname' value='" + fn + "'><br>");
				x.write("lastname : <input type='text' name='lastname' value='" + ln + "'>"
						+ "<input type=hidden name=flag value=update><br>");
				x.write("<button>submit</button></form>");
			}
			s.close();
			c.close();

		} catch (Exception e) {
			x.write("errror");
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession h = request.getSession();

		response.setContentType("text/html");
		String id = (String) h.getAttribute("id");

		String fn = request.getParameter("firstname");
		String ln = request.getParameter("lastname");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/bhargav", "root", "root");
			Statement s1 = c.createStatement();
			s1.executeUpdate("update login set firstname='" + fn + "',lastname='" + ln + "' where id='" + id + "'");
			s1.close();
			c.close();
			h.removeAttribute("id");
			response.sendRedirect("multi2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
