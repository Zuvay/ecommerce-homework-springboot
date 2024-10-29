package com.javaakademi.ecommerce_homework.service;

import com.javaakademi.ecommerce_homework.dto.BasketDto;
import com.javaakademi.ecommerce_homework.dto.UserDto;
import com.javaakademi.ecommerce_homework.entity.Basket;
import com.javaakademi.ecommerce_homework.entity.BasketProduct;
import com.javaakademi.ecommerce_homework.entity.User;
import com.javaakademi.ecommerce_homework.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketService {
    @Autowired
    private BasketRepository repository;
    @Autowired
    private BasketProductService basketProductService;
    @Autowired
    private UserService userService;

    private final int BASKET_STATUS_NONE = 0;
    private final int BASKET_STATUS_SALED = 1;
    private final int BASKET_STATUS_DELIVERED = 2;
    private final int BASKET_STATUS_CANCELED = 3;

    public BasketDto saveBasket(int productID, int userID) {
        User user = userService.findById(userID);

        Basket basket = repository.findByUserAndStatus(user, BASKET_STATUS_NONE);
        if (basket == null) {
            return basketNoneCreate(user, productID);
        } else {
            return basketExistUpdate(productID, basket);
        }
    }


    public List<BasketDto> findAll() {
        return toList(repository.findAll());
    }
    private BasketDto basketExistUpdate(int productID, Basket basket) {
        BasketProduct basketProduct = basketProductService.createBasketProduct(productID, basket);

        if (isBasketProductInBasket(basketProduct, basket)) {
            addAmountOfProductOneByOne(productID, basket.getId());
        } else {
            addProduct(basketProduct, basket); // Ürün sepette yoksa ürünü sepete ekle
        }
        Basket basket1 = repository.save(basket);
        return toDto(basket1);
    }

    private void addProduct(BasketProduct basketProduct, Basket basket) {
        List<BasketProduct> basketProductsList = basket.getBasketProducts();
        basketProduct.setBasket(basket);
        basketProductsList.add(basketProduct);
        basket.setBasketProducts(basketProductsList);
        repository.save(basket);
    }

    private boolean isBasketProductInBasket(BasketProduct basketProduct, Basket basket) {
        for (BasketProduct basketProduct1 : basket.getBasketProducts()) {
            if (basketProduct1.getProduct().getId() == basketProduct.getProduct().getId()) {
                return true;
            }
        }
        return false;
    }

    public BasketDto basketNoneCreate(User user, int productID) {
        return createAndAssignBasket(user);
    }

    private BasketDto createAndAssignBasket(User user) {
        Basket newBasket = new Basket();
        newBasket.setStatus(BASKET_STATUS_NONE);
        newBasket.setBasketProducts(new ArrayList<>());
        newBasket.setUser(user);
        newBasket = repository.save(newBasket);
        return toDto(newBasket);
    }
    public void addAmountOfProductOneByOne(int productID, int basketID) {
        Basket basket = repository.findById(basketID).orElseThrow();
        List<BasketProduct> products = basket.getBasketProducts();
        double totalAmount = 0;
        for (BasketProduct product : products) {
            if (product.getProduct().getId() == productID) {
                product.setTotalBasketProductCount(product.getTotalBasketProductCount() + 1);
                product.setBasketProductAmount(product.getProduct().getPrice() * product.getTotalBasketProductCount());
            }
            totalAmount = totalAmount + product.getBasketProductAmount();

        }
        basket.setTotalBasketAmount(totalAmount);
        repository.save(basket);
    }


    private List<BasketDto> toList(List<Basket> all) {
        List<BasketDto> dtos = new ArrayList<>();
        for (Basket basket : all) {
            dtos.add(toDto(basket));
        }
        return dtos;
    }
    private BasketDto toDto(Basket entity) {
        return BasketDto.builder()
                .id(entity.getId())
                .totalBasketAmount(entity.getTotalBasketAmount())
                .status(entity.getStatus())
                .basketProducts(basketProductService.toDtoList(entity.getBasketProducts()))
                .user(UserDto.builder().userId(entity.getUser().getId()).build())
                .build();

    }
}
