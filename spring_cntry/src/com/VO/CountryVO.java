package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="countryspring")
public class CountryVO {

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="cntry_name")
	private String cntry_name;
	
	@Column(name="cntry_desc")
	private String cntry_desc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCntry_name() {
		return cntry_name;
	}

	public void setCntry_name(String cntry_name) {
		this.cntry_name = cntry_name;
	}

	public String getCntry_desc() {
		return cntry_desc;
	}

	public void setCntry_desc(String cntry_desc) {
		this.cntry_desc = cntry_desc;
	}
	
	
}
