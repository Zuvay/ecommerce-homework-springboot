package com.javaakademi.ecommerce_homework.controller;


import com.javaakademi.ecommerce_homework.request.ShopRequest;
import com.javaakademi.ecommerce_homework.response.ShopResponse;
import com.javaakademi.ecommerce_homework.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @PostMapping("/createshop")
    public ShopResponse createShop(@RequestBody ShopRequest request) {
        return shopService.createShop(request);
    }

}
