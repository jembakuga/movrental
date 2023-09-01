package com.exam.movierental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.movierental.beans.MovieBean;
import com.exam.movierental.entity.Movie;
import com.exam.movierental.repository.MovieRepository;

@Service
public class MovieService {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

	@Autowired
	private MovieRepository moviesRepository;
	
	public List<MovieBean> findAllMovies(){
		logger.info("MoviesService | findAllMovies | start");
		try {
			List<MovieBean> MoviesBeans = new ArrayList<MovieBean>();
			for (Movie tmp : moviesRepository.findAll()) {
				MoviesBeans.add(new MovieBean(tmp));
			}
			logger.info("MoviesService | findAllMovies | end");
			return MoviesBeans;
		} catch (Exception e) {
			logger.info("MoviesService | findAllMovies | Exception " + e.getMessage());
		}
		return null;
	}
	
	public MovieBean findMoviesById(Long id) {
		logger.info("MoviesService | findMoviesById | start");
		try {
			Optional<Movie> movies = moviesRepository.findById(id);
			return movies.isPresent() ? new MovieBean(movies.get()) : null;
		} catch (Exception e) {
			logger.info("MoviesService | findMoviesById | Exception " + e.getMessage());
		}
		return null;
	}

}
