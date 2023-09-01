package com.exam.movierental.repository;

import org.springframework.data.repository.CrudRepository;

import com.exam.movierental.entity.Rental;

public interface RentalRepository extends CrudRepository<Rental, Long> {

}
