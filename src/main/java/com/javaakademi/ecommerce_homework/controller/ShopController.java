package com.javaakademi.ecommerce_homework.controller;

import com.javaakademi.ecommerce_homework.entity.ProductCategory;
import com.javaakademi.ecommerce_homework.request.ProductCategoryRequest;
import com.javaakademi.ecommerce_homework.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @PostMapping("/{shopID}")
    public ProductCategory createAndAssingCategoryToShop(@RequestBody ProductCategoryRequest request, @PathVariable int shopID){
        return shopService.createAndAssignCategoryToShop(request,shopID);
    }
}
