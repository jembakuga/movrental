package com.exam.movierental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.exam.movierental.entity.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {

}
