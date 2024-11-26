package com.javaakademi.ecommerce_homework.domain.shop.web;


import com.javaakademi.ecommerce_homework.domain.shop.api.ShopDto;
import com.javaakademi.ecommerce_homework.domain.shop.api.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    private ShopService service;

    @PostMapping()
    public ShopResponse createShop(@RequestBody ShopRequest request) {
        ShopDto dto = service.createShop(toDto(request));
        return toResponse(dto);
    }


    public ShopResponse toResponse(ShopDto shop) {
        ShopResponse shopResponse = new ShopResponse();
        shopResponse.setShopName(shop.shopName);
        shopResponse.setId(shop.id);
        return shopResponse;
    }

    public ShopDto toDto(ShopRequest shop) {
        ShopDto dto = new ShopDto();
        dto.shopName = shop.getShopName();
        return dto;
    }
}
