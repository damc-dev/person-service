package user;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository repository;
	
	@RequestMapping(method={RequestMethod.GET}, produces="application/json")
	@ResponseBody
	public Iterable<User> listUsers() {
		return repository.findAll();
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.GET}, produces="application/json")
	@ResponseBody
	public User getUser(@PathVariable Long id) {
		return repository.findOne(id);
	}
	
	@RequestMapping(method={RequestMethod.POST}, headers="Accept=application/json", produces="application/json", consumes="application/json")
	@ResponseBody
	public User createUser(@RequestBody User user) {
		System.out.println("Saved: " + user.toString());
		user.setCreatedDate(new java.sql.Date(new java.util.Date().getTime()));
		user.setLastAccessed(new java.sql.Date(new java.util.Date().getTime()));
		user.setIsActive(true);
		return repository.save(user);
	}

}
