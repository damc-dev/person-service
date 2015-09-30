package com.dmcelligott.person.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	private String emailAddress;
	private String userName;
	private String firstName;
	private String lastName;
	private Date createdDate;
	private Date lastAccessed;

	private Boolean isActive = Boolean.TRUE;

	public Person() {
	}

	protected Person(PersonBuilder builder) {
		this.id = builder.id;
		this.emailAddress = builder.emailAddress;
		this.userName = builder.userName;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.createdDate = builder.createdDate;
		this.lastAccessed = builder.lastAccessed;
		this.isActive = builder.isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastAccessed() {
		return lastAccessed;
	}

	public void setLastAccessed(Date lastAccessed) {
		this.lastAccessed = lastAccessed;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", emailAddress=" + emailAddress + ", userName=" + userName + ", firstName="
				+ firstName + ", lastName=" + lastName + ", createdDate=" + createdDate + ", lastAccessed="
				+ lastAccessed + ", isActive=" + isActive + "]";
	}
}
