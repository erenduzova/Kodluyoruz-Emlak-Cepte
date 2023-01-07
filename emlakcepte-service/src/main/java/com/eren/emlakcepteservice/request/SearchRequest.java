package com.eren.emlakcepteservice.request;

import com.eren.emlakcepteservice.entity.enums.SearchType;

public class SearchRequest {

    private Integer userId;
    private SearchType searchType;
    private String searchWord;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
