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
    private UserService userService;

    private final int BASKET_STATUS_NONE = 0;
    private final int BASKET_STATUS_SALED = 1;
    private final int BASKET_STATUS_DELIVERED = 2;
    private final int BASKET_STATUS_CANCELED = 3;

    public BasketResponse addProductInBasket(int productID, int userID) {
        User user = userService.findById(userID);
        Basket basket = basketRepository.findByUserAndStatus(user, BASKET_STATUS_NONE);

        if (basket == null) {
            basket = createBasketForUser(user);
        }

        return basketExistAddNewProduct(productID, basket);
    }

    private BasketResponse basketExistAddNewProduct(int productID, Basket basket) {
        BasketProduct basketProduct = basketProductService.createBasketProduct(productID, basket);

        if (isBasketProductInBasket(basketProduct, basket)) {
            addAmountOfProductOneByOne(productID, basket.getId());
        } else {
            addProduct(basketProduct, basket); // Ürün sepette yoksa ürünü sepete ekle
        }
        return toResponse(basketRepository.save(basket));
    }

    private void addProduct(BasketProduct basketProduct, Basket basket) {
        List<BasketProduct> basketProductsList = basket.getBasketProducts();
        basketProduct.setBasket(basket);
        basketProductsList.add(basketProduct);
        basket.setBasketProducts(basketProductsList);
        basketRepository.save(basket);
    }

    private boolean isBasketProductInBasket(BasketProduct basketProduct, Basket basket) {
        for (BasketProduct basketProduct1 : basket.getBasketProducts()) {
            if (basketProduct1.getProduct().getId() == basketProduct.getProduct().getId()) {
                return true;
            }
        }
        return false;
    }

    public Basket createBasketForUser(User user) {
        return createAndAssignBasket(user);
    }

    private Basket createAndAssignBasket(User user) {
        Basket newBasket = new Basket();
        newBasket.setStatus(BASKET_STATUS_NONE);
        newBasket.setBasketProducts(new ArrayList<>());
        newBasket.setUser(user);
        basketRepository.save(newBasket);
        return newBasket;
    }

    private BasketResponse toResponse(Basket basket) {
        BasketResponse basketResponse = new BasketResponse();
        basketResponse.setStatus(basket.getStatus());
        basketResponse.setUser(basket.getUser().getUsername());
        basketResponse.setBasketProducts(basket.getBasketProducts());

        List<BasketProduct> basketProducts = basket.getBasketProducts();
        double totalCountForBasket = countBasketProductsInBasket(basketProducts); // Ürünleri sayma

        basket.setTotalBasketCount(totalCountForBasket);

        basketResponse.setTotalBasketAmount(countBasketAmountInBasket(basketProducts)); // Sepetteki tüm ürünlerin toplam fiyatı
        return basketResponse;
    }

    private double countBasketProductsInBasket(List<BasketProduct> basketProducts) {
        double totalCountForBasket = 0;
        for (BasketProduct basketProduct : basketProducts) {
            totalCountForBasket += basketProduct.getTotalBasketProductCount();
        }
        return totalCountForBasket;
    }

    private double countBasketAmountInBasket(List<BasketProduct> basketProducts) {
        double totalAmountForBasket = 0;
        for (BasketProduct basketProduct : basketProducts) {
            totalAmountForBasket += basketProduct.getProduct().getPrice() * basketProduct.getTotalBasketProductCount();
        }
        return totalAmountForBasket;
    }

    public void addAmountOfProductOneByOne(int productID, int basketID) {
        Basket basket = basketRepository.findById(basketID).orElseThrow();
        List<BasketProduct> products = basket.getBasketProducts();
        double totalAmount = 0;
        for (BasketProduct product : products) {
            if (product.getProduct().getId() == productID) {
                product.setTotalBasketProductCount(product.getTotalBasketProductCount() + 1);
                product.setBasketProductAmount(product.getProduct().getPrice() * product.getTotalBasketProductCount());
            }
            totalAmount = totalAmount + product.getBasketProductAmount();

        }
        basket.setTotalBasketCount(totalAmount);
        basketRepository.save(basket);
    }

    public List<BasketResponse> findAll() {
        List<Basket> baskets = basketRepository.findAll();
        List<BasketResponse> basketResponses = new ArrayList<>();
        for (Basket basket : baskets) {
            basketResponses.add(toResponse(basket));
        }
        return basketResponses;
    }
}
