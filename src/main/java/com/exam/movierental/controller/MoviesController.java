package com.exam.movierental.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.movierental.beans.MoviesBean;
import com.exam.movierental.service.MoviesService;

@RestController
@RequestMapping("/movies")
public class MoviesController {

	private static final Logger logger = LoggerFactory.getLogger(MoviesController.class);

	@Autowired
	private MoviesService moviesService;
	
	@RequestMapping("/findAllMovies")
	public List<MoviesBean> findAllMovies(){
		logger.info("MoviesController | findAllMovies | start");
		try {
			logger.info("MoviesController | findAllMovies | end");
			return moviesService.findAllMovies();
		} catch (Exception e) {
			logger.info("MoviesController | findAllMovies | Exception: " + e.getMessage());
		}
		return null;
	}
	
}
