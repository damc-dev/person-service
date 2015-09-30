package com.dmcelligott.person.service;

import java.util.List;

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
		if (!repository.findByUserName(person.getUserName()).isEmpty()) {
			throw new PersonServiceException("The username specified already exists");
		} else {
			System.out.println("Saved: " + person.toString());
			return repository.save(person);
		}
	}

	@Override
	public Iterable<Person> findAll() {
		return repository.findAll();
	}

	@Override
	public Person findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Person> findByUserName(String userName) {
		return repository.findByUserName(userName);
	}

}
