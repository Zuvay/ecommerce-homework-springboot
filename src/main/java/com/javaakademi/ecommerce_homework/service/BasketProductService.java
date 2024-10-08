package com.javaakademi.ecommerce_homework.service;

import com.javaakademi.ecommerce_homework.entity.Basket;
import com.javaakademi.ecommerce_homework.entity.BasketProduct;
import com.javaakademi.ecommerce_homework.entity.Product;
import com.javaakademi.ecommerce_homework.repository.BasketProductRepository;
import com.javaakademi.ecommerce_homework.repository.BasketRepository;
import com.javaakademi.ecommerce_homework.repository.ProductRepository;
import com.javaakademi.ecommerce_homework.response.BasketProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketProductService {
    @Autowired
    private BasketProductRepository basketProductRepository;
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private ProductRepository productRepository;

    public BasketProductResponse createBasketProduct(int productID){
        BasketProduct basketProduct = new BasketProduct();
        Product product = productRepository.findById(productID).orElseThrow();
        basketProduct.setProduct(product);
        basketProduct.setBasketProductAmount(1);
        basketProductRepository.save(basketProduct);
        return toResponse(basketProduct);
    }
    public BasketProductResponse toResponse(BasketProduct product){
        BasketProductResponse response = new BasketProductResponse();
        response.setBasketProductAmount(product.getBasketProductAmount());
        response.setProduct(product.getProduct().getName());
        response.setBasketID(response.getBasketID());
        return response;
    }

}
