package com.javaakademi.ecommerce_homework.service;

import com.javaakademi.ecommerce_homework.entity.Basket;
import com.javaakademi.ecommerce_homework.entity.Product;
import com.javaakademi.ecommerce_homework.repository.BasketRepository;
import com.javaakademi.ecommerce_homework.repository.ProductRepository;
import com.javaakademi.ecommerce_homework.request.BasketRequest;
import com.javaakademi.ecommerce_homework.request.ProductRequest;
import com.javaakademi.ecommerce_homework.response.BasketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketService {
    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private ProductRepository productRepository;

    public BasketResponse addProductInBasket(BasketRequest request, int userid) {
        Basket basket = basketRepository.findById(userid).orElseThrow(() -> new RuntimeException("Basket not found"));

        Product product = productRepository.findByName(request.getProductName());

        List<Product> products = basket.getProducts();

        products.add(product);

        basket.setProducts(products);
        basketRepository.save(basket);
        return toResponse(basket);
    }
    public List<BasketResponse> getAllProductsInBasket(){
        List<Basket> basketitems = basketRepository.findAll();
        List<BasketResponse> basketResponses = new ArrayList<>();

        for(Basket basket:basketitems){
            basketResponses.add(toResponse(basket));
        }
        return basketResponses;
    }
    public BasketResponse toResponse(Basket basket){
        BasketResponse response=new BasketResponse();
        List<Product> products = basket.getProducts();
        List<String> productNames = new ArrayList<>();
        for(Product product:products){
            productNames.add(product.getName()+" isimli ürün, "+product.getPrice()+" fiyatında ve "+product.getAmount()+" adedindedir.");
        }
        response.setProducts(productNames);
        return response;
    }

}
