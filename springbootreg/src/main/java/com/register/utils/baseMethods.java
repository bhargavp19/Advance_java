package com.register.utils;



import com.register.DTO.RegDTO;
import com.register.model.NewRegVo;

@org.springframework.stereotype.Component
public class baseMethods {
	
	public boolean validateString(String str){
		
		
		return str!=null && !str.isEmpty();
		
	}
	
	public boolean validateEmail(String s){
		return true;
	}
	
	public NewRegVo mapData(RegDTO regdto){
		
		NewRegVo regvo = new NewRegVo();
		
		regvo.setFirstname(regdto.getFirstname());
		regvo.setId(regdto.getId());
		regvo.setLastname(regdto.getLastname());
		regvo.setUsername(regdto.getUsername());
		regvo.setPassword(regdto.getPassword());
		
		return regvo;
	}

}
