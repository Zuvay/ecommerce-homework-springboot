package com.javaakademi.ecommerce_homework.domain.basket.impl;

import com.javaakademi.ecommerce_homework.domain.basketproduct.impl.BasketProduct;
import com.javaakademi.ecommerce_homework.domain.user.impl.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<BasketProduct> basketProducts;
    @OneToOne
    private User user;
    private double totalBasketAmount;
    private int status;

}
