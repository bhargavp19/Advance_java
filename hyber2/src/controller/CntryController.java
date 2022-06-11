package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CntryDao;
import vo.CntryVo;
import vo.StateVo;


/**
 * Servlet implementation class CntryController
 */
@WebServlet("/CntryController")
public class CntryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CntryController() {
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
		CntryVo cntryVo = new CntryVo();
		CntryDao cntryDao = new CntryDao();
		StateVo stateVo = new StateVo();
		if(flag.equals("delete")){
			int id = Integer.parseInt(request.getParameter("id"));
			cntryVo.setId(id);
			cntryDao.delete(cntryVo);
			flag="search";
		}
		if(flag.equals("searchcntry")){
			List l1 = cntryDao.searchCntry();
			h.setAttribute("lists", l1);
			response.sendRedirect("addstate.jsp");
		}
		if(flag.equals("search")){

			List l1 = cntryDao.searchCntry();
			h.setAttribute("lists", l1);
			response.sendRedirect("viewcntry.jsp");
		}
		if(flag.equals("statesearch")){

			List l1 = cntryDao.searchState();
			h.setAttribute("lists", l1);
			response.sendRedirect("viewstate.jsp");
		}
		if(flag.equals("edit")){
			int regid = Integer.parseInt(request.getParameter("id"));
			cntryVo.setId(regid);
			
			List ls1 = cntryDao.edit(cntryVo);
			h.setAttribute("listed", ls1);
			response.sendRedirect("cntryedit.jsp");
		}
		if(flag.equals("editstate")){
			int stateid = Integer.parseInt(request.getParameter("id"));
			stateVo.setId(stateid);
			List editstate = cntryDao.editstate(stateVo);
			List country = cntryDao.searchCntry();
			h.setAttribute("editstate", editstate);
			h.setAttribute("cntry", country);
			response.sendRedirect("stateedit.jsp");
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
		CntryVo cntryVo = new CntryVo();
		CntryDao cntryDao = new CntryDao();
		StateVo stateVo = new StateVo();
		if(flag.equals("insert")){
			
			String cntry = request.getParameter("cntry");
			String desc = request.getParameter("desc");
			
			cntryVo.setCntry_name(cntry);
			cntryVo.setCntry_desc(desc);
			
			cntryDao.insertcntry(cntryVo);
			
			flag="search";
		}
		if(flag.equals("insert_state")){
			
			String statename = request.getParameter("statename");
			int id = Integer.parseInt(request.getParameter("cntry_name"));
			cntryVo.setId(id);
			stateVo.setState_name(statename);
			stateVo.setCid(cntryVo);
			
			cntryDao.insertstate(stateVo);
			flag="statesearch";
		}
		if(flag.equals("update")){
			
			String username = request.getParameter("cntry");
			String password = request.getParameter("desc");
			int loginid = Integer.parseInt(request.getParameter("id"));
			cntryVo.setCntry_name(username);
			cntryVo.setCntry_desc(password);
			cntryVo.setId(loginid);
			
		
			cntryDao.update(cntryVo);
			flag="search";
		}
		if(flag.equals("updatestate")){
			
			String state = request.getParameter("state");
			int id = Integer.parseInt(request.getParameter("id"));
			int cntryid = Integer.parseInt(request.getParameter("cntry"));
			stateVo.setId(id);
			cntryVo.setId(cntryid);
			stateVo.setState_name(state);
			stateVo.setCid(cntryVo);
			
			cntryDao.updatestate(stateVo);
			flag="statesearch";
		}
		if(flag.equals("search")){

			List l1 = cntryDao.searchCntry();
			h.setAttribute("lists", l1);
			response.sendRedirect("viewcntry.jsp");
		}
		
		if(flag.equals("statesearch")){

			List l1 = cntryDao.searchState();
			h.setAttribute("lists", l1);
			response.sendRedirect("viewstate.jsp");
		}
		
	
	}

}
