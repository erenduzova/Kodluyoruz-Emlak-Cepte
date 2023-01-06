package com.eren.emlakcepteservice.service;

import com.eren.emlakcepteservice.converter.UserConverter;
import com.eren.emlakcepteservice.entity.User;
import com.eren.emlakcepteservice.repository.UserRepository;
import com.eren.emlakcepteservice.request.UserRequest;
import com.eren.emlakcepteservice.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    public UserResponse getUserResponseById(Integer userId) {
        Optional<User> foundUser = getById(userId);
        return foundUser.map(user -> userConverter.convert(user))
                .orElseThrow(() -> {
                    // log -> not found
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with this id: " + userId);
                });
    }

    public Optional<User> getById(Integer userId) {
        return userRepository.findById(userId);
    }
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public UserResponse getUserResponseByEmail(String email) {
        Optional<User> foundUser = getByEmail(email);
        return foundUser.map(user -> userConverter.convert(user))
                .orElseThrow(() -> {
                    // log -> not found
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with this email: " + email);
                });
    }
}
