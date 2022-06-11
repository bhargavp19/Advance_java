package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import dao.RegDao;
import vo.LoginVo;
import vo.RegVo;

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
		String flag = request.getParameter("flag");
		HttpSession h = request.getSession();
		LoginVo loginVo = new LoginVo();
		RegDao regDao = new RegDao();
		RegVo regVo = new RegVo();
		if(flag.equals("delete")){
			int regid = Integer.parseInt(request.getParameter("regid"));
			int loginid = Integer.parseInt(request.getParameter("loginid"));
			regVo.setId(regid);
			loginVo.setId(loginid);
			regDao.delete(regVo, loginVo);
		}
		if(flag.equals("search")){
		List l1 = regDao.search();
		h.setAttribute("list", l1);
		response.sendRedirect("search.jsp");
		}
		if(flag.equals("edit")){
			int regid = Integer.parseInt(request.getParameter("regid"));
			regVo.setId(regid);
			List ls1 = regDao.edit(regVo);
			h.setAttribute("list", ls1);
			response.sendRedirect("edit.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String flag = request.getParameter("flag");
		HttpSession h = request.getSession();
		LoginVo loginVo = new LoginVo();
		RegDao regDao = new RegDao();
		RegVo regVo = new RegVo();
		if(flag.equals("insert")){
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			loginVo.setUsername(username);
			loginVo.setPassword(password);
			
			regDao.insertlogin(loginVo);
			
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			
			regVo.setFirstname(firstname);
			regVo.setLastname(lastname);
			regVo.setLoginVo(loginVo);
			
			regDao.insertreg(regVo);
			flag="search";
		}
		if(flag.equals("update")){
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			int loginid = Integer.parseInt(request.getParameter("loginid"));
			loginVo.setUsername(username);
			loginVo.setPassword(password);
			loginVo.setId(loginid);
			
			
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			int regid = Integer.parseInt(request.getParameter("regid"));
			regVo.setFirstname(firstname);
			regVo.setLastname(lastname);
			regVo.setLoginVo(loginVo);
			regVo.setId(regid);
			
			regDao.update(regVo,loginVo);
			flag="search";
		}
		if(flag.equals("search")){

			List l1 = regDao.search();
			h.setAttribute("list", l1);
			response.sendRedirect("search.jsp");
		}
	}

}
