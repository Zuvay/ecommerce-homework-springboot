package com.javaakademi.ecommerce_homework.domain.user.web;

import com.javaakademi.ecommerce_homework.domain.user.api.UserDto;
import com.javaakademi.ecommerce_homework.domain.user.api.UserService;
import com.javaakademi.ecommerce_homework.domain.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return toResponse(userService.createUser(toDto(userRequest)));
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return toResponseList(userService.getAllUsers());
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@RequestBody UserRequest request, @PathVariable int id) {
        return toResponse(userService.updateUser(toDto(request), id));
    }

    public static UserResponse toResponse(UserDto dto) {
        return UserResponse.builder()
                .usersurname(dto.getUsersurname())
                .username(dto.getUsername())
                .useradress(dto.getUseradress())
                .useremail(dto.getUseremail())
                .build();
    }
    public UserDto toDto(UserRequest userRequest) {
        return UserDto.builder()
                .username(userRequest.getUsername())
                .usersurname(userRequest.getUsersurname())
                .useradress(userRequest.getUseradress())
                .useremail(userRequest.getUseremail())
                .build();
    }

    public List<UserResponse> toResponseList(List<UserDto> dtoList) {
        return dtoList.stream()
                .map(UserController::toResponse)
                .collect(Collectors.toList());
    }
}
