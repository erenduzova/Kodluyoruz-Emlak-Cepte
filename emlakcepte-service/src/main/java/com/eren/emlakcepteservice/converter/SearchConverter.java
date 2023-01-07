package com.eren.emlakcepteservice.converter;

import com.eren.emlakcepteservice.entity.Realty;
import com.eren.emlakcepteservice.entity.Search;
import com.eren.emlakcepteservice.entity.User;
import com.eren.emlakcepteservice.request.SearchRequest;
import com.eren.emlakcepteservice.response.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class SearchConverter {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private RealtyConverter realtyConverter;


    public Search convert(SearchRequest searchRequest, User user) {
        Search newSearch = new Search();
        newSearch.setSearchType(searchRequest.getSearchType());
        newSearch.setSearchWord(searchRequest.getSearchWord());
        newSearch.setSearchDate(LocalDateTime.now());
        newSearch.setUser(user);
        return newSearch;
    }

    public SearchResponse convert(Search search, List<Realty> searchedRealtyList) {
        SearchResponse response = new SearchResponse();
        response.setId(search.getId());
        response.setType(search.getSearchType());
        response.setSearchWord(search.getSearchWord());
        response.setUserResponse(userConverter.convert(search.getUser()));
        response.setSearchedRealtyList(realtyConverter.convert(searchedRealtyList));
        return response;
    }

    public SearchResponse convert(Search search) {
        SearchResponse response = new SearchResponse();
        response.setId(search.getId());
        response.setType(search.getSearchType());
        response.setSearchWord(search.getSearchWord());
        response.setUserResponse(userConverter.convert(search.getUser()));
        // Set setSearchedRealtyList to empty List ( Don't need for search history )
        response.setSearchedRealtyList(List.of());
        return response;
    }


    public List<SearchResponse> convert(List<Search> searchList) {
        return searchList.stream().map(this::convert).toList();
    }
}
