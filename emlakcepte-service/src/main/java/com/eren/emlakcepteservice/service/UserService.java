package com.eren.emlakcepteservice.service;

import com.eren.emlakcepteservice.converter.UserConverter;
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

    // Get UserResponse By Id
    public UserResponse getUserResponseById(Integer userId) {
        Optional<User> foundUser = getById(userId);
        return foundUser.map(user -> userConverter.convert(user))
                .orElseThrow(() -> {
                    // log -> not found
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with this id: " + userId);
                });
    }

    // Get User By Id
    public Optional<User> getById(Integer userId) {
        return userRepository.findById(userId);
    }
    // Get User By Email
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Get UserResponse By Email
    public UserResponse getUserResponseByEmail(String email) {
        Optional<User> foundUser = getByEmail(email);
        return foundUser.map(user -> userConverter.convert(user))
                .orElseThrow(() -> {
                    // log -> not found
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with this email: " + email);
                });
    }

    // Update and return updated UserResponse
    public UserResponse update(UserUpdateRequest userUpdateRequest, Integer userId) {
        Optional<User> foundUser = getById(userId);
        if (foundUser.isPresent()) {
            User updatedUser = updateUser(foundUser.get(), userUpdateRequest);
            return userConverter.convert(updatedUser);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with this id: " + userId);
        }

    }

    // Update User
    public User updateUser(User user, UserUpdateRequest userUpdateRequest) {
        user.setName(userUpdateRequest.getName());
        user.setEmail(userUpdateRequest.getEmail());
        user.setPassword(userUpdateRequest.getPassword());
        userRepository.save(user);
        return user;
    }



}
