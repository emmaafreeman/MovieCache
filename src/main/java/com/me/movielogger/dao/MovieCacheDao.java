package com.me.movielogger.dao;

import com.me.movielogger.dto.CacheMovie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface MovieCacheDao extends CrudRepository<CacheMovie, String> {

    CacheMovie findByTitle(String movieTitle);

//    Movie save(Movie newMovie);
}
