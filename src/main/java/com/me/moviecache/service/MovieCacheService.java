package com.me.moviecache.service;

import com.me.moviecache.dao.MovieCacheDao;
import com.me.moviecache.dao.OMDBDao;
import com.me.moviecache.dto.OMDBMovie;
import com.me.moviecache.dto.CacheMovie;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class MovieCacheService {
    @Autowired
    private OMDBDao omdbDao;

    @Autowired
    private MovieCacheDao movieCacheDao;

    private final Logger logger = getLogger(MovieCacheService.class);

    public CacheMovie findMovieByTitleThroughCache(String movieTitle) {
        logger.info("Looking for " + movieTitle + " in cache");
        CacheMovie movieSearch = movieCacheDao.findByTitle(movieTitle);

        if (movieSearch == null) {
            logger.info("Sending request to OMDB for: " + movieTitle);
            OMDBMovie newMovie = omdbDao.findNewMovieByTitle(movieTitle);
            logger.info("Saving " + movieTitle + " to cache");
            movieCacheDao.save(newMovie.toCacheMovie());
            return movieCacheDao.findByTitle(movieTitle);
        } else {
            return movieSearch;
        }
    }
}