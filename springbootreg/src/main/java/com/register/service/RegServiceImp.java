package com.register.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.register.dao.RegDao;
import com.register.model.LoginVO;
import com.register.model.NewRegVo;
import com.register.model.RegVO;

@Service
@Transactional
public class RegServiceImp implements RegService{
	
	@Autowired
	RegDao regDao;

	public void insert(RegVO regVo) {
		// TODO Auto-generated method stub
		this.regDao.insert(regVo);;
		
	}

	public List search() {
		// TODO Auto-generated method stub
		List ls = this.regDao.search();
		return ls;
	}

	public void delete(int regid,int loginid) {
		// TODO Auto-generated method stub
		
		RegVO regVo = new RegVO();
		regVo.setId(regid);
		LoginVO loginVo = new LoginVO();
		loginVo.setId(loginid);
		this.regDao.delete(regVo,loginVo);
	}

	public RegVO edit(int regid) {
		RegVO regVo = new RegVO();
		regVo.setId(regid);
		
		List ls = this.regDao.edit(regVo);
		
		RegVO regvo = (RegVO) ls.get(0);
		return regvo;
	}

	@Override
	public void save(NewRegVo regvo) {
		// TODO Auto-generated method stub
		this.regDao.save(regvo);
	}

}
