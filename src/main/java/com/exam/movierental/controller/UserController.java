package com.exam.movierental.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.movierental.beans.UserBean;
import com.exam.movierental.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/createUser")
	public UserBean createUser(UserBean userBean) {
		logger.info("UserController | createUser | start");
		try {
			logger.info("UserController | createUser | end");
			userBean.setId(userService.createUser(userBean));
		} catch (Exception e) {
			logger.info("UserController | createUser | Exception: " + e.getMessage());
		}
		return userBean;
	}

	@GetMapping("/findAllUser")
	public List<UserBean> findAllUser() {
		logger.info("UserController | findAllUser | start");
		try {
			logger.info("UserController | findAllUser | end");
			return userService.findAllUser();
		} catch (Exception e) {
			logger.info("UserController | findAllUser | Exception: " + e.getMessage());
		}
		return null;
	}

	@GetMapping("/findAllUser/{id}")
	public UserBean findUserById(@PathVariable("id") Long id) {
		logger.info("UserController | findUserById | start");
		try {
			logger.info("UserController | findUserById | end");
			return userService.findUserById(id);
		} catch (Exception e) {
			logger.info("UserController | findUserById | Exception: " + e.getMessage());
		}
		return null;
	}

}
