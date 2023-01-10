package com.eren.emlakcepteservice.service;

import com.eren.emlakcepteservice.converter.PublicationRightConverter;
import com.eren.emlakcepteservice.converter.UserConverter;
import com.eren.emlakcepteservice.entity.PublicationRight;
import com.eren.emlakcepteservice.entity.Realty;
import com.eren.emlakcepteservice.entity.Search;
import com.eren.emlakcepteservice.entity.User;
import com.eren.emlakcepteservice.repository.PublicationRepository;
import com.eren.emlakcepteservice.repository.UserRepository;
import com.eren.emlakcepteservice.request.PublicationRightRequest;
import com.eren.emlakcepteservice.request.UserRequest;
import com.eren.emlakcepteservice.request.UserUpdateRequest;
import com.eren.emlakcepteservice.response.PublicationRightResponse;
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
    private PublicationRepository publicationRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private PublicationRightConverter publicationRightConverter;


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
        if (userUpdateRequest.getName() != null && userUpdateRequest.getName().length() > 0) {
            user.setName(userUpdateRequest.getName());
        }
        if (userUpdateRequest.getEmail() != null && userUpdateRequest.getEmail().length() > 0) {
            user.setEmail(userUpdateRequest.getEmail());
        }
        if (userUpdateRequest.getPassword() != null && userUpdateRequest.getPassword().length() > 0) {
            user.setPassword(userUpdateRequest.getPassword());
        }
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

    // Buy Publication Rights
    public UserResponse buyPublication(PublicationRightRequest publicationRightRequest) {
        User user = getById(publicationRightRequest.getUserId());
        // Payment will be added
        while (publicationRightRequest.getQuantity() > 0) {
            PublicationRight newPublicationRight = publicationRightConverter.convert(publicationRightRequest, user);
            publicationRepository.save(newPublicationRight);
            user.getPublicationRightList().add(newPublicationRight);
            publicationRightRequest.setQuantity(publicationRightRequest.getQuantity() - 1);
        }
        userRepository.save(user);
        return userConverter.convert(user);
    }

    // Get User's Publication Rights
    public List<PublicationRightResponse> getPublicationRights(Integer userId) {
        User user = getById(userId);
        List<PublicationRight> publicationRightList = user.getPublicationRightList();
        return publicationRightConverter.convert(publicationRightList);
    }
}
