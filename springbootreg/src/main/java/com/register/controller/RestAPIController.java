package com.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.register.DTO.RegDTO;
import com.register.DTO.Response;
import com.register.model.NewRegVo;
import com.register.service.RegService;
import com.register.utils.baseMethods;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class RestAPIController {

	@Autowired
	baseMethods basemethod;
	
	@Autowired 
	RegService regservice;
	
	@PostMapping("save")
	public ResponseEntity save(@RequestBody RegDTO regDTO){
		
		Response response = new Response();
		if(basemethod.validateString(regDTO.getFirstname()) && basemethod.validateString(regDTO.getLastname()) && basemethod.validateString(regDTO.getUsername()) && basemethod.validateString(regDTO.getPassword()) ){
			if(basemethod.validateEmail(regDTO.getUsername())){
				NewRegVo regvo = basemethod.mapData(regDTO);
				if(regvo.getId()>0){
					//UPDATE
					response.setMsg("DATA UPDATED");
				}
				else{
					//INSERT
					response.setMsg("DATA INSERTED");
				}
				
				response.setStatus(true);
				response.setData(regvo);
				this.regservice.save(regvo);
				
				return new ResponseEntity(response,HttpStatus.OK);
			}
			else{
				response.setMsg("Enter Valid Email");
				return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
			}
			
		}
		else{
			response.setMsg("Please Provide Required Fields");
			return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
		}
		
	}
}
