package inno;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
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
		String id=(String)h.getAttribute("id");
		
		String fn=request.getParameter("firstname");
		String ln=request.getParameter("lastname");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3307/bhargav","root","root");
			Statement s1 = c.createStatement();
			s1.executeUpdate("update login set firstname='"+fn+"',lastname='"+ln+"' where id='"+id+"'");
			s1.close();
			c.close();
			h.removeAttribute("id");
			}
			catch(Exception e){
				
			}
		
			response.sendRedirect("dbselect");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
