package com.exam.movierental.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String, Object> createUser(String name, String emailAddress) {
		logger.info("UserController | createUser | start");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			logger.info("UserController | createUser | end");
			UserBean userBean = new UserBean(null, name, emailAddress);
			userBean.setId(userService.createUser(userBean).getId());
			returnMap.put("success", true);
			returnMap.put("data", userBean);
		} catch (Exception e) {
			returnMap.put("success", false);
			returnMap.put("message", e.getMessage());
			logger.info("UserController | createUser | Exception: " + e.getMessage());
		}
		return returnMap;
	}

	@GetMapping("/findAllUser")
	public Map<String, Object> findAllUser() {
		logger.info("UserController | findAllUser | start");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			logger.info("UserController | findAllUser | end");
			List<UserBean> userBeanList = userService.findAllUser();
			returnMap.put("success", true);
			returnMap.put("data", userBeanList);
		} catch (Exception e) {
			returnMap.put("success", false);
			returnMap.put("message", e.getMessage());
			logger.info("UserController | findAllUser | Exception: " + e.getMessage());
		}
		return returnMap;
	}

	@GetMapping("/findUserHistory/{id}")
	public Map<String, Object> findUserHistory(@PathVariable("id") Long id) {
		logger.info("UserController | findUserById | start");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			logger.info("UserController | findUserById | end");
			UserBean userBean = userService.findUserById(id);
			returnMap.put("success", true);
			returnMap.put("data", userBean);
		} catch (Exception e) {
			returnMap.put("success", false);
			returnMap.put("message", e.getMessage());
			logger.info("UserController | findUserById | Exception: " + e.getMessage());
		}
		return returnMap;
	}

}
