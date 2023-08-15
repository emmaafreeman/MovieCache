package com.me.movielogger.service;

import com.me.movielogger.dao.MovieCacheDao;
import com.me.movielogger.dao.OMDBDao;
import com.me.movielogger.dto.OMDBMovie;
import com.me.movielogger.dto.CacheMovie;
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
        CacheMovie movieSearch = movieCacheDao.findByTitle(movieTitle);
        logger.info("Looking for " + movieTitle + " in db");

        if (movieSearch == null) {
            OMDBMovie newMovie = omdbDao.findNewMovieByTitle(movieTitle);
            movieCacheDao.save(newMovie.toCacheMovie());
            logger.info("Sending request to OMDB for: " + movieTitle);
            return newMovie.toCacheMovie();
        } else {
            return movieSearch;
        }
    }
}
