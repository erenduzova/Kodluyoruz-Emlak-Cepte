package com.eren.emlakcepteservice.converter;

import com.eren.emlakcepteservice.entity.User;
import com.eren.emlakcepteservice.request.UserRequest;
import com.eren.emlakcepteservice.response.UserResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class UserConverter {

    public UserResponse convert(User user) {
        UserResponse response = new UserResponse();
        response.setEmail(user.getEmail());
        response.setId(user.getId());
        response.setName(user.getName());
        response.setType(user.getType());
        response.setPublishLimit(user.getPublishLimit());
        return response;
    }

    public User convert(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        user.setType(userRequest.getType());
        user.setCreateDate(LocalDateTime.now());
        user.setPublishLimit(0);
        return user;
    }

    public List<UserResponse> convert(List<User> userList) {
        return userList.stream().map(this::convert).toList();
    }


}
