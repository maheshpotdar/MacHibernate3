package com.test.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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

	@Column(name = "address", length = 100, nullable = false)
	private String address;

	@Embedded
	@ElementCollection //Collection working use this annotation.
	//sequence-gen == reference of column country tyasathi @GenericGenerator use kela ref create karanyasathi.
	@GenericGenerator(name = "sequence12345",strategy = "sequence") //stratergy = identity means no third table create for ID nextID.,ithe auto,sequence,identity,table chalato.
	//second joined tabled tya table la primary key denyasathi ha annotation @CollectionId because that table only contain name,city,foreignKeyofFirstTable now we added primary key on that table as well.
	@CollectionId(columns = {@Column(name = "PRIMARY_KEY_OF_Country_Table")},generator = "sequence12345",type=@Type(type = "int")) 
	@JoinTable(name = "SECOND_TABLE",joinColumns = @JoinColumn(name="IDX"))
	private List<Country> country;

	/*
	 * 	@GenericGenerator(name = "sequence-gen",strategy = "identity") //stratergy = identity means no third table create for ID nextID.
	 *	@CollectionId(columns = {@Column(name = "PRIMARY_KEY_OF_Country_Table")},generator = "sequence-gen",type=@Type(type = "int")) //second joined tabled tya table la primary key denyasathi ha annotation because that table only contain name,city,foreignKeyofFirstTable now we added primary key on that table as well.
	 *
	 * generator is just for reference of this column country. reference name = sequence-gen 
	 * 
	 * @CollectionId(columns = {@Column(name = "PRIMARY_KEY_OF_Country_Table")} PRIMARY_KEY_OF_Country_Tab= Primary key of second table.
	 * generator = "sequence-gen" referencing this column .
	 * type = tya primary key cha datatype int asel.
	 */
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, String address, List<Country> country) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.country = country;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Country> getCountry() {
		return country;
	}

	public void setCountry(List<Country> country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", country=" + country + "]";
	}

}
