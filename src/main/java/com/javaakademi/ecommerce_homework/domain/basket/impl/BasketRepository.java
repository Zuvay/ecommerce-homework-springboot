package com.javaakademi.ecommerce_homework.domain.basket.impl;

import com.javaakademi.ecommerce_homework.domain.user.impl.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket,Integer> {

    Basket findByUserAndStatus(User user, int status);

    List<Basket> id(int id);
}
