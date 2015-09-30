package com.dmcelligott.person.service;

import com.dmcelligott.person.model.Person;

public interface PersonService {

	public Person save(Person person) throws PersonServiceException;

	public Iterable<Person> findAll();

	public Person findOne(Long id);

}
