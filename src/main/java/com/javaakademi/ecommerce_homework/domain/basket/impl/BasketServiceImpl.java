package com.javaakademi.ecommerce_homework.domain.basket.impl;

import com.javaakademi.ecommerce_homework.domain.basket.api.BasketDto;
import com.javaakademi.ecommerce_homework.domain.basket.api.BasketService;
import com.javaakademi.ecommerce_homework.domain.basket.web.BasketRequest;
import com.javaakademi.ecommerce_homework.domain.basketproduct.api.BasketProductDto;
import com.javaakademi.ecommerce_homework.domain.product.impl.ProductServiceImpl;
import com.javaakademi.ecommerce_homework.domain.basketproduct.impl.BasketProductServiceImpl;
import com.javaakademi.ecommerce_homework.domain.basketproduct.impl.BasketProduct;
import com.javaakademi.ecommerce_homework.domain.product.impl.Product;
import com.javaakademi.ecommerce_homework.domain.user.impl.User;
import com.javaakademi.ecommerce_homework.domain.user.impl.UserServiceImpl;
import com.javaakademi.ecommerce_homework.exception.TrendyolException;
import com.javaakademi.ecommerce_homework.response.ErrorCodes;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    private BasketRepository repository;
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private BasketProductServiceImpl basketProductService;
    @Autowired
    private UserServiceImpl userService;

    private final int BASKET_STATUS_NONE = 0;
    private final int BASKET_STATUS_SALED = 1;
    private final int BASKET_STATUS_DELIVERED = 2;
    private final int BASKET_STATUS_CANCELED = 3;

    @Override
    public BasketDto saveBasket(BasketDto dto) {
        User user = UserServiceImpl.toEntity(userService.findById(dto.getUserId()));
        Basket basket = repository.findByUserAndStatus(user, BASKET_STATUS_NONE);
        if (basket == null) {
            basket = createNewBasket(user, dto);
        } else {
            basket.setBasketProducts(updateBasket(basket, dto));
            basket.setTotalBasketAmount(calcTotalBasketAmount(basket.getBasketProducts()));
        }
        basket = repository.save(basket);
        return toDto(basket);
    }

    @Override
    public List<BasketProductDto> getProducts() {
        return List.of();
    }

    @Override
    public double getTotalAmount() {
        return 0;
    }

    @Override
    public int findBasketStatusByBasketId(){
        return 0;
    }


    private List<BasketProduct> updateBasket(Basket basket, BasketDto dto) {
        for (BasketProductDto basketProductDto : dto.getBasketProducts()) {
            boolean isUpdated = false;
            for (BasketProduct basketProduct : basket.getBasketProducts()) {
                if (basketProduct.getProduct().getId() == basketProductDto.getProductId()) {
                    basketProduct.setTotalBasketProductCount(
                            basketProduct.getTotalBasketProductCount() + basketProductDto.getTotalBasketProductCount()
                    );
                    basketProduct.setBasketProductAmount(
                            basketProduct.getProduct().getPrice() * basketProduct.getTotalBasketProductCount()
                    );
                    isUpdated = true;
                    break;
                }
            }
            if (!isUpdated) {
                basket.getBasketProducts().add(createBasketProduct(basketProductDto));
            }
        }
        return basket.getBasketProducts();
    }

    public BasketProduct createBasketProduct(BasketProductDto basketProductDto) {
        Product product = productService.findById(basketProductDto.getProductId());
        return BasketProduct.builder()
                .product(product)
                .totalBasketProductCount(basketProductDto.getTotalBasketProductCount())
                .basketProductAmount(product.getPrice() * basketProductDto.getTotalBasketProductCount())
                .build();
    }

    public Basket createNewBasket(User user, BasketDto dto) {
        List<BasketProduct> basketProducts = dto.getBasketProducts().stream()
                .map(this::createBasketProduct)
                .collect(Collectors.toList());
        return Basket.builder()
                .user(user)
                .status(BASKET_STATUS_NONE)
                .basketProducts(basketProducts)
                .totalBasketAmount(calcTotalBasketAmount(basketProducts))
                .build();
    }

    private double calcTotalBasketAmount(List<BasketProduct> basketProducts) {
        return basketProducts.stream()
                .mapToDouble(BasketProduct::getBasketProductAmount)
                .sum();
    }

    public BasketDto toDto(Basket basket) {
        return BasketDto.builder()
                .id(basket.getId())
                .userId(basket.getUser().getId())
                .totalBasketAmount(basket.getTotalBasketAmount())
                .status(basket.getStatus())
                .basketProducts(basketProductService.toDtoList(basket.getBasketProducts()))
                .build();
    }
    public Basket findById(int id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }
//    public Basket toEntity(BasketDto dto) {
//        return Basket.builder()
//                .id(dto.getId())
//                .basketProducts(basketProductService.toEntityList(dto.getBasketProducts()))
//                .totalBasketAmount(dto.getTotalBasketAmount())
//                .status(dto.getStatus())
//                .user(UserServiceImpl.toEntity(dto.getUser()))
//                .build();
//    }
//
//    public static BasketDto toDto(Basket basket) {
//        return BasketDto.builder()
//                .id(basket.getId())
//                .basketProducts()
//                .totalBasketAmount(basket.getTotalBasketAmount())
//                .status(basket.getStatus())
//                .user(UserServiceImpl.toDto(basket.getUser()))
//                .build();
//    }
//
//    public static List<BasketDto> toDtoList(List<Basket> basketList) {
//        return basketList.stream()
//                .map(BasketServiceImpl::toDto)
//                .collect(Collectors.toList());
//    }

}
