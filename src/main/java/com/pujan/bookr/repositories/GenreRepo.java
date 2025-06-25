package com.pujan.bookr.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pujan.bookr.entities.Genre;


public interface GenreRepo extends JpaRepository<Genre, Integer> {

}