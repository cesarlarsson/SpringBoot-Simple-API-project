package com.smartrabbit.movie_play.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "movies")
public class MovieEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150 , unique = true)
    private String title;

    @Column(nullable = false, precision = 3)
    private Integer duration;

    @Column(nullable = false, length = 40)
    private String genre;

    @Column(name = "start_Date")
    private LocalDate startDate;

    @Column( precision = 3,scale = 2)
    private BigDecimal classification;

    @Column(nullable = false, length = 1)
    private String state;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getClassification() {
        return classification;
    }

    public void setClassification(BigDecimal classification) {
        this.classification = classification;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
