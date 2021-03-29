package com.test.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
@Entity
@Table(name = "Address_Table")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;

	@Column(name = "state", length = 40)
	private String stateName;

	@Column(name = "city", length = 30)
	private String cityName;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(int aid, String stateName, String cityName) {
		super();
		this.aid = aid;
		this.stateName = stateName;
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", stateName=" + stateName + ", cityName=" + cityName + "]";
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
