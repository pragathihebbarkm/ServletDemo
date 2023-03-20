package com.mywebapp.model;

public class Student {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	public Student(String firstname, String lastname, String email) {
		super();
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
	}
	
	public Student(int id, String firstname, String lastname, String email) {
		super();
		this.id = id;
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstName + ", lastname=" + lastName + ", email=" + email + "]";
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstName;
	}
	
	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}
	
	public String getLastname() {
		return lastName;
	}
	
	public void setLastname(String lastname) {
		this.lastName = lastname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
