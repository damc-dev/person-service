package com.dmcelligott.person.model;

import java.sql.Date;

public class PersonBuilder {
	protected Long id;
	protected String emailAddress;
	protected String userName;
	protected String firstName;
	protected String lastName;
	protected Date createdDate;
	protected Date lastAccessed;
	protected Boolean isActive = Boolean.TRUE;

	public PersonBuilder() {
	}

	public PersonBuilder id(Long id) {
		this.id = id;
		return this;
	}

	public PersonBuilder emailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}

	public PersonBuilder userName(String userName) {
		this.userName = userName;
		return this;
	}

	public PersonBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public PersonBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public PersonBuilder createdDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public PersonBuilder lastAccessed(Date lastAccessed) {
		this.lastAccessed = lastAccessed;
		return this;
	}

	public PersonBuilder isActive(Boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public Person build() {
		return new Person(this);
	}
}
