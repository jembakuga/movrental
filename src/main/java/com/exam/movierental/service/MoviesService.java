package com.exam.movierental.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.movierental.beans.MoviesBean;
import com.exam.movierental.entity.Movies;
import com.exam.movierental.repository.MoviesRepository;

@Service
public class MoviesService {
	
	private static final Logger logger = LoggerFactory.getLogger(MoviesService.class);

	@Autowired
	private MoviesRepository moviesRepository;
	
	public List<MoviesBean> findAllMovies(){
		logger.info("MoviesService | findAllMovies | start");
		try {
			List<MoviesBean> MoviesBeans = new ArrayList<MoviesBean>();
			for (Movies tmp : moviesRepository.findAll()) {
				MoviesBeans.add(new MoviesBean(tmp));
			}
			logger.info("MoviesService | findAllMovies | end");
			return MoviesBeans;
		} catch (Exception e) {
			logger.info("MoviesService | findAllMovies | Exception " + e.getMessage());
		}
		return null;
	}

}
