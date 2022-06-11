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
 * Servlet implementation class edit
 */
@WebServlet("/edit")
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession h = request.getSession();
		response.setContentType("text/html");
		PrintWriter x = response.getWriter();
		String id=request.getParameter("id");
		h.setAttribute("id", id);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3307/bhargav","root","root");
			Statement s = c.createStatement();
			ResultSet r= (ResultSet)s.executeQuery("select * from login where id='"+id+"'");
			while(r.next()){
				String fn=r.getString("firstname");
				String ln=r.getString("lastname");
				x.write("<form action='update'>");
				x.write("firstname : <input type='text' name='firstname' value='"+fn+"'><br>");
				x.write("lastname : <input type='text' name='lastname' value='"+ln+"'><br>");
				x.write("<button>submit</button></form>");
			}
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
