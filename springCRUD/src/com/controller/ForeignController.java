package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.FRegDAO;
import com.model.FRegVO;
import com.model.LoginVO;

import java.util.List;

@Controller
public class ForeignController {
	
	@Autowired
	private FRegDAO fregDAO;
	
	@RequestMapping(value = "foreign.html", method = RequestMethod.GET)
	public ModelAndView load() {

		return new ModelAndView("ForeignRegistraion", "FRegVO", new FRegVO());

	}
	
	@RequestMapping(value = "insertforeign.html", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute FRegVO fregVO) {
		
		fregDAO.insert(fregVO);
		
		return new ModelAndView("redirect:searchforeign.html");

	}
	
	@RequestMapping(value = "searchforeign.html", method = RequestMethod.GET)
	public ModelAndView search() {
		
		List data = (List) fregDAO.search();
		
		return new ModelAndView("ForeignSearch", "data", data);

	}

	@RequestMapping(value = "deleteforeign.html", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam int regid,@RequestParam int loginid,FRegVO fregVO,LoginVO loginVO) {
		fregVO.setId(regid);
		loginVO.setId(loginid);
		
		fregDAO.delete(fregVO,loginVO);
		
		return new ModelAndView("redirect:searchforeign.html");

	}
	
	@RequestMapping(value = "editforeign.html", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int id,FRegVO fregVO) {
		
		fregVO.setId(id);
		
		List ls = fregDAO.edit(fregVO);
		FRegVO freg = (FRegVO) ls.get(0);
		
		return new ModelAndView("ForeignRegistraion", "FRegVO", freg);

	}
	
	
}

