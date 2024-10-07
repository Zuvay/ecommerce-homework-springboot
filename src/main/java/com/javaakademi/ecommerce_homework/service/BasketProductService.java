package com.javaakademi.ecommerce_homework.service;

import com.javaakademi.ecommerce_homework.entity.Basket;
import com.javaakademi.ecommerce_homework.entity.BasketProduct;
import com.javaakademi.ecommerce_homework.entity.Product;
import com.javaakademi.ecommerce_homework.repository.BasketProductRepository;
import com.javaakademi.ecommerce_homework.repository.BasketRepository;
import com.javaakademi.ecommerce_homework.repository.ProductRepository;
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

    public BasketProduct createBasketProductAndPutInBasket(int productID,int basketID){
        BasketProduct basketProduct = new BasketProduct();
        Product product = productRepository.findById(productID).orElseThrow();
        basketProduct.setProduct(product);
        basketProduct.setBasketProductAmount(1);
        basketProductRepository.save(basketProduct);

        putBasketProductInBasket(basketProduct,basketID);
        return basketProduct;
    }
    public void putBasketProductInBasket(BasketProduct basketProduct, int basketID){
        Basket basket = basketRepository.findById(basketID).orElseThrow();
        List<BasketProduct> basketProducts = basket.getBasketProducts();
        basketProducts.add(basketProduct);
        basket.setBasketProducts(basketProducts);
        basketRepository.save(basket);
    }

}
