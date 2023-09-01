package com.exam.movierental.repository;

import org.springframework.data.repository.CrudRepository;

import com.exam.movierental.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
