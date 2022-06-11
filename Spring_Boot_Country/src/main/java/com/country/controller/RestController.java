package com.country.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.country.service.CountryService;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:9090")
public class RestController {

	@Autowired
	CountryService countryService;
	
	
	
	@RequestMapping(value="/state",method= RequestMethod.GET)
	public ResponseEntity state(@RequestParam int country){
		List ls = this.countryService.stae(country);
		return new ResponseEntity(ls,HttpStatus.OK);
		
	}
}
