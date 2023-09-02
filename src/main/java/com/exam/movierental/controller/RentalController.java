package com.exam.movierental.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.movierental.entity.Rental;
import com.exam.movierental.service.RentalService;

@RestController
@RequestMapping("/rental")
public class RentalController {
	
	private static final Logger logger = LoggerFactory.getLogger(RentalController.class);
	
	@Autowired
	private RentalService rentalService;

	@PostMapping("/rent/{userId}/{movieId}")
	public Map<String, Object> rent(@PathVariable("userId") Long userId, @PathVariable("movieId") Long movieId) {
		logger.info("RentalController | rent | start");
		Map<String, Object> returnMap = new HashMap<String, Object>();	
		try {			
			logger.info("RentalController | rent | end");
			returnMap.put("success", true);
			returnMap.put("data", rentalService.rent(userId, movieId));
		} catch (Exception e) {
			logger.info("RentalController | rent | Exception: " + e.getMessage());
			returnMap.put("success", false);
			returnMap.put("message", e.getMessage());
		}
		return returnMap;
	}
	
	@PostMapping("/returnMovie/{rentId}")
	public Map<String, Object> returnMovie(@PathVariable("rentId") Long rentId) {
		logger.info("RentalController | returnMovie | start");
		Map<String, Object> returnMap = new HashMap<String, Object>();	
		try {			
			logger.info("RentalController | returnMovie | end");
			returnMap.put("success", true);
			returnMap.put("data", rentalService.returnMovie(rentId));
		} catch (Exception e) {
			logger.info("RentalController | returnMovie | Exception: " + e.getMessage());
			returnMap.put("success", false);
			returnMap.put("message", e.getMessage());
		}
		return returnMap;
	}

}
