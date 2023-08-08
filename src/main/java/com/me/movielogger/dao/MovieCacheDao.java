package com.me.movielogger.dao;

import com.me.movielogger.dto.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface MovieCacheDao extends CrudRepository<Movie, String> {
//    @Query(value = "SELECT * FROM movies WHERE movies.title = ?1")
    Movie findByTitle(String movieTitle);
}
