package com.dmcelligott.user.controller;

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

import com.dmcelligott.user.UserServiceApplication;
import com.dmcelligott.user.model.User;
import com.dmcelligott.user.model.UserBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UserServiceApplication.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class UserControllerTest {

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
	public void findUserByEmailAddress_emailAddressExists_shouldReturnUser() throws Exception {
	
	
	}

	@Test
	public void createUser_userIsValid_shouldReturnCreatedUser() {
		User user = new UserBuilder().userName("bob123").emailAddress("bob@example.com").firstName("Bob")
				.lastName("Smith").isActive(null).build();

		ResponseEntity<User> response = template.postForEntity(base.toString() + "/user", user, User.class);
		Assert.assertThat(response.getStatusCode(), Matchers.equalTo(HttpStatus.CREATED));

	}

}
