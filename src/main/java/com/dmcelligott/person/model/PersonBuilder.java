package com.dmcelligott.person.model;

import java.sql.Date;

public class PersonBuilder {
	protected Long id;
	protected Long userId;
	protected String firstName;
	protected String lastName;
	protected Date createdDate;
	protected Date lastAccessed;
	
	public PersonBuilder() {
	}

	public PersonBuilder id(Long id) {
		this.id = id;
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

	public PersonBuilder userId(long userId) {
		this.userId = userId;
		return this;
	}

	public Person build() {
		return new Person(this);
	}
}
