package com.exam.movierental.repository;

import org.springframework.data.repository.CrudRepository;

import com.exam.movierental.entity.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long>{

}
