package com.eren.emlakcepteservice.service;

import com.eren.emlakcepteservice.converter.UserConverter;
import com.eren.emlakcepteservice.entity.User;
import com.eren.emlakcepteservice.repository.UserRepository;
import com.eren.emlakcepteservice.request.UserRequest;
import com.eren.emlakcepteservice.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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




}
