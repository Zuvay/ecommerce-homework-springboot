package com.javaakademi.ecommerce_homework.domain.user.impl;

import com.javaakademi.ecommerce_homework.exception.TrendyolException;
import com.javaakademi.ecommerce_homework.response.ErrorCodes;
import com.javaakademi.ecommerce_homework.domain.user.api.UserDto;
import com.javaakademi.ecommerce_homework.domain.user.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDto createUser(UserDto userDto) {
        User entity = toEntity(userDto);
        userRepository.save(entity);
        return toDto(entity);
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    public UserDto updateUser(UserDto dto,int id){
        User updateUser =userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        updateUser.setUsername(dto.getUsername());
        updateUser.setUserpassword(dto.getUserpassword());
        updateUser.setUseremail(dto.getUseremail());
        updateUser.setUserpassword(dto.getUserpassword());
        updateUser.setUseradress(dto.getUseradress());
        userRepository.save(updateUser);
        return toDto(updateUser);
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return toDtoList(users);
    }
    public UserDto findById(int id){
        return toDto(userRepository.findById(id).orElseThrow(() ->  new TrendyolException(ErrorCodes.ENTITY_NOT_FOUND,"User bulunamadi")));
    }
    public static User toEntity(UserDto dto){
        return User.builder()
                .id(dto.getId())
                .useradress(dto.getUseradress())
                .useremail(dto.getUseremail())
                .usersurname(dto.getUsersurname())
                .userpassword(dto.getUserpassword())
                .username(dto.getUsername())
                .build();
    }
    public static UserDto toDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .useradress(user.getUseradress())
                .useremail(user.getUseremail())
                .usersurname(user.getUsersurname())
                .userpassword(user.getUserpassword())
                .build();
    }
    public static List<UserDto> toDtoList(List<User> userList) {
        return userList.stream()
                .map(UserServiceImpl::toDto)
                .collect(Collectors.toList());
    }
}
