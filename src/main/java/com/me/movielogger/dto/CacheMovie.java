package com.me.movielogger.dto;

import jakarta.persistence.*;

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

    public CacheMovie() { }

    public CacheMovie(int id, String title, String year, String genre, String director, String plot) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.plot = plot;
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

    public OMDBMovie toOMDBMovie() {
        return new OMDBMovie(this.id, this.title, this.year, this.genre, this.director, this.plot);
    }
}