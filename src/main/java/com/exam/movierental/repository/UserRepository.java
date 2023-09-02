package com.exam.movierental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.movierental.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
