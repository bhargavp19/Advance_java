package inno;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class twinsert
 */
@WebServlet("/twinsert")
public class twinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public twinsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String flag = request.getParameter("flag");
		
		if(flag.equals("insert")){
		String s1 = request.getParameter("firstname");
		String s2 = request.getParameter("lastname");
		String s3 = request.getParameter("username");
		String s4 = request.getParameter("password");
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3307/bhargav","root","root");
		Statement s = c.createStatement();
		s.executeUpdate("INSERT INTO login (firstname,lastname,username,password) VALUES('"+s1+"','"+s2+"','"+s3+"','"+s4+"') ");
		s.close();
		c.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		response.sendRedirect("twlogin.jsp");
		}
		
		if(flag.equals("login")){
			String un2 = request.getParameter("username2");
			String pw2 = request.getParameter("password2");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
	}

}
