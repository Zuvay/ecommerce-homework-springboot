package com.javaakademi.ecommerce_homework.domain.basketproduct.impl;

import com.javaakademi.ecommerce_homework.domain.basket.impl.Basket;
import com.javaakademi.ecommerce_homework.domain.product.impl.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketProductRepository extends JpaRepository<BasketProduct,Integer> {
    BasketProduct findByProductAndBasket(Product product, Basket basket);
    BasketProduct findBasketProductByProduct_Id(int id);
}
