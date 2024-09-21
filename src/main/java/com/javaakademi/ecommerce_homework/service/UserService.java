package com.javaakademi.ecommerce_homework.service;

import com.javaakademi.ecommerce_homework.entity.Basket;
import com.javaakademi.ecommerce_homework.entity.User;
import com.javaakademi.ecommerce_homework.repository.BasketRepository;
import com.javaakademi.ecommerce_homework.repository.UserRepository;
import com.javaakademi.ecommerce_homework.request.UserRequest;
import com.javaakademi.ecommerce_homework.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BasketRepository basketRepository;

    public UserResponse createUser(UserRequest userRequest) {
        User entity = toEntity(userRequest);

        createAndAssignBasket(entity);

        userRepository.save(entity);
        return toResponse(userRequest);
    }
    public void createAndAssignBasket(User user){
        Basket basket = new Basket();
        basketRepository.save(basket);
        user.setUserBasket(basket);
    }

    public User toEntity(UserRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setUsersurname(request.getUsersurname());
        user.setUseremail(request.getUseremail());
        user.setUserpassword(request.getUserpassword());
        return user;
    }

    public UserResponse toResponse(UserRequest userRequest){
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(userRequest.getUsername());
        userResponse.setUsersurname(userRequest.getUsersurname());
        userResponse.setUseremail(userRequest.getUseremail());
        return userResponse;
    }
}
