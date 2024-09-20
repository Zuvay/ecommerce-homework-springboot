package com.javaakademi.ecommerce_homework.repository;

import com.javaakademi.ecommerce_homework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
