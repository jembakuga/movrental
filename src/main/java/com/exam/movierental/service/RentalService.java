package com.exam.movierental.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.movierental.entity.Movie;
import com.exam.movierental.entity.Rental;
import com.exam.movierental.entity.User;
import com.exam.movierental.exception.MovieDoesNotExistException;
import com.exam.movierental.exception.NoAvailableMovieException;
import com.exam.movierental.exception.UserDoesNotExistException;
import com.exam.movierental.repository.MovieRepository;
import com.exam.movierental.repository.RentalRepository;
import com.exam.movierental.repository.UserRepository;

@Service
public class RentalService {

	private static final Logger logger = LoggerFactory.getLogger(RentalService.class);

	@Autowired
	private RentalRepository rentalRepository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	public Long rent(Long userId, Long movieId)
			throws NoAvailableMovieException, MovieDoesNotExistException, UserDoesNotExistException {
		logger.info("RentalService | rent | start");
		Movie movie = null;
		User user = null;
		Optional<User> userOptional = userRepository.findById(userId);
		Optional<Movie> movieOptional = movieRepository.findById(movieId);
		if (userOptional.isPresent()) {
			user = userOptional.get();
		} else {
			throw new UserDoesNotExistException();
		}
		if (movieOptional.isPresent()) {
			movie = movieOptional.get();
		} else {
			throw new MovieDoesNotExistException();
		}
		if (movie.getNoOfCopies() > 0) {
			Rental rental = new Rental();
			rental.setRentalDate(getCurrentDate());
			rental.setDueDate(computeDueDate());
			rental.setMovie(movie);
			rental.setUser(user);
			rentalRepository.save(rental);
			movie.setNoOfCopies(movie.getNoOfCopies() - 1);
			movieRepository.save(movie);
			logger.info("RentalService | rent | end");
			return rental.getId();
		} else {
			throw new NoAvailableMovieException();
		}
	}

	public Timestamp getCurrentDate() {
		Date date = new Date();
		return new Timestamp(date.getTime());
	}

	public Timestamp computeDueDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 7);
		return new Timestamp(cal.getTime().getTime());
	}

}
