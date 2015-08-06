package user.controller;

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

import user.model.User;
import user.service.UserService;
import user.service.UserServiceException;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping(method = { RequestMethod.GET }, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Iterable<User>> listUsers() {
		return new ResponseEntity<Iterable<User>>(service.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.GET }, produces = "application/json")
	@ResponseBody
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		User foundUser = service.findOne(id);
		if (foundUser == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(foundUser, HttpStatus.OK);
		}
	}

	@RequestMapping(method = {
			RequestMethod.POST }, headers = "Accept=application/json", produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<User> createUser(@RequestBody User user) {
		user.setCreatedDate(new java.sql.Date(new java.util.Date().getTime()));
		user.setLastAccessed(new java.sql.Date(new java.util.Date().getTime()));
		user.setIsActive(true);
		try {
			return new ResponseEntity<User>(service.save(user), HttpStatus.CREATED);
		} catch (UserServiceException e) {
			return new ResponseEntity<User>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}
