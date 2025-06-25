package com.pujan.bookr.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pujan.bookr.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}