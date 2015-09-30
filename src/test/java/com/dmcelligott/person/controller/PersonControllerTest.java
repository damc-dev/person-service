package com.dmcelligott.person.controller;

import java.net.URL;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
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
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
		template = new TestRestTemplate();
	}

	@Test
	public void createPerso_personIsValid_shouldReturnCreatedPerson() {
		Person person = new PersonBuilder().userId(1L).firstName("Bob")
				.lastName("Smith").build();

		ResponseEntity<Person> response = template.postForEntity(
				base.toString() + "/user", person, Person.class);
		Assert.assertThat(response.getStatusCode(),
				Matchers.equalTo(HttpStatus.CREATED));

	}

}
