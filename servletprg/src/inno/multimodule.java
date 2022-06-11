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
 * Servlet implementation class multimodule
 */
@WebServlet("/multimodule")
public class multimodule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public multimodule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter x = response.getWriter();
		HttpSession h = request.getSession();
		
		String s1 = request.getParameter("firstname");
		String s2 = request.getParameter("lastname");
		String s3 = request.getParameter("username");
		String s4 = request.getParameter("password");
		String delid=request.getParameter("delid");
		String editon =request.getParameter("editon");
		String fn2 = request.getParameter("firstname2");
		String ln2 = request.getParameter("lastname2");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3307/bhargav","root","root");
			Statement s = c.createStatement();
			if(s1!=null){
			s.executeUpdate("INSERT INTO login (firstname,lastname,username,password) VALUES('"+s1+"','"+s2+"','"+s3+"','"+s4+"') ");
			response.sendRedirect("multimodule");
			}
			if(delid!=null){
				s.executeUpdate("delete from login where id='"+delid+"'");
				response.sendRedirect("multimodule");
			}
			if(editon!=null){
				
				ResultSet r= (ResultSet)s.executeQuery("select * from login where id='"+editon+"'");
				h.setAttribute("editid",editon);
				while(r.next()){
					String oldfn=r.getString("firstname");
					String oldln=r.getString("lastname");
				x.write("<form action='multimodule'>");
				x.write("firstname : <input type='text' name='firstname2' value='"+oldfn+"'><br>");
				x.write("lastname : <input type='text' name='lastname2' value='"+oldln+"'><br>");
				x.write("<button>submit</button></form>");
				}
				r.close();
				}
			if(fn2!=null && ln2!=null){
				String editid = (String)h.getAttribute("editid");
				s.executeUpdate("update login set firstname='"+fn2+"',lastname='"+ln2+"' where id='"+editid+"'");
				h.removeAttribute("editid");
				response.sendRedirect("multimodule");
			}
			
			if(editon==null){
			ResultSet r= (ResultSet)s.executeQuery("select * from login");
			x.write("<table border=1>");
			while(r.next()){
				int id=r.getInt("id");
				String fn=r.getString("firstname");
				String ln=r.getString("lastname");
				String un=r.getString("username");
				String pw=r.getString("password");
				x.write("<tr><td>");
				x.write(fn);
				x.write("</td><td>");
				x.write(ln);
				x.write("</td><td>");
				x.write(un);
				x.write("</td><td>");
				x.write(pw);
				x.write("</td><td><a href='multimodule?delid="+id+"'>delete</a></td>");
				x.write("</td><td><a href='multimodule?editon="+id+"'>edit</a>");
				x.write("</td></tr>");	
				
			}
			r.close();
			x.write("</table>");
			}
			
			s.close();
			c.close();
			}
			catch(Exception e){
				x.write("error");
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
