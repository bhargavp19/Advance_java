package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.RegDAO;
import com.model.RegVO;

@Controller
public class RegController {

	@Autowired
	private RegDAO regDAO;

	@RequestMapping(value = "load.html", method = RequestMethod.GET)
	public ModelAndView load() {

		return new ModelAndView("Registration", "RegVO", new RegVO());

	}

	@RequestMapping(value = "insert.html", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute RegVO regVO) {
		
		regDAO.insert(regVO);
		
		return new ModelAndView("redirect:/search.html");

	}
	
	@RequestMapping(value = "search.html" , method = RequestMethod.GET)
	public ModelAndView search(){
		
		List data = regDAO.search();
		return new ModelAndView("Search", "data", data);
	}
	
	@RequestMapping(value = "delete.html" , method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam int id,RegVO v){
		v.setId(id);
		regDAO.delete(v);
		return new ModelAndView("redirect:/search.html");  
	}
	
	@RequestMapping(value = "edit.html" , method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int id,RegVO v){
		v.setId(id);
		List data = regDAO.edit(v);
		RegVO v1 = (RegVO)data.get(0); 
		return new ModelAndView("Registration","RegVO",v1);
	}
}

