package com.exam.movierental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.movierental.beans.UserBean;
import com.exam.movierental.entity.User;
import com.exam.movierental.exception.UserDoesNotExistException;
import com.exam.movierental.repository.UserRepository;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public Long createUser(UserBean userBean) {
		logger.info("UserService | createUser | start");
		User user = new User(userBean);
		logger.info("UserService | createUser | end");
		return userRepository.save(user).getId();

	}

	public List<UserBean> findAllUser() {
		logger.info("UserService | findAllUser | start");
		List<UserBean> userBeanList = new ArrayList<UserBean>();
		for (User tmp : userRepository.findAll()) {
			userBeanList.add(new UserBean(tmp));
		}
		logger.info("UserService | findAllUser | end");
		return userBeanList;
	}

	public UserBean findUserById(Long id) throws UserDoesNotExistException{
		logger.info("UserService | findUserById | start");
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return new UserBean(user.get());
		}else {
			throw new UserDoesNotExistException();
		}
	}

}
