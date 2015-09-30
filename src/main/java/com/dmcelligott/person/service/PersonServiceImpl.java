package com.dmcelligott.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmcelligott.person.dao.PersonRepository;
import com.dmcelligott.person.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository repository;

	@Override
	public Person save(Person person) throws PersonServiceException {
		return repository.save(person);
	}

	@Override
	public Iterable<Person> findAll() {
		return repository.findAll();
	}

	@Override
	public Person findOne(Long id) {
		return repository.findOne(id);
	}
}
