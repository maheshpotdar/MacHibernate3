package com.test.entity;

import javax.persistence.Embeddable;

public class Country implements Comparable<Country>{

	private int counryID;
	private String countryName;
	private String continent;

	public Country(int counryID, String countryName, String continent) {
		super();
		this.counryID = counryID;
		this.countryName = countryName;
		this.continent = continent;
	}

	public Country() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Country [counryID=" + counryID + ", countryName=" + countryName + ", continent=" + continent + "]";
	}

	public int getCounryID() {
		return counryID;
	}

	public void setCounryID(int counryID) {
		this.counryID = counryID;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	@Override
	public int compareTo(Country o) {
		return this.counryID -  o.counryID; //- means ASC order.
	}

}
