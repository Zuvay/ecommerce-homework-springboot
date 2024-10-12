package com.javaakademi.ecommerce_homework.service;

import com.javaakademi.ecommerce_homework.entity.Basket;
import com.javaakademi.ecommerce_homework.entity.BasketProduct;
import com.javaakademi.ecommerce_homework.entity.User;
import com.javaakademi.ecommerce_homework.repository.BasketProductRepository;
import com.javaakademi.ecommerce_homework.repository.BasketRepository;
import com.javaakademi.ecommerce_homework.repository.UserRepository;
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
    private BasketProductService basketProductService;
    @Autowired
    private BasketProductRepository basketProductRepository;
    @Autowired
    private UserRepository userRepository;

    public BasketResponse addProductInBasket(int productID, int userID) {
        User user = userRepository.findById(userID).orElseThrow();
        Basket basket = basketRepository.findByUser(user);

        if (basket == null) {
            basket = createBasketForUser(userID);
        }
        return basketExistAddNewProduct(productID, basket);

    }

    private BasketResponse basketExistAddNewProduct(int productID, Basket basket) {
        BasketProduct basketProduct = basketProductService.createBasketProduct(productID);

        if (isBasketProductInBasket(basketProduct, basket)) {
            basketProduct.setBasketProductAmount(basketProduct.getBasketProductAmount()+1);
            basketProductRepository.save(basketProduct);
        } else {
            addProduct(basketProduct, basket); //ürün sepette yoksa ürünü sepete ekle
        }
        return toResponse(basketRepository.save(basket));
    }

    private void addProduct(BasketProduct basketProduct, Basket basket) {
        List<BasketProduct> basketProductsList = basket.getBasketProducts();
        if (basketProductsList == null) {
            basketProductsList = new ArrayList<>();
        }
        basketProduct.setBasket(basket);
        basketProductsList.add(basketProduct);
        basket.setBasketProducts(basketProductsList);
        basketProductRepository.save(basketProduct);
    }


    private boolean isBasketProductInBasket(BasketProduct basketProduct, Basket basket) {
        for (BasketProduct basketProduct1 : basket.getBasketProducts()) {
            if (basketProduct1.getProduct().getId() == basketProduct.getProduct().getId()) {
                return true;
            }
        }
        return false;
    }

    public Basket createBasketForUser(int userID) {
        User user = userRepository.findById(userID).orElseThrow();
        return createAndAssignBasket(user);
    }

    private Basket createAndAssignBasket(User user) {
        Basket newBasket = new Basket();
        newBasket.setStatus("Alışverişe devam ediyor");
        newBasket.setBasketProducts(new ArrayList<>());
        newBasket.setUser(user);
        basketRepository.save(newBasket);
        return newBasket;
    }

    private BasketResponse toResponse(Basket basket) {
        BasketResponse basketResponse = new BasketResponse();
        basketResponse.setStatus(basket.getStatus());
        basketResponse.setUser(basket.getUser().getUsername());

        List<BasketProduct> basketProducts = basket.getBasketProducts();
        double totalCountForBasket = countBasketProductsInBasket(basketProducts); // Ürünleri toplama fonksiyonu
        basketResponse.setTotalBasketCount(totalCountForBasket); // Sepetteki tüm ürünlerin toplamı

        return basketResponse;
    }

    private double countBasketProductsInBasket(List<BasketProduct> basketProducts) {
        double totalCountForBasket = 0;
        for (BasketProduct basketProduct : basketProducts) {
            totalCountForBasket += basketProduct.getBasketProductAmount();
        }
        return totalCountForBasket;
    }

    public List<BasketResponse> findAll() {
        List<Basket> baskets = basketRepository.findAll();
        List<BasketResponse> basketResponses = new ArrayList<>();
        for (Basket basket : baskets) {
            basketResponses.add(toResponse(basket));
        }
        return basketResponses;
    }

//    public void addAmountOfProductOneByOne(int productID, int basketID) {
//        Basket basket = basketRepository.findById(basketID).orElseThrow();
//        List<BasketProduct> products = basket.getBasketProducts();
//        for (BasketProduct product : products) {
//            if (product.getProduct().getId() == productID) {
//                product.setBasketProductAmount(product.getBasketProductAmount() + 1);
//            }
//        }
//        basketRepository.save(basket);
//    }
}
