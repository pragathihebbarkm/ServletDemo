package com.jsp.tagdemo;

public class Student {

	private String firstname;
	private String lastname;
	private boolean above90Percent;
	
	public Student(String firstname, String lastname, boolean above90Percent) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.above90Percent = above90Percent;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public boolean isAbove90Percent() {
		return above90Percent;
	}

	public void setAbove90Percent(boolean above90Percent) {
		this.above90Percent = above90Percent;
	}
}
