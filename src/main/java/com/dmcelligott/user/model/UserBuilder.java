package com.dmcelligott.user.model;

import java.sql.Date;

public class UserBuilder {
	protected Long id;
	protected String emailAddress;
	protected String userName;
	protected String firstName;
	protected String lastName;
	protected Date createdDate;
	protected Date lastAccessed;
	protected Boolean isActive = Boolean.TRUE;

	public UserBuilder() {
	}

	public UserBuilder id(Long id) {
		this.id = id;
		return this;
	}

	public UserBuilder emailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}

	public UserBuilder userName(String userName) {
		this.userName = userName;
		return this;
	}

	public UserBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public UserBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public UserBuilder createdDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public UserBuilder lastAccessed(Date lastAccessed) {
		this.lastAccessed = lastAccessed;
		return this;
	}

	public UserBuilder isActive(Boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public User build() {
		return new User(this);
	}
}
