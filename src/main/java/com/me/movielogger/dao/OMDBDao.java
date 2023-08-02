package com.me.movielogger.dao;

import com.me.movielogger.dto.Movie;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import static org.slf4j.LoggerFactory.getLogger;

@Repository
public class OMDBDao {

    @Autowired
    RestTemplate httpClient;
    private final UriTemplate movieDetailsUrl = new UriTemplate("http://www.omdbapi.com/?apikey=c899d711&t={title}");
    private final Logger logger = getLogger(OMDBDao.class);


    public Movie findMovieByTitle(String movieTitle) {
        RequestEntity<Void> request = RequestEntity.get(movieDetailsUrl.expand(movieTitle)).build();
        logger.info("Sending request to OMDB: " + request);
        ResponseEntity<Movie> response = httpClient.exchange(request, Movie.class);
        return response.getBody();
    }
}
