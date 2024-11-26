package com.javaakademi.ecommerce_homework.domain.basket.web;


import com.javaakademi.ecommerce_homework.domain.basket.api.BasketDto;
import com.javaakademi.ecommerce_homework.domain.basket.api.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/baskets")
public class BasketController {
    @Autowired
    private BasketService service;

    @PostMapping()
    public BasketResponse saveBasket(@RequestBody BasketRequest request) {
        return toResponse(service.saveBasket(toDto(request)));
    }
    public BasketResponse toResponse(BasketDto basketDto) {
        return BasketResponse.builder()
                .basketProducts(basketDto.getBasketProducts())
                .totalBasketAmount(basketDto.getTotalBasketAmount())
                .status(basketDto.getStatus())
                .userId(basketDto.getId())
                .build();
    }
    //Yapılamadı
    public BasketDto toDto(BasketRequest basketRequest) {
        return BasketDto.builder()
                .id(basketRequest.basketId)
//                .basketProducts(service.getProducts())
//                .totalBasketAmount(service.getTotalAmount())
//                .status(service.findBasketStatusByBasketId())
                .userId(basketRequest.userId)
                .build();
    }
}
