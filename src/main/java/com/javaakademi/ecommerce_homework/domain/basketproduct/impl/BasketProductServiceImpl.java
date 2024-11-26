package com.javaakademi.ecommerce_homework.domain.basketproduct.impl;

import com.javaakademi.ecommerce_homework.domain.basket.api.BasketDto;
import com.javaakademi.ecommerce_homework.domain.basket.impl.Basket;
import com.javaakademi.ecommerce_homework.domain.basket.impl.BasketServiceImpl;
import com.javaakademi.ecommerce_homework.domain.basketproduct.api.BasketProductDto;
import com.javaakademi.ecommerce_homework.domain.basketproduct.api.BasketProductService;
import com.javaakademi.ecommerce_homework.domain.product.impl.Product;
import com.javaakademi.ecommerce_homework.domain.product.impl.ProductServiceImpl;
import com.javaakademi.ecommerce_homework.domain.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketProductServiceImpl implements BasketProductService {
    @Autowired
    private BasketProductRepository basketProductRepository;
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private BasketServiceImpl basketService;

    public BasketProduct findByProductId(int id) {
        return basketProductRepository.findBasketProductByProduct_Id(id);
    }

    public BasketProductDto createBasketProduct(int productID, Basket basket) {
        Product product = productService.findById(productID);

        // Öncelikle ürün sepette zaten var mı diye kontrol et
        BasketProduct existingBasketProduct = basketProductRepository.findByProductAndBasket(product, basket);

        if (existingBasketProduct != null) {
            // Ürün zaten sepette mevcut ürünü döndür
            return toDto(basketProductRepository.save(existingBasketProduct));
        } else {
            // Ürün yok yenisini oluştur
            return createNewBasketProduct(product, basket);
        }
    }

    public BasketProductDto createNewBasketProduct(Product product, Basket basket) {
        BasketProduct newBasketProduct = new BasketProduct();
        newBasketProduct.setProduct(product);
        newBasketProduct.setBasket(basket);
        newBasketProduct.setTotalBasketProductCount(1);
        newBasketProduct.setBasketProductAmount(product.getPrice() * newBasketProduct.getTotalBasketProductCount());
        return toDto(basketProductRepository.save(newBasketProduct));
    }
    public BasketProduct toEntity(BasketProductDto dto) {
        Basket basket = basketService.findById(dto.getBasketId());
        return BasketProduct.builder()
                .id(dto.getId())
                .basket(basket)
                .totalBasketProductCount(dto.getTotalBasketProductCount())
                .basketProductAmount(dto.getBasketProductAmount())
                .product(productService.findById(dto.getProductId()))
                .build();
    }

    public static BasketProductDto toDto(BasketProduct entity) {
        return BasketProductDto.builder()
                .basketId(entity.getBasket().getId())
                .basketProductAmount(entity.getBasketProductAmount())
                .totalBasketProductCount(entity.getTotalBasketProductCount())
                .id(entity.getId())
                .productId(entity.getProduct().getId())
                .build();
    }
    public List<BasketProductDto> toDtoList(List<BasketProduct> basketProducts) {
        return basketProducts.stream()
                .map(BasketProductServiceImpl::toDto)
                .collect(Collectors.toList());
    }
}

