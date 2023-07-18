package com.royal.bean;

public class EmployeeBean {
	private int id;
	private String email;
	private String feedback;

	
	public EmployeeBean(int id, String email, String feedback) {
		super();
		this.id = id;
		this.email = email;
		this.feedback = feedback;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeedBack() {
		return feedback;
	}

	public void setFeedBack(String feedback) {
		this.feedback = feedback;
	}
}
