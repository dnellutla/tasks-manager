package com.nice.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.nice.Exceptions.NotFoundException;
import com.nice.domain.User;
import com.nice.repository.UserRepository;
import com.nice.services.impl.UserServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userServiceImpl ;

	private long testUserId = 1l;
	private String testUserName = "testUserName1";
	private User testUser;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		testUser = new User(testUserName);
		testUser.setId(testUserId);
	}


	@Test
	public void createUserTest() {
		Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(testUser);

		User user = userServiceImpl.createUser(testUserName);

		Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any(User.class));
		assertNotNull(user);
		assertNotNull(user.getId());
		assertEquals(testUserName, user.getUserName());
	}

	@Test
	public void updateUserTest() {
		String updatedUserName = "updatedUserName";
		User updatedUser = new User(updatedUserName);
		updatedUser.setId(testUserId);

		Mockito.when(userRepository.findOne(Mockito.anyLong())).thenReturn(testUser);
		Mockito.when(userRepository.save(updatedUser)).thenReturn(updatedUser);

		User result = userServiceImpl.updateUser(testUserId, updatedUserName);

		Mockito.verify(userRepository, Mockito.times(1)).findOne(testUserId);
		Mockito.verify(userRepository, Mockito.times(1)).save(updatedUser);

		assertNotNull(result);
		assertEquals(testUserId, result.getId());
		assertEquals(updatedUserName, result.getUserName());
	}

	@Test
	public void deleteUserTest(){
		Mockito.when(userRepository.findByUserName(testUserName)).thenReturn(testUser);
		userRepository.delete(testUser);
		Mockito.verify(userRepository,Mockito.times(1)).delete(testUser);
	}
	@Test(expected = NotFoundException.class)
	public void shouldThrowException(){
		Mockito.when(userRepository.findOne(1L)).thenReturn(null);
		userServiceImpl.updateUser(1L, " ");
	}
}