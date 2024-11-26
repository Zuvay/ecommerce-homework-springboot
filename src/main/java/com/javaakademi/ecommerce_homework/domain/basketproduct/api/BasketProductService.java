package com.javaakademi.ecommerce_homework.domain.basketproduct.api;

import com.javaakademi.ecommerce_homework.domain.basket.impl.Basket;
import com.javaakademi.ecommerce_homework.domain.basketproduct.impl.BasketProduct;
import com.javaakademi.ecommerce_homework.domain.product.impl.Product;

public interface BasketProductService {
    BasketProductDto createBasketProduct(int productId, Basket basket);
    BasketProductDto createNewBasketProduct(Product product, Basket basket);

}
