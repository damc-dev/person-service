package com.dmcelligott.person.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.dmcelligott.person.Application;
import com.dmcelligott.person.model.Person;
import com.dmcelligott.person.model.PersonBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class PersonControllerTest {

	@Value("${local.server.port}")
	private int port;

	private URL base;
	private static final String PERSON_PATH = "/person";
	
	private RestTemplate template;

	private Person person1 = new PersonBuilder().userId(1L).firstName("Bob")
			.lastName("Smith").build();
	
	private Person person2 = new PersonBuilder().userId(1L).firstName("Joe")
			.lastName("Shmoe").build();

	private Person person3 = new PersonBuilder().userId(1L).firstName("John")
			.lastName("Johnson").build();
	
	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
		template = new TestRestTemplate();
	}

	@Test
	public void getPeople_whenPeopleExist_shouldReturnListOfPeople() {
		createPerson(person1);
		createPerson(person2);
		
		ResponseEntity<Person[]> response = template.getForEntity(base.toString() + PERSON_PATH, Person[].class);
		List<Person> people = Arrays.asList(response.getBody());
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(people.size(), Matchers.greaterThanOrEqualTo(2));
		assertThat(people.get(0).getId(), equalTo(1L));
		assertThat(people.get(0).getFirstName(), equalTo("Bob"));
	}
	
	@Test
	public void getPerson_whenPersonExists_shouldReturnPerson() throws Exception {
		createPerson(person1);
		createPerson(person2);
		
		ResponseEntity<Person> response = template.getForEntity(base.toString() + PERSON_PATH + "/2", Person.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		
		Person person = response.getBody();
		assertThat(person.getId(), equalTo(2L));
	}
	
	@Test
	public void createPerson_whenPersonIsValid_shouldReturnCreatedPerson() {
		
		ResponseEntity<Person> response = createPerson(person3 );
		
		assertThat(response.getStatusCode(),
				equalTo(HttpStatus.CREATED));
	}

	private ResponseEntity<Person> createPerson(Person person) {
		ResponseEntity<Person> response = template.postForEntity(
				base.toString() + PERSON_PATH, person, Person.class);
		return response;
	}
}
