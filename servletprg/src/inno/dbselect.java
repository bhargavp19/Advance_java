package inno;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class dbselect
 */
@WebServlet("/dbselect")
public class dbselect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dbselect() {
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
		//String s1 = request.getParameter("search");
		PrintWriter x = response.getWriter();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3307/bhargav","root","root");
			Statement s = c.createStatement();
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
				x.write("</td><td><a href='delete?id="+id+"'>delete</a></td>");
				x.write("</td><td><a href='edit?id="+id+"'>edit</a>");
				x.write("</td></tr>");
			}
			x.write("</table>");
			
			s.close();
			c.close();
			}
			catch(Exception e){
				x.write("errror");
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
