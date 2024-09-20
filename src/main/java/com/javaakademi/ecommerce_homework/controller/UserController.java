package com.javaakademi.ecommerce_homework.controller;

import com.javaakademi.ecommerce_homework.request.UserRequest;
import com.javaakademi.ecommerce_homework.response.UserResponse;
import com.javaakademi.ecommerce_homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest){
        userService.createUser(userRequest);
        return userService.toResponse(userRequest);
    }
}
