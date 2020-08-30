package com.github.restassured.entities;

public class UserResponse {

	private Status status;
	private UserEntry userEntry;

	public UserEntry getUserEntry() {
		return userEntry;
	}

	public void setUserEntry(UserEntry userEntry) {
		this.userEntry = userEntry;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
