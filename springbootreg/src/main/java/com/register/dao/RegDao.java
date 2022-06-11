package com.register.dao;

import java.util.List;

import com.register.model.LoginVO;
import com.register.model.NewRegVo;
import com.register.model.RegVO;

public interface RegDao {

	public void insert(RegVO regVo);
	
	public List search();
	
	public void delete(RegVO regVo,LoginVO loginVo);
	
	public List edit(RegVO regVo);

	//new 
	public void save(NewRegVo regvo);
}
