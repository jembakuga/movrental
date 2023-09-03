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
import com.exam.movierental.exception.MovieAlreadyReturnedException;
import com.exam.movierental.exception.MovieDoesNotExistException;
import com.exam.movierental.exception.NoAvailableMovieException;
import com.exam.movierental.exception.RentDoesNotExistException;
import com.exam.movierental.exception.UserDoesNotExistException;
import com.exam.movierental.repository.MovieRepository;
import com.exam.movierental.repository.RentalRepository;
import com.exam.movierental.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class RentalService {

	private static final Logger logger = LoggerFactory.getLogger(RentalService.class);

	@Autowired
	private RentalRepository rentalRepository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	public Rental rent(Long userId, Long movieId)
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
			rental.setReturned("N");
			rentalRepository.save(rental);
			movie.setNoOfCopies(movie.getNoOfCopies() - 1);
			movieRepository.save(movie);
			logger.info("RentalService | rent | end");
			return rental;
		} else {
			throw new NoAvailableMovieException();
		}
	}
	
	@Transactional
	public Rental returnMovie(Long rentId)throws RentDoesNotExistException, MovieAlreadyReturnedException {
		logger.info("RentalService | returnMovie | start");
		Optional<Rental> rentalOptional = rentalRepository.findById(rentId);
		Rental rental = null;
		if(rentalOptional.isPresent()) {
			rental = rentalOptional.get();
			if(rental.getReturned().equals("Y")) {
				throw new MovieAlreadyReturnedException();
			}
			rental.setReturned("Y");
			rentalRepository.save(rental);
			Movie movie = rental.getMovie();
			movie.setNoOfCopies(movie.getNoOfCopies() + 1);
			movieRepository.save(movie);
		}else {
			throw new RentDoesNotExistException();
		}
		logger.info("RentalService | returnMovie | end");
		return rental;
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
