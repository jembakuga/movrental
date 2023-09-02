package com.exam.movierental.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.exam.movierental.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void UserRepository_Save_ReturnSavedMovide() {
		User user = new User();
		user.setEmailAddress("test@afs.com");
		user.setName("Test name");		
		User savedUser = userRepository.save(user);		
		Assertions.assertThat(savedUser).isNotNull();
		Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void UserRepository_FindAll_ReturnMovieMoreThanOne() {
		User user = new User();
		user.setEmailAddress("test@afs.com");
		user.setName("Test name");		
		User user2 = new User();
		user2.setEmailAddress("test@afs.com");
		user2.setName("Test name");				
		userRepository.save(user);
		userRepository.save(user2);		
		List<User> userList = userRepository.findAll();
		
		Assertions.assertThat(userList).isNotNull();
		Assertions.assertThat(userList.size()).isEqualTo(2);
		
	}
	
	
	@Test
	public void UserRepository_FindById_ReturnMovie() {
		User user = new User();
		user.setEmailAddress("test@afs.com");
		user.setName("Test name");				
		user = userRepository.save(user);		
		User retrievedUser = userRepository.findById(user.getId()).get();
		
		Assertions.assertThat(retrievedUser).isNotNull();
		
	}

}
