package com.eren.emlakcepteservice.response;

import com.eren.emlakcepteservice.entity.enums.SearchType;

import java.util.List;

public class SearchResponse {

    private Integer id;
    private UserResponse userResponse;
    private SearchType type;
    private String searchWord;
    private List<RealtyResponse> searchedRealtyList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }

    public SearchType getType() {
        return type;
    }

    public void setType(SearchType type) {
        this.type = type;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public List<RealtyResponse> getSearchedRealtyList() {
        return searchedRealtyList;
    }

    public void setSearchedRealtyList(List<RealtyResponse> searchedRealtyList) {
        this.searchedRealtyList = searchedRealtyList;
    }
}
