package com.javaakademi.ecommerce_homework.repository;

import com.javaakademi.ecommerce_homework.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket,Integer> {

}
