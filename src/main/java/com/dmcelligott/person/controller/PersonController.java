package com.dmcelligott.person.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dmcelligott.person.model.Person;
import com.dmcelligott.person.service.PersonService;
import com.dmcelligott.person.service.PersonServiceException;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	
	@Autowired
	private PersonService service;

	@RequestMapping(method = { RequestMethod.GET }, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Iterable<Person>> listUsers() {
		return new ResponseEntity<Iterable<Person>>(service.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.GET }, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Person> getUser(@PathVariable Long id) {
		Person foundUser = service.findOne(id);
		if (foundUser == null) {
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Person>(foundUser, HttpStatus.OK);
		}
	}

	@RequestMapping(method = {
			RequestMethod.POST }, headers = "Accept=application/json", produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Person> createUser(@RequestBody Person person) {
		person.setCreatedDate(new java.sql.Date(new java.util.Date().getTime()));
		person.setLastAccessed(new java.sql.Date(new java.util.Date().getTime()));
		person.setIsActive(true);
		try {
			return new ResponseEntity<Person>(service.save(person), HttpStatus.CREATED);
		} catch (PersonServiceException e) {
			logger.error("Failed to create user: " + person.toString(), e);
			return new ResponseEntity<Person>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}
