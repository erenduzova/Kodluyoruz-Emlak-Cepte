package com.eren.emlakcepteservice.service;

import com.eren.emlakcepteservice.converter.SearchConverter;
import com.eren.emlakcepteservice.entity.Realty;
import com.eren.emlakcepteservice.entity.Search;
import com.eren.emlakcepteservice.entity.User;
import com.eren.emlakcepteservice.entity.enums.SearchType;
import com.eren.emlakcepteservice.repository.SearchRepository;
import com.eren.emlakcepteservice.request.SearchRequest;
import com.eren.emlakcepteservice.response.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RealtyService realtyService;

    @Autowired
    private SearchConverter searchConverter;

    // Create search
    public Search create(SearchRequest searchRequest) {
        User user = userService.getById(searchRequest.getUserId());
        Search search = searchConverter.convert(searchRequest, user);
        searchRepository.save(search);
        return search;
    }

    // Search realty
    public List<Realty> makeSearch(Search search) {
        SearchType searchType = search.getSearchType();
        String searchedWord = search.getSearchWord();

        if (searchType.equals(SearchType.PROVINCE)) {
            return realtyService.getAllByProvince(searchedWord);
        } else {
            return realtyService.getAllByDistrict(searchedWord);
        }

    }

    // Make a search
    public SearchResponse search(SearchRequest searchRequest) {
        Search newSearch = create(searchRequest);
        List<Realty> searchedRealty = makeSearch(newSearch);
        return searchConverter.convert(newSearch, searchedRealty);
    }

    // Get All Searches
    public List<SearchResponse> getAll() {
        return searchConverter.convert(searchRepository.findAll());
    }

    // Get User's Search History
    public List<SearchResponse> getUserSearchHistory(Integer userId) {
        return searchConverter.convert(userService.getUserSearchHistory(userId));
    }
}
