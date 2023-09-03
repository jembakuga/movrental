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
import com.exam.movierental.entity.User;
import com.exam.movierental.exception.MovieDoesNotExistException;
import com.exam.movierental.repository.MovieRepository;

@Service
public class MovieService {

	private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

	@Autowired
	private MovieRepository moviesRepository;
	
	public Movie createMovie(MovieBean movieBean) {
		logger.info("MovieService | createMovie | start");
		Movie movie = new Movie(movieBean);
		logger.info("MovieService | createMovie | end");
		return moviesRepository.save(movie);

	}

	public List<MovieBean> findAllMovies() {
		logger.info("MoviesService | findAllMovies | start");
		List<MovieBean> MoviesBeans = new ArrayList<MovieBean>();
		for (Movie tmp : moviesRepository.findAll()) {
			MoviesBeans.add(new MovieBean(tmp));
		}
		logger.info("MoviesService | findAllMovies | end");
		return MoviesBeans;
	}

	public MovieBean findMoviesById(Long id)throws MovieDoesNotExistException {
		logger.info("MoviesService | findMoviesById | start");
			Optional<Movie> movies = moviesRepository.findById(id);
			if( movies.isPresent()) {
				return new MovieBean(movies.get());
			}else {
				throw new MovieDoesNotExistException();
			}
	}

}
