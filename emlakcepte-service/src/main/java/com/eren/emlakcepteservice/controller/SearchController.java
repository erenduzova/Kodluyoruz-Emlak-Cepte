package com.eren.emlakcepteservice.controller;

import com.eren.emlakcepteservice.request.SearchRequest;
import com.eren.emlakcepteservice.response.SearchResponse;
import com.eren.emlakcepteservice.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    private SearchService searchService;


    // Make a search
    @PostMapping
    public ResponseEntity<SearchResponse> search(@RequestBody SearchRequest searchRequest) {
        SearchResponse searchResponse = searchService.search(searchRequest);
        return new ResponseEntity<>(searchResponse, HttpStatus.OK);
    }

    // Get All Searches
    @GetMapping
    public ResponseEntity<List<SearchResponse>> getAll() {
        List<SearchResponse> searchList = searchService.getAll();
        return new ResponseEntity<>(searchList, HttpStatus.FOUND);
    }

}
