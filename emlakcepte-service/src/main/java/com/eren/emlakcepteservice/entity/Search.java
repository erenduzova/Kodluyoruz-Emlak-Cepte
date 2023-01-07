package com.eren.emlakcepteservice.entity;

import com.eren.emlakcepteservice.entity.enums.SearchType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Search {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    @Column(name = "search_type")
    private SearchType searchType;
    @Column(name = "search_word")
    private String searchWord;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime searchDate;

    public Search() {
    }

    public Search(User user, SearchType searchType, String searchWord) {
        this.user = user;
        this.searchType = searchType;
        this.searchWord = searchWord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public LocalDateTime getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(LocalDateTime searchDate) {
        this.searchDate = searchDate;
    }

    @Override
    public String toString() {
        return "Search{" +
                "id=" + id +
                ", searchType=" + searchType +
                ", searchWord='" + searchWord + '\'' +
                ", searchDate=" + searchDate +
                '}';
    }
}
