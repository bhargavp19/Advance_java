package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.CountryDAO;
import com.VO.CountryVO;
import com.VO.StateVO;


@Controller
public class CountryController {

	@Autowired
	private CountryDAO cntryDAO;
	
	@RequestMapping(value = "addcntry.html", method = RequestMethod.GET)
	public ModelAndView load() {

		return new ModelAndView("addCountry", "country", new CountryVO());

	}
	
	@RequestMapping(value = "insertcntry.html", method = RequestMethod.POST)
	public ModelAndView insertcntry(@ModelAttribute CountryVO cntryVO) {

		cntryDAO.insertCntry(cntryVO);
		
		return new ModelAndView("redirect:showcntry.html");

	}
	
	@RequestMapping(value = "showcntry.html", method = RequestMethod.GET)
	public ModelAndView searchcntry() {

		List cntry =  cntryDAO.cntrysearch();
		
		return new ModelAndView("showCountry", "country",cntry);

	}
	
	@RequestMapping(value = "deletecntry.html", method = RequestMethod.GET)
	public ModelAndView deletecntry(@RequestParam int id,CountryVO cntryVO) {
		
		cntryVO.setId(id);
		cntryDAO.deleteCntry(cntryVO);
		
		return new ModelAndView("redirect:showcntry.html");

	}
	
	@RequestMapping(value = "editcntry.html", method = RequestMethod.GET)
	public ModelAndView editcntry(@RequestParam int id,CountryVO cntryVO) {
		
		cntryVO.setId(id);
		List cntry =  cntryDAO.editcntry(cntryVO);
		
		CountryVO c = (CountryVO) cntry.get(0);

		return new ModelAndView("addCountry", "country", c);

	}
	
	@RequestMapping(value = "addstate.html", method = RequestMethod.GET)
	public ModelAndView state() {
		
		List cntry =  cntryDAO.cntrysearch();
			
		return new ModelAndView("addState", "state", new StateVO()).addObject("cntry", cntry);

	}
	
	@RequestMapping(value = "stateinsert.html", method = RequestMethod.POST)
	public ModelAndView insertstate(@ModelAttribute StateVO stateVO) {

		cntryDAO.insertState(stateVO);
		
		return new ModelAndView("redirect:showstate.html");
	}
	
	@RequestMapping(value = "showstate.html", method = RequestMethod.GET)
	public ModelAndView searchstate() {

		List state =  cntryDAO.statesearch();
		
		return new ModelAndView("showState", "state",state);

	}
	
	@RequestMapping(value = "deletestate.html", method = RequestMethod.GET)
	public ModelAndView deletestate(@RequestParam int id,StateVO stateVO) {
		
		stateVO.setId(id);
		cntryDAO.deletestate(stateVO);
		
		return new ModelAndView("redirect:showstate.html");

	}
	
	@RequestMapping(value = "editstate.html", method = RequestMethod.GET)
	public ModelAndView editstate(@RequestParam int id,StateVO stateVO) {
		
		stateVO.setId(id);
		List state =  cntryDAO.editstate(stateVO);
		
		StateVO s = (StateVO) state.get(0);
		List cntry =  cntryDAO.cntrysearch();
		return new ModelAndView("addState", "state", s).addObject("cntry", cntry);

	}
}
