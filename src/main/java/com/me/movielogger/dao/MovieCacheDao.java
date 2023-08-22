package com.me.movielogger.dao;

import com.me.movielogger.dto.CacheMovie;
import org.springframework.data.repository.CrudRepository;

public interface MovieCacheDao extends CrudRepository<CacheMovie, String> {
    CacheMovie findByTitle(String movieTitle);
}