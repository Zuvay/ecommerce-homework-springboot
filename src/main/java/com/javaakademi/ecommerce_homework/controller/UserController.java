package com.javaakademi.ecommerce_homework.controller;

import com.javaakademi.ecommerce_homework.request.UserRequest;
import com.javaakademi.ecommerce_homework.response.UserResponse;
import com.javaakademi.ecommerce_homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }
    @DeleteMapping("/{userID}")
    public void deleteUser(@PathVariable int userID){
        userService.deleteUser(userID);
    }
    @GetMapping
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }
    @PutMapping("/{id}")
    public UserResponse updateUser(@RequestBody UserRequest request,@PathVariable int id){
        return userService.updateUser(request,id);
    }
}
