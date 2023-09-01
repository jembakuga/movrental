package com.exam.movierental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.movierental.beans.UserBean;
import com.exam.movierental.beans.UserBean;
import com.exam.movierental.entity.User;
import com.exam.movierental.entity.User;
import com.exam.movierental.repository.UserRepository;

@Service
public class UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public Long createUser(UserBean userBean) {
		logger.info("UserService | createUser | start");
		try {
			logger.info("UserService | createUser | end");
			User user = new User(userBean);
			return userRepository.save(user).getId();
		} catch (Exception e) {
			logger.info("UserService | createUser | Exception: " + e.getMessage());
		}
		return null;
	}
	
	public List<UserBean> findAllUser(){
		logger.info("UserService | findAllUser | start");
		try {
			List<UserBean> UserBeans = new ArrayList<UserBean>();
			for (User tmp : userRepository.findAll()) {
				UserBeans.add(new UserBean(tmp));
			}
			logger.info("UserService | findAllUser | end");
			return UserBeans;
		} catch (Exception e) {
			logger.info("UserService | findAllUser | Exception " + e.getMessage());
		}
		return null;
	}
	
	public UserBean findUserById(Long id) {
		logger.info("UserService | findUserById | start");
		try {
			Optional<User> user = userRepository.findById(id);
			return user.isPresent() ? new UserBean(user.get()) : null;
		} catch (Exception e) {
			logger.info("UserService | findUserById | Exception " + e.getMessage());
		}
		return null;
	}

}
