package com.exam.movierental.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exam.movierental.beans.UserBean;
import com.exam.movierental.entity.User;
import com.exam.movierental.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	@Test
	public void UserService_CreateUser_ReturnsUser() {
		User user = new User(1L, "user 1", "test@asdf.com");		
		UserBean userBean = new UserBean(null, "user 1", "test@asdf.com");
		
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user);		
		User userCreated = userService.createUser(userBean);		
		Assertions.assertThat(userCreated).isNotNull();

	}
	
	@Test
	public void UserService_FindAll_ReturnUserMultiple() {
		User user = new User(1L, "user 1", "testa@asf.com");		
		User user2 = new User(2L, "user 2", "testa@asf.com");		
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		userList.add(user2);
		when(userRepository.findAll()).thenReturn(userList);
		List<UserBean> userBeanList = userService.findAllUser();
		Assertions.assertThat(userBeanList).isNotNull();
	}
	
	@Test
	public void UserService_FindById_ReturnUser() throws Exception {
		User user = new User(1L, "user 1", "testa@asf.com");
		
		when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user));		
		UserBean userBean = userService.findUserById(1L);		
		Assertions.assertThat(userBean).isNotNull();
		Assertions.assertThat(userBean.getId()).isEqualTo(1);
		
	}

}
