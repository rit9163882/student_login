package com.journaldev.spring.model;

public class User {
	private String userName;
	private String userID;
	private String emailID;
	private boolean validate;

	public String getUserName() {
		return userName;
	}
	public String getUserID(){return userID;}
	public String getEmailID(){return emailID;}
	public boolean checkValidity(){return this.validate;}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserID(String userID1) {
		for(int i=0;i<userID1.length();i++){
			if(userID1.charAt(i)<'0'||userID1.charAt(i)>'9'){
				this.validate=false;
				return;
			}
		}
		this.userID = userID1;
		this.validate=true;
	}
	public void setEmailID(String emailID1) {
		this.emailID = emailID1;
	}
}
