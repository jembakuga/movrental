package com.exam.movierental.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.movierental.beans.MovieBean;
import com.exam.movierental.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

	@Autowired
	private MovieService moviesService;
	
	@GetMapping("/findAllMovies")
	public Map<String, Object> findAllMovies(){
		logger.info("MoviesController | findAllMovies | start");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			logger.info("MoviesController | findAllMovies | end");
			List<MovieBean> movieList = moviesService.findAllMovies();
			returnMap.put("success", true);
			returnMap.put("data", movieList);
		} catch (Exception e) {
			returnMap.put("success", false);
			returnMap.put("message", e.getMessage());
			logger.info("MoviesController | findAllMovies | Exception: " + e.getMessage());
		}
		return returnMap;
	}
	
	@GetMapping("/findAllMovies/{id}")
	public Map<String, Object> findMoviesById(@PathVariable("id") Long id){
		logger.info("MoviesController | findMoviesById | start");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			logger.info("MoviesController | findMoviesById | end");
			MovieBean movieBean = moviesService.findMoviesById(id);
			returnMap.put("success", true);
			returnMap.put("data", movieBean);
		} catch (Exception e) {
			returnMap.put("success", false);
			returnMap.put("message", e.getMessage());
			logger.info("MoviesController | findMoviesById | Exception: " + e.getMessage());
		}
		return returnMap;
	}
	
}
