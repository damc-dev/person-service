package com.dmcelligott.person.service;

import java.util.List;

import com.dmcelligott.person.model.Person;

public interface PersonService {
	
 public Person save(Person person) throws PersonServiceException;
 
 public Iterable<Person> findAll();
 
 public Person findOne(Long id);
 
 public List<Person> findByUserName(String userName);
}
