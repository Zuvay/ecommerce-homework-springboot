package com.javaakademi.ecommerce_homework.domain.basketproduct.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javaakademi.ecommerce_homework.domain.basket.impl.Basket;
import com.javaakademi.ecommerce_homework.domain.product.impl.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BasketProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double basketProductAmount; //total fiyat
    private int totalBasketProductCount; //ürün sayısı
    @OneToOne
    private Product product;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id")
    @JsonIgnore
    private Basket basket;
}