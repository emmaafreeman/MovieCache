package com.me.movielogger.service;

import com.me.movielogger.dao.MovieCacheDao;
import com.me.movielogger.dao.OMDBDao;
import com.me.movielogger.dto.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieCacheService {
    @Autowired
    private OMDBDao omdbDao;

    @Autowired
    private MovieCacheDao movieCacheDao;

    public Movie findMovieByTitleThroughCache(String movieTitle) {
        return omdbDao.findMovieByTitle(movieTitle);
    }

    public Movie testDb(String movieTitle) {
        return movieCacheDao.findById(movieTitle).get();
    }

}