package com.example.ReactDilrb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReactDilrb.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
