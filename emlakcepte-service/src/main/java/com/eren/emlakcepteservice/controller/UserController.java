package com.eren.emlakcepteservice.controller;

import com.eren.emlakcepteservice.request.PublicationRightRequest;
import com.eren.emlakcepteservice.request.UserRequest;
import com.eren.emlakcepteservice.request.UserUpdateRequest;
import com.eren.emlakcepteservice.response.PublicationRightResponse;
import com.eren.emlakcepteservice.response.UserResponse;
import com.eren.emlakcepteservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create User
    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.createUser(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    // Get All Users
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        List<UserResponse> userResponseList = userService.getAll();
        return new ResponseEntity<>(userResponseList, HttpStatus.FOUND);
    }

    // Get User By Id
    @GetMapping(value = "/id/{userId}")
    public ResponseEntity<UserResponse> getById(@PathVariable Integer userId) {
        UserResponse userResponse = userService.getUserResponseById(userId);
        return new ResponseEntity<>(userResponse, HttpStatus.FOUND);
    }

    // Get User By Email
    @GetMapping(value = "/email/{email}")
    public ResponseEntity<UserResponse> getByEmail(@PathVariable String email) {
        UserResponse userResponse = userService.getUserResponseByEmail(email);
        return new ResponseEntity<>(userResponse, HttpStatus.FOUND);
    }

    // Update User
    @PutMapping(value = "/{userId}")
    public ResponseEntity<UserResponse> update(@RequestBody UserUpdateRequest userUpdateRequest, @PathVariable Integer userId) {
        UserResponse userResponse = userService.update(userUpdateRequest, userId);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    // Buy Publication Rights
    @PutMapping(value = "/publication")
    public ResponseEntity<UserResponse> buyPublication(@RequestBody PublicationRightRequest publicationRightRequest) {
        UserResponse userResponse = userService.buyPublication(publicationRightRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    // Get User's Publication Rights
    @GetMapping(value = "/{userId}/publication")
    public ResponseEntity<List<PublicationRightResponse>> getPublicationRights(@PathVariable Integer userId) {
        List<PublicationRightResponse> publicationRightResponseList = userService.getPublicationRights(userId);
        return new ResponseEntity<>(publicationRightResponseList, HttpStatus.OK);
    }

}
