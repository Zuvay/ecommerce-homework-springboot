package com.javaakademi.ecommerce_homework.repository;

import com.javaakademi.ecommerce_homework.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
