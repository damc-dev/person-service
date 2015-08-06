package user;

import org.junit.Test;
import org.mockito.Mock;

import user.dao.UserRepository;

public class UserServiceImplTest {

	@Mock
	private UserRepository userRepository;

	@Test
	public void createNewUser_userNameNotExists_createUser() throws Exception {

	}

}
