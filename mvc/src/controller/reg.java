package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import java.util.*;
import DAO.regdao;
import VO.regvo;

/**
 * Servlet implementation class reg
 */
@WebServlet("/reg")
public class reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f= request.getParameter("flag");
		
		if(f.equals("delete")){
			int id = Integer.parseInt(request.getParameter("id"));
			regvo v= new regvo();
			regdao d= new regdao();
			v.setId(id);
			d.delete(v);
			f="search";
		}
		if(f.equals("search")){
			regvo v= new regvo();
			regdao d= new regdao();
			List ls = d.search(v);
			HttpSession h = request.getSession();
			h.setAttribute("list", ls);
			response.sendRedirect("search.jsp");
		}
		if(f.equals("edit")){
			int id = Integer.parseInt(request.getParameter("id"));
			regvo v=new regvo();
			regdao d= new regdao();
			v.setId(id);
			List ls=d.edit(v);
			HttpSession h = request.getSession();
			h.setAttribute("list", ls);
			response.sendRedirect("update.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String f= request.getParameter("flag");
		regvo v= new regvo();
		regdao d= new regdao();
		if(f.equals("insert")){
			String fn = request.getParameter("firstname");
			String ln = request.getParameter("lastname");
		
			
			v.setFn(fn);
			v.setLn(ln);
			d.insert(v);
			f="search";
		}	
		if(f.equals("update")){
			String fn = request.getParameter("firstname");
			String ln = request.getParameter("lastname");
			int id=Integer.parseInt(request.getParameter("id"));
			 
			v.setId(id);
			v.setFn(fn);
			v.setLn(ln);
			d.update(v);
			f="search";
		}
		if(f.equals("search")){
			 
			List ls = d.search(v);
			HttpSession h = request.getSession();
			h.setAttribute("list", ls);
			response.sendRedirect("search.jsp");
		}
		
	}
}
