package com.javaakademi.ecommerce_homework.repository;

import com.javaakademi.ecommerce_homework.entity.BasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketProductRepository extends JpaRepository<BasketProduct,Integer> {
}
