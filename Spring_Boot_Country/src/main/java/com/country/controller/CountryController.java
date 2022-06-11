package com.country.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.country.model.CountryVO;
import com.country.model.StateVO;
import com.country.service.CountryService;

@Controller
public class CountryController {

	@Autowired
	CountryService countryService;
	
	@GetMapping("/")
	public ModelAndView load(){
		return new ModelAndView("country");
		
	}
	
	@RequestMapping(value="addcountry",method= RequestMethod.GET)
	public ModelAndView addcountry(){
		return new ModelAndView("addcountry","countryVO",new CountryVO());
	}
	
	@RequestMapping(value="form",method= RequestMethod.GET)
	public ModelAndView form(){
		List ls = this.countryService.searchCountry();
		return new ModelAndView("Registration","ls",ls);
	}
	
	@RequestMapping(value="insertcountry",method= RequestMethod.POST)
	public ModelAndView insertcountry(@ModelAttribute CountryVO countryVO){
		this.countryService.addCountry(countryVO);
		return new ModelAndView("redirect:viewcountry");
	}
	
	@RequestMapping(value="viewcountry",method= RequestMethod.GET)
	public ModelAndView viewcountry(){
		List ls = this.countryService.searchCountry();
		return new ModelAndView("viewcountry","country",ls);
	}
	
	@RequestMapping(value="deletecountry",method= RequestMethod.GET)
	public ModelAndView deletecountry(@RequestParam int id,CountryVO countryVO){
		countryVO.setId(id);
		this.countryService.deleteCountry(countryVO);
		return new ModelAndView("redirect:viewcountry");
	}
	
	@RequestMapping(value="editcountry",method= RequestMethod.GET)
	public ModelAndView editcountry(@RequestParam int id,CountryVO countryVO){
		countryVO.setId(id);
		CountryVO cntry = (CountryVO) this.countryService.editCountry(countryVO).get(0);
		return new ModelAndView("addcountry","countryVO",cntry);
	}
	
	
	
	@RequestMapping(value="addstate",method= RequestMethod.GET)
	public ModelAndView addstate(){
		List ls = this.countryService.searchCountry();
		return new ModelAndView("addstate","stateVO",new StateVO()).addObject("country",ls);
	}
	
	@RequestMapping(value="insertstate",method= RequestMethod.POST)
	public ModelAndView insertState(@ModelAttribute StateVO stateVO){
		this.countryService.addState(stateVO);
		return new ModelAndView("redirect:viewstate");
	}
	
	@RequestMapping(value="viewstate",method= RequestMethod.GET)
	public ModelAndView viewstate(){
		List ls = this.countryService.searchState();
		return new ModelAndView("viewstate","state",ls);
	}
	
	@RequestMapping(value="deletestate",method= RequestMethod.GET)
	public ModelAndView deletestate(@RequestParam int id,StateVO stateVO){
		stateVO.setId(id);
		this.countryService.deleteState(stateVO);
		return new ModelAndView("redirect:viewstate");
	}
	
	@RequestMapping(value="editstate",method= RequestMethod.GET)
	public ModelAndView editstate(@RequestParam int id,StateVO stateVO){
		stateVO.setId(id);
		StateVO state = (StateVO) this.countryService.editState(stateVO).get(0);
		List ls = this.countryService.searchCountry();
		return new ModelAndView("addstate","stateVO",state).addObject("country",ls);
	}
}
