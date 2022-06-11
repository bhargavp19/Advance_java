package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import dao.RegDAO;
import vo.RegVO;

/**
 * Servlet implementation class RegController
 */
@WebServlet("/RegController")
public class RegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String flag=request.getParameter("flag");
		RegVO regVO=new RegVO();
		RegDAO regDAO=new RegDAO();
		if(flag.equals("delete")){
			int id=Integer.parseInt(request.getParameter("id"));
			regVO.setId(id);
			regDAO.delete(regVO);
			flag="search";
		}
		if(flag.equals("search")){
			List ls= regDAO.search();
			HttpSession h = request.getSession();
			h.setAttribute("list", ls);
			response.sendRedirect("search.jsp");
		}
		if(flag.equals("edit")){
			int id=Integer.parseInt(request.getParameter("id"));
			regVO.setId(id);
			List ls2= regDAO.edit(regVO);
			HttpSession h = request.getSession();
			h.setAttribute("update", ls2);
			response.sendRedirect("update.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		RegVO regVO=new RegVO();
		RegDAO regDAO=new RegDAO();
		
		if(flag.equals("edit")){
		String firstname=request.getParameter("fn");
		String lastname=request.getParameter("ln");
		
		regVO.setFirstname(firstname);
		regVO.setLastname(lastname);
		
		regDAO.insert(regVO);
		}
		
		if(flag.equals("update")){
			String fn2=request.getParameter("firstname");
			String ln2=request.getParameter("lastname");
			int id2=Integer.parseInt(request.getParameter("id"));

			regVO.setFirstname(fn2);
			regVO.setLastname(ln2);
			regVO.setId(id2);
			regDAO.update(regVO);
		}
		
		List ls= regDAO.search();
		HttpSession h = request.getSession();
		h.setAttribute("list", ls);
		response.sendRedirect("search.jsp");
		
	}

}
