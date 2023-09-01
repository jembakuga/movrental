package com.exam.movierental.controller;

import java.util.List;

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
	public List<MovieBean> findAllMovies(){
		logger.info("MoviesController | findAllMovies | start");
		try {
			logger.info("MoviesController | findAllMovies | end");
			return moviesService.findAllMovies();
		} catch (Exception e) {
			logger.info("MoviesController | findAllMovies | Exception: " + e.getMessage());
		}
		return null;
	}
	
	@GetMapping("/findAllMovies/{id}")
	public MovieBean findMoviesById(@PathVariable("id") Long id){
		logger.info("MoviesController | findMoviesById | start");
		try {
			logger.info("MoviesController | findMoviesById | end");
			return moviesService.findMoviesById(id);
		} catch (Exception e) {
			logger.info("MoviesController | findMoviesById | Exception: " + e.getMessage());
		}
		return null;
	}
	
}
