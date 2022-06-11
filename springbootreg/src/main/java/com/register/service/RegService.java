package com.register.service;

import java.util.List;

import com.register.model.LoginVO;
import com.register.model.NewRegVo;
import com.register.model.RegVO;

public interface RegService {

	public void insert(RegVO regVo);

	public List search();
	
	public void delete(int regid,int loginid);
	
	public RegVO edit(int regid);
	
	//new
	public void save(NewRegVo regvo);
}
