package com.oktenwebjavaadvanced.dao;

import com.oktenwebjavaadvanced.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<Movie, Integer> {

}
