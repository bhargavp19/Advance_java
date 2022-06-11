package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vo.*;


@Controller
public class DemoController {
	
	@RequestMapping(value="hello.html", method = RequestMethod.GET)
	public ModelAndView Load()
	{
		String s = "This is Spring Example...";
		return new ModelAndView("Demo","msg",s);
	}
	
	@RequestMapping(value="form.html",method= RequestMethod.GET)
	public ModelAndView form(){
		return new ModelAndView("form");
	}
	
	@RequestMapping(value="display.html",method= RequestMethod.POST)
	public ModelAndView Save(HttpServletRequest request) throws ServletException, IOException{
		
		String fn=request.getParameter("fn");
		String ln=request.getParameter("ln");
		
		return new ModelAndView("display","fn",fn).addObject("ln", ln);
		
	}
	
	@RequestMapping(value="reg.html",method = RequestMethod.GET)
	public ModelAndView reg(){
		return new ModelAndView("register");
	}
	
	@RequestMapping(value="register.html",method = RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request){

		String fn=request.getParameter("fn");
		String ln=request.getParameter("ln");
		String un=request.getParameter("un");
		String pass=request.getParameter("pass");
		HttpSession session = request.getSession();
		session.setAttribute("fn", fn);
		session.setAttribute("ln", ln);
		session.setAttribute("un", un);
		session.setAttribute("pass", pass);
		
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="login.html",method= RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		String un1=request.getParameter("un1");
		String pass1=request.getParameter("pass1");
		
		if(un1.equals(session.getAttribute("un")) && pass1.equals(session.getAttribute("pass"))){
			return new ModelAndView("welcome","fn",session.getAttribute("fn")).addObject("ln",session.getAttribute("ln"));
		}
		return new ModelAndView("login","invalid","invalid username and password");
		
	}
	
	@RequestMapping(value="model.html",method=RequestMethod.GET)
	public ModelAndView model(){
		return new ModelAndView("springform","data",new RegVo());
	}
	
	@RequestMapping(value="save.html",method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute RegVo v){
		
		return new ModelAndView("display","v",v);
	}
	
	@RequestMapping(value="modelreg.html",method=RequestMethod.GET)
	public ModelAndView modelReg(){
		return new ModelAndView("regmvc","modelreg",new RegVo());
	}
	
	@RequestMapping(value="regmvc.html",method=RequestMethod.POST)
	public ModelAndView regmvc(@ModelAttribute RegVo v,HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("fn", v.getFirstname());
		session.setAttribute("ln", v.getLastname());
		session.setAttribute("un", v.getUsername());
		session.setAttribute("pw", v.getPassword());
		
		return new ModelAndView("loginmvc","login",new RegVo());
	}
	
	@RequestMapping(value="loginmvc.html",method=RequestMethod.POST)
	public ModelAndView loginmvc(@ModelAttribute RegVo l,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		if(l.getUsername().equals(session.getAttribute("un")) && l.getPassword().equals(session.getAttribute("pw"))){
			return new ModelAndView("welcome","fn",session.getAttribute("fn")).addObject("ln",session.getAttribute("ln"));
		};
		
		return new ModelAndView("loginmvc","login",new LoginVo());
	}
}

