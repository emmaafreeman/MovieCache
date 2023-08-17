package com.me.movielogger.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.collection.spi.PersistentBag;

import java.util.List;

public class OMDBMovie {

    @JsonProperty("Id")
    private int id;
    @JsonProperty("Title") private String title;
    @JsonProperty("Year") private String year;
    @JsonProperty("Genre") private String genre;
    @JsonProperty("Director") private String director;
    @JsonProperty("Plot") private String plot;
    @JsonProperty("Ratings")
//    @JsonManagedReference
    private List<OMDBRating> ratings;

    public OMDBMovie() {
    }

    public OMDBMovie(int id, String title, String year, String genre, String director, String plot, List<OMDBRating> ratings) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.plot = plot;
        this.ratings = ratings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public List<OMDBRating> getRatings() {
        return ratings;
    }

    public void setRatings(List<OMDBRating> ratings) {
        this.ratings = ratings;
    }

    public CacheMovie toCacheMovie() {
        return new CacheMovie(this.id, this.title, this.year, this.genre, this.director, this.plot, this.ratings.stream().map(OMDBRating::toCacheRating).toList());
    }
}

class OMDBRating {
    @JsonProperty("Id")
//    @JsonBackReference
    private int id;

    //@JsonIgnore()
    public OMDBMovie omdbMovie;

    public OMDBRating() {
    }

    public OMDBRating(int id, OMDBMovie omdbMovie, String source, String value) {
        this.id = id;
        this.omdbMovie = omdbMovie;
        this.source = source;
        this.value = value;
    }

    @JsonProperty("Source") private String source;
    @JsonProperty("Value") private String value;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CacheRating toCacheRating() {
        return new CacheRating(this.id, null, this.source, this.value);
    }
}
