package com.country.dao;

import java.util.List;

import com.country.model.CountryVO;
import com.country.model.StateVO;

public interface CountryDao {

public void addCountry(CountryVO countryVO);
	
	public void addState(StateVO stateVO);
	
	public List searchCountry();
	
	public List searchState();
	
	public void deleteCountry(CountryVO countryVO);
	
	public void deleteState(StateVO stateVO);
	
	public List editCountry(CountryVO countryVO);
	
	public List editState(StateVO stateVO);

	public List state(int id);
}
