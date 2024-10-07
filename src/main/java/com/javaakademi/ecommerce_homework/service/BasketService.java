package com.javaakademi.ecommerce_homework.service;

import com.javaakademi.ecommerce_homework.entity.Basket;
import com.javaakademi.ecommerce_homework.entity.BasketProduct;
import com.javaakademi.ecommerce_homework.entity.Product;
import com.javaakademi.ecommerce_homework.entity.User;
import com.javaakademi.ecommerce_homework.repository.BasketRepository;
import com.javaakademi.ecommerce_homework.repository.ProductRepository;
import com.javaakademi.ecommerce_homework.repository.UserRepository;
import com.javaakademi.ecommerce_homework.response.BasketResponse;
import com.javaakademi.ecommerce_homework.response.ProductAmount;
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

    @Autowired
    private UserRepository userRepository;

    public BasketResponse createBasketForUser(int userID) {
        User user = userRepository.findById(userID).orElseThrow();
        Basket basket = createAndAssingBasket(user);
        basketRepository.save(basket);
        return toResponse(basket);
    }

    private BasketResponse toResponse(Basket basket) {
        BasketResponse basketResponse = new BasketResponse();
        basketResponse.setUser(basket.getUser().getUsername());
        basketResponse.setStatus(basket.getStatus());

        List<BasketProduct> basketProducts = basket.getBasketProducts();
        List<ProductAmount> responseProducts = new ArrayList<>();

        for (BasketProduct product : basketProducts) {
            String productName = product.getProduct().getName();
            int productAmount = product.getBasketProductAmount();


            ProductAmount productAmountObj = new ProductAmount(productName, productAmount);

            responseProducts.add(productAmountObj);
        }

        basketResponse.setProducts(responseProducts);

        return basketResponse;
    }


    private Basket createAndAssingBasket(User user) {
        Basket newBasket = new Basket();
        newBasket.setStatus("Alışverişe devam ediyor");
        newBasket.setUser(user);
        newBasket.setBasketProducts(new ArrayList<>());
        return newBasket;
    }

    public List<BasketResponse> findAll() {
        List<Basket> baskets= basketRepository.findAll();
        List<BasketResponse> basketResponses= new ArrayList<>();
        for(Basket basket:baskets){
            basketResponses.add(toResponse(basket));
        }
        return basketResponses;
    }

    public Basket addAmountOfProductOneByOne(int productID, int basketID) {
        Basket basket = basketRepository.findById(basketID).orElseThrow();
        List<BasketProduct> products= basket.getBasketProducts();
        for(BasketProduct product:products){
            if(product.getId()==productID){
                product.setBasketProductAmount(product.getBasketProductAmount()+1);
            }
        }
        return basketRepository.save(basket);
    }
}
