package com.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.register.dto.Response;
import com.register.dto.RegDTO;
import com.register.service.RegService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class RestAPIController {

	@Autowired
	RegService regService;
	
	@PostMapping("save")
	public ResponseEntity save(@RequestBody RegDTO regDTO){
		Response response = new Response();
		
		return null;
		
	}
}
