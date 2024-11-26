package com.javaakademi.ecommerce_homework.domain.basketproduct.web;

import com.javaakademi.ecommerce_homework.domain.basketproduct.api.BasketProductService;
import com.javaakademi.ecommerce_homework.domain.basketproduct.impl.BasketProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basket-products")
public class BasketProductController {
    @Autowired
    private BasketProductService service;
}
