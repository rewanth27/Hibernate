package com.ibm.model;

import javax.persistence.*;

@Entity
@Table(name="Address")
public class Address {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@Column(name = "Address_id")
	private int addressId;

	@Column(name = "Street")
	private String street;

	@Column(name = "City")
	private String city;

	@Column(name = "Zipcode")
	private String zipcode;

	@ManyToOne
	@JoinColumn(name="Person_id")
	private Person person;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}



}