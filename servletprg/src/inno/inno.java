package inno;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class inno
 */
@WebServlet("/inno")
public class inno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inno() {
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
		System.out.println("hiii");
		
		PrintWriter x = response.getWriter();
		x.write("hii");
		x.write("<br>");
		x.write("hii");
		x.write("hii");
		x.write("<br>");
		
		HttpSession s = request.getSession();
		
			s.setAttribute("key", "bhargav");
			String s123 = (String)s.getAttribute("key");
			x.write(s123);
			x.write("<br>");
			String req = request.getParameter("text");
			x.write(req);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter x = response.getWriter();
		String req = request.getParameter("text");
		x.write(req);
	}

}
