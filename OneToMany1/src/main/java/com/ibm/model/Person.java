package com.ibm.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Person")

public class Person {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@Column(name = "Person_id")
	private int person_id;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name="LastName")
	private String lastName;

	@Column(name="Age")
	private int age;

	@Column(name = "Education")
	private String Education;

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEducation() {
		return Education;
	}

	public void setEducation(String education) {
		Education = education;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@OneToMany(mappedBy="person")
	private Set<Address> addresses;
}