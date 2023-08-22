package com.me.moviecache.dao;

import com.me.moviecache.dto.CacheMovie;
import org.springframework.data.repository.CrudRepository;

public interface MovieCacheDao extends CrudRepository<CacheMovie, String> {
    CacheMovie findByTitle(String movieTitle);
}