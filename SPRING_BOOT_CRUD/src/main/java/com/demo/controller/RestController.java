package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.service.RegService;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:9090")
public class RestController {

	@Autowired
	RegService regService;
	
	
	@GetMapping("/user")
	public ResponseEntity getUsers(){
		List ls = this.regService.search();
	
		return new ResponseEntity(ls,HttpStatus.OK);
	}
	
	@RequestMapping("/verifyuser")
	public ResponseEntity verifyUsers(@RequestParam String firstname){
		
		List ls = this.regService.verify(firstname);
		
		boolean flag = (ls.size()>0);
	
		return new ResponseEntity(flag,HttpStatus.OK);
	}
}
