package com.exam.movierental.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class MovieRepositoryTest {
	
	@Autowired
	private MovieRepository movieRepository;
	

}
