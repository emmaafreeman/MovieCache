package com.me.movielogger.dao;

import com.me.movielogger.dto.OMDBMovie;
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


    public OMDBMovie findNewMovieByTitle(String movieTitle) {
        RequestEntity<Void> request = RequestEntity.get(movieDetailsUrl.expand(movieTitle)).build();
        logger.info("Sending request to OMDB: " + request);
        ResponseEntity<OMDBMovie> response = httpClient.exchange(request, OMDBMovie.class);
        return response.getBody();
    }
}
