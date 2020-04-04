package com.dateme;

public class User {
	 private String USERNAME;
	 private String FIRST_NAME;
	 private String LAST_NAME;
	 private String E_MAIL;
	 private String PASSWORD;
	 private String DOB;
	 private String SEX;
	 public User(String USERNAME, String FIRST_NAME, String LAST_NAME,
			 String E_MAIL,String PASSWORD, String DOB, String SEX) {
			 super();
			 this.USERNAME = USERNAME;
			 this.FIRST_NAME = getFirstname();
			 this.LAST_NAME = getSurname();
			 this.E_MAIL = getEmail();
			 this.PASSWORD = PASSWORD;
			 this.DOB = DOB;
			 this.SEX = SEX;
			 }
	public String getUsername() {
		 return USERNAME;
		 }
		 public void setUsername(String username) {
		 this.USERNAME = username;
		 }
	 public String getFirstname() {
	 return FIRST_NAME;
	 }
	 public void setFirstname(String firstname) {
	 this.FIRST_NAME = firstname;
	 }
	 public String getSurname() {
	 return LAST_NAME;
	 }
	 public void setSurname(String surname) {
	 this.LAST_NAME = surname;
	 }
	 public String getEmail() {
	 return E_MAIL;
	 }
	 public void setEmail(String email) {
	 this.E_MAIL = email;
	 }
	 public String getPassword() {
	 return PASSWORD;
	 }
	 public void setPassword(String password) {
	 this.PASSWORD = password;
	 }
	 public String getDob() {
	 return DOB;
	 }
	 public void setDob(String dob) {
	 this.DOB = dob;
	 }
	 public String getSex() {
	 return SEX;
	 }
	 public void setSex(String sex) {
	 this.SEX = sex;
	 }
	}