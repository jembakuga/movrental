package com.exam.movierental.repository;

import org.springframework.data.repository.CrudRepository;

import com.exam.movierental.entity.Movies;

public interface MoviesRepository extends CrudRepository<Movies, Long>{

}
