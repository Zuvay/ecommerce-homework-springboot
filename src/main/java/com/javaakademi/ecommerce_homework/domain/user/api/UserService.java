package com.javaakademi.ecommerce_homework.domain.user.api;


import java.util.List;

public interface UserService {
    void deleteUser(int userID);
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto dto,int id);
    List<UserDto> getAllUsers();
    UserDto findById(int id);
}
