package com.javaakademi.ecommerce_homework.service;

import com.javaakademi.ecommerce_homework.entity.Basket;
import com.javaakademi.ecommerce_homework.entity.User;
import com.javaakademi.ecommerce_homework.repository.BasketRepository;
import com.javaakademi.ecommerce_homework.repository.UserRepository;
import com.javaakademi.ecommerce_homework.request.UserRequest;
import com.javaakademi.ecommerce_homework.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BasketRepository basketRepository;

    public UserResponse createUser(UserRequest userRequest) {
        User entity = toEntity(userRequest);

//        if (entity.getUserBasket() == null) {
//            createAndAssignBasket(entity);
//        }

        userRepository.save(entity);
        return toResponse(entity);
    }

    public void deleteUser(int userID) {
        userRepository.deleteById(userID);
    }

    public UserResponse updateUser(UserRequest request,int id){
        User updateUser =userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        updateUser.setUsername(request.getUsername());
        updateUser.setUserpassword(request.getUserpassword());
        updateUser.setUseremail(request.getUseremail());
        updateUser.setUserpassword(request.getUserpassword());
        updateUser.setUsermoney(request.getUsermoney());
        updateUser.setUseradress(request.getUseradress());
        userRepository.save(updateUser);
        return toResponse(updateUser);
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();

        for (User user : users) {
            userResponses.add(toResponse(user));
        }
        return userResponses;
    }

    public void createAndAssignBasket(User user) {
        Basket basket = new Basket();
        basketRepository.save(basket);
//        user.setUserBasket(basket);
    }

    public User toEntity(UserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setUsersurname(request.getUsersurname());
        user.setUseremail(request.getUseremail());
        user.setUserpassword(request.getUserpassword());
        user.setUseradress(request.getUseradress());
        user.setUsermoney(request.getUsermoney());
        return user;
    }

    public UserResponse toResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(user.getUsername());
        userResponse.setUsersurname(user.getUsersurname());
        userResponse.setUseremail(user.getUseremail());
        userResponse.setUseradress(user.getUseradress());
        userResponse.setUsermoney(user.getUsermoney());
        return userResponse;
    }
}
