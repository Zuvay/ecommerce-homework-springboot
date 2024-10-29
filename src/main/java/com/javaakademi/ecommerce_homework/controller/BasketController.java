package com.javaakademi.ecommerce_homework.controller;


import com.javaakademi.ecommerce_homework.dto.BasketDto;
import com.javaakademi.ecommerce_homework.entity.Basket;
import com.javaakademi.ecommerce_homework.response.BasketResponse;
import com.javaakademi.ecommerce_homework.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/baskets")
public class BasketController {
    @Autowired
    private BasketService service;

    @GetMapping
    public List<BasketResponse> findAll() {
        return toList(service.findAll());
    }

    @PostMapping("/{productID}/{userID}")
    public BasketResponse saveBasket(@PathVariable int productID, @PathVariable int userID) {
        return toResponse(service.saveBasket(productID, userID));
    }

    public BasketResponse toResponse(BasketDto dto) {
        BasketResponse response = new BasketResponse();
        response.setUserId(String.valueOf(dto.getUser().getUserId()));
        response.setBasketProducts(dto.getBasketProducts());
        response.setStatus(dto.getStatus());
        response.setTotalBasketAmount(dto.getTotalBasketAmount());
        return response;
    }

    public List<BasketResponse> toList(List<BasketDto> dtos) {
        List<BasketResponse> responses = new ArrayList<>();
        for (BasketDto dto : dtos) {
            responses.add(toResponse(dto));
        }
        return responses;
    }
}
