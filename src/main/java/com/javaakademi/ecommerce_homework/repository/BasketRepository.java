package com.javaakademi.ecommerce_homework.repository;

import com.javaakademi.ecommerce_homework.entity.Basket;
import com.javaakademi.ecommerce_homework.entity.User;
import com.javaakademi.ecommerce_homework.service.BasketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket,Integer> {

    Basket findByUser(User user);
    Basket findByUserAndBasketStatus(User user, BasketStatus status);

}
