package com.test.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "Employee_Table")

// fakt address karayacha ahe tar id user ne dileli id ani db madhali id equal ahe kay
// name  user ne dileli object madhil name ani db madhali name  equal ahe kay.
// mag  user ne dileli object madhil address ani db madhali address  diffrent tar db madhil address update.
//eka address column sathi bakihe check karayachi garaj ahe noooo. so use dirty checking @DynamicUpdate use kara....
@DynamicUpdate
public class Employee implements Serializable {

	@Id
	@Column(name = "id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // identity means seprate Table tayara karat nahi for id. other
														// similar to AUTO.
	private int id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	//cascade jevha employee store hoto tyaveli address table madhe pan data store houde tar te lagech mapping ani referencing fk hoil nahi tar exception  yenar ki employee table madhe data first insert zala tar to point manaje one to one sathi 1 mahesh -> null (address table data la karata ahe give exception. of transient.) 
	//@Cascade(CascadeType.ALL) // Employee table madhe data store asatana address madhe pan store houde mag
								// lagech mapping hoil.
	//cascade means employee ani address donhi table madhe at a time data store houde. 
	//jar cascade manaje parent ani child at a time save kara jar tumhala hey karayache nasel tar seprate employee save kara ani seprate address save kara too much time consuming .tyapeksha cascade use kara.
	//save() method use karatana  karatana cascade for parent and child data save karav lagata persist method madhe karav lagat nahi.
	@OneToOne(fetch = FetchType.LAZY, targetEntity = Address.class)
	private Address address;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}
