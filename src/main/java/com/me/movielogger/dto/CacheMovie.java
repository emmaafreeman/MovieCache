package com.me.movielogger.dto;

import jakarta.persistence.*;
import org.hibernate.collection.spi.PersistentBag;

import java.util.List;

@Entity
@Table(name="movies")
public class CacheMovie {

    @Id
    private int id;
    private String title;
    private String year;
    private String genre;
    private String director;
    private String plot;
    @OneToMany()
    private List<CacheRating> ratings;

    public CacheMovie() {
    }

    public CacheMovie(int id, String title, String year, String genre, String director, String plot, List<CacheRating> ratings) {
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

    public List<CacheRating> getRatings() {
        return ratings;
    }

    public void setRatings(PersistentBag<CacheRating> ratings) {
        this.ratings = ratings;
    }

    public OMDBMovie toOMDBMovie() {
        return new OMDBMovie(this.id, this.title, this.year, this.genre, this.director, this.plot, this.ratings.stream().map(CacheRating::toOMDBRating).toList());
    }
}

@Entity
@Table(name="ratings")
class CacheRating {
    @Id
    private int id;

    @ManyToOne()
    @JoinColumn(name="movie_id", referencedColumnName="id", nullable=false)
    public CacheMovie cacheMovie;

    private String source;
    private String value;

    CacheRating() {
    }

    public CacheRating(int id, CacheMovie cacheMovie, String source, String value) {
        this.id = id;
        this.cacheMovie = cacheMovie;
        this.source = source;
        this.value = value;
    }

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

    public OMDBRating toOMDBRating() {
        return new OMDBRating(this.id, null, this.source, this.value);
    }
}
