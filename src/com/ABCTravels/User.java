package com.ABCTravels;

public class User {

	private String firstName;
	
	private String lastName;
	
	private long mobileNumber;
	
	private char gender;
	
	private String emailId;
	
	private String password;
	
	private int failedCount;
	
	private String accoutStatus;

	public User(String firstName, String lastName, long mobileNumber, char gender, String emailId, String password,
			int failedCount, String accoutStatus) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.emailId = emailId;
		this.password = password;
		this.failedCount = failedCount;
		this.accoutStatus = accoutStatus;
	}

	public User() {
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

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFailedCount() {
		return failedCount;
	}

	public void setFailedCount(int failedCount) {
		this.failedCount = failedCount;
	}

	public String getAccoutStatus() {
		return accoutStatus;
	}

	public void setAccoutStatus(String accoutStatus) {
		this.accoutStatus = accoutStatus;
	}
}
