package com.eren.emlakcepteservice.service;

import com.eren.emlakcepteservice.converter.UserConverter;
import com.eren.emlakcepteservice.entity.Realty;
import com.eren.emlakcepteservice.entity.Search;
import com.eren.emlakcepteservice.entity.User;
import com.eren.emlakcepteservice.repository.UserRepository;
import com.eren.emlakcepteservice.request.UserRequest;
import com.eren.emlakcepteservice.request.UserUpdateRequest;
import com.eren.emlakcepteservice.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;


    // Create User
    public UserResponse createUser(UserRequest userRequest) {

        User savedUser = userRepository.save(userConverter.convert(userRequest));
        return userConverter.convert(savedUser);
    }

    // Get All Users
    public List<UserResponse> getAll() {
        return userConverter.convert(userRepository.findAll());
    }

    // Get UserResponse By Id
    public UserResponse getUserResponseById(Integer userId) {
        User foundUser = getById(userId);
        return userConverter.convert(foundUser);
    }

    // Get User By Id
    public User getById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with this id: " + userId));
    }
    // Get User By Email
    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with this email: " + email));
    }

    // Get UserResponse By Email
    public UserResponse getUserResponseByEmail(String email) {
        User foundUser = getByEmail(email);
        return userConverter.convert(foundUser);
    }

    // Update and return updated UserResponse
    public UserResponse update(UserUpdateRequest userUpdateRequest, Integer userId) {
        User foundUser = getById(userId);
        User updatedUser = updateUser(foundUser, userUpdateRequest);
        return userConverter.convert(updatedUser);
    }

    // Update User
    public User updateUser(User user, UserUpdateRequest userUpdateRequest) {
        user.setName(userUpdateRequest.getName());
        user.setEmail(userUpdateRequest.getEmail());
        user.setPassword(userUpdateRequest.getPassword());
        userRepository.save(user);
        return user;
    }

    // Get User's Search History
    public List<Search> getUserSearchHistory(Integer userId) {
        return getById(userId).getSearchList();
    }

    // Get User's All Realty
    public List<Realty> getAllRealty(Integer userId) {
        User user = getById(userId);
        return user.getRealtyList();
    }

}
