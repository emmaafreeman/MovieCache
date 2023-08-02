package com.me.movielogger.dao;

import com.me.movielogger.dto.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface MovieCacheDao extends CrudRepository<Movie, String> {
}
