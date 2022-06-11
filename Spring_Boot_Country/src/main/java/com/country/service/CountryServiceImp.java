package com.country.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.dao.CountryDao;
import com.country.model.CountryVO;
import com.country.model.StateVO;

@Service
@Transactional
public class CountryServiceImp implements CountryService{

	@Autowired 
	CountryDao countryDao;
	
	@Override
	public void addCountry(CountryVO countryVO) {
		
		this.countryDao.addCountry(countryVO);
	}

	@Override
	public void addState(StateVO stateVO) {
		
		this.countryDao.addState(stateVO);
	}

	@Override
	public List searchCountry() {
		
		return this.countryDao.searchCountry();
	}

	@Override
	public List searchState() {
		
		return this.countryDao.searchState();
	}

	@Override
	public void deleteCountry(CountryVO countryVO) {
		
		this.countryDao.deleteCountry(countryVO);
	}

	@Override
	public void deleteState(StateVO stateVO) {
		
		this.countryDao.deleteState(stateVO);
	}

	@Override
	public List editCountry(CountryVO countryVO) {
		
		return this.countryDao.editCountry(countryVO);
	}

	@Override
	public List editState(StateVO stateVO) {
		
		return this.countryDao.editState(stateVO);
	}

	@Override
	public List stae(int id) {
		
		return this.countryDao.state(id);
	}

}
