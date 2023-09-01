package com.exam.movierental.repository;

import org.springframework.data.repository.CrudRepository;

import com.exam.movierental.entity.Rentals;

public interface RentalsRepository extends CrudRepository<Rentals, Long> {

}
