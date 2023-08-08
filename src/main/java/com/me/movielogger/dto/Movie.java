package com.me.movielogger.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.collection.spi.PersistentBag;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.ArrayList;

@Entity
@Table(name="movies")
public class Movie {

    @JsonProperty("Id")
    @Id
    private int id;
    @JsonProperty("Title") private String title;
    @JsonProperty("Year") private String year;
    @JsonProperty("Genre") private String genre;
    @JsonProperty("Director") private String director;
    @JsonProperty("Plot") private String plot;
    @JsonProperty("Ratings")
    @OneToMany(mappedBy = "movie")
    private PersistentBag<Rating> ratings;

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

    public PersistentBag<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(PersistentBag<Rating> ratings) {
        this.ratings = ratings;
    }
}

@Entity
@Table(name="ratings")
class Rating {
    @JsonProperty("Id")
    @Id
    private int id;

    @JsonIgnore()
    @ManyToOne()
    @JoinColumn(name="movie_id", referencedColumnName="id", nullable=false)
    public Movie movie;

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
}
