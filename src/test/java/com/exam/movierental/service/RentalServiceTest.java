package com.exam.movierental.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exam.movierental.entity.Movie;
import com.exam.movierental.entity.Rental;
import com.exam.movierental.entity.User;
import com.exam.movierental.exception.MovieDoesNotExistException;
import com.exam.movierental.exception.NoAvailableMovieException;
import com.exam.movierental.exception.UserDoesNotExistException;
import com.exam.movierental.repository.MovieRepository;
import com.exam.movierental.repository.RentalRepository;
import com.exam.movierental.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class RentalServiceTest {
	
	@Mock
	private RentalRepository rentalRepository;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock 
	private MovieRepository movieRepository;
	
	@InjectMocks
	private RentalService rentalService;
	
	User user =  null;
	Movie movie = null;
	Movie updatedMovie = null;
	Rental rental = null;
			
	
	@BeforeEach
	public void setup() {
		user = new User(1L, "user 1", "testa@asf.com");
		movie = new Movie(1L, "Titanic", "Love Story", 1998, new BigDecimal(50), 1);
		rental = new Rental(1L, movie, getCurrentDate(), computeDueDate());
		updatedMovie = new Movie(1L, "Titanic", "Love Story", 1998, new BigDecimal(50), 1);
		
	}

	@Test
	void RentalService_Rent_Success() throws NoAvailableMovieException, MovieDoesNotExistException, UserDoesNotExistException {
		when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user));
		when(movieRepository.findById(1L)).thenReturn(Optional.ofNullable(movie));
		when(rentalRepository.save(Mockito.any(Rental.class))).thenReturn(rental);
		when(movieRepository.save(Mockito.any(Movie.class))).thenReturn(updatedMovie);
		Rental returnRental = rentalService.rent(1L, 1L);
		Assertions.assertThat(returnRental).isNotNull();	
	}
	
	@Test
	void RentalService_Rent_Failure_NoAvailableCopy() {
		Movie noAvailCopyMovie = new Movie(1L, "Titanic", "Love Story", 1998, new BigDecimal(50), 0);
		when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user));
		when(movieRepository.findById(1L)).thenReturn(Optional.ofNullable(noAvailCopyMovie));
		assertThrows(NoAvailableMovieException.class, () -> rentalService.rent(1L, 1L));
		
	}
	
	@Test
	void RentalService_Rent_Failure_NoMovieAvailable() {
		Movie noMovieAvail = null;
		when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user));
		when(movieRepository.findById(1L)).thenReturn(Optional.ofNullable(noMovieAvail));
		assertThrows(MovieDoesNotExistException.class, () -> rentalService.rent(1L, 1L));
	}
	
	@Test
	void RentalService_Rent_Failure_NoUserAvailable() {
		User noAvailUser = null;
		when(userRepository.findById(7L)).thenReturn(Optional.ofNullable(noAvailUser));
		when(movieRepository.findById(1L)).thenReturn(Optional.ofNullable(movie));
		assertThrows(UserDoesNotExistException.class, () -> rentalService.rent(7L, 1L));
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
