package com.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.register.model.RegVO;
import com.register.service.RegService;

@Controller
public class RegController {
	
	@Autowired
	RegService regService;
	
	
	@GetMapping("/")
	public ModelAndView load(){
		
		return new ModelAndView("Register","regVo",new RegVO());
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute RegVO regVo){
		
		this.regService.insert(regVo);

		return new ModelAndView("redirect:search");
	}
	
	@RequestMapping(value="search",method = RequestMethod.GET)
	public ModelAndView search(){
		
		List data = this.regService.search();
		return new ModelAndView("search","data",data);
	}
	
	@RequestMapping(value="delete2",method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam int id,@RequestParam int loginid){
		
		this.regService.delete(id,loginid);
		
		return new ModelAndView("redirect:search");
	}
	
	@RequestMapping(value="edit",method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int id){
		
		RegVO regVo = this.regService.edit(id);
		
		return new ModelAndView("Register","regVo",regVo);
	}

}
