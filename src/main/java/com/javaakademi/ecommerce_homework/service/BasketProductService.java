package com.javaakademi.ecommerce_homework.service;

import com.javaakademi.ecommerce_homework.entity.Basket;
import com.javaakademi.ecommerce_homework.entity.BasketProduct;
import com.javaakademi.ecommerce_homework.entity.Product;
import com.javaakademi.ecommerce_homework.repository.BasketProductRepository;
import com.javaakademi.ecommerce_homework.repository.BasketRepository;
import com.javaakademi.ecommerce_homework.repository.ProductRepository;
import com.javaakademi.ecommerce_homework.response.BasketProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketProductService {

    @Autowired
    private BasketProductRepository basketProductRepository;
    @Autowired
    private ProductService productService;

    public BasketProduct createBasketProduct(int productID, Basket basket) {
        Product product = productService.findById(productID);

        // Öncelikle ürün sepette zaten var mı diye kontrol et
        BasketProduct existingBasketProduct = basketProductRepository.findByProductAndBasket(product, basket);

        if (existingBasketProduct != null) {
            // Ürün zaten sepette mevcut ürünü döndür
            return basketProductRepository.save(existingBasketProduct);
        } else {
            // Ürün yok yenisini oluştur
            return createNewBasketProduct(product, basket);
        }
    }

    public BasketProduct createNewBasketProduct(Product product, Basket basket) {
        BasketProduct newBasketProduct = new BasketProduct();
        newBasketProduct.setProduct(product);
        newBasketProduct.setBasket(basket);
        newBasketProduct.setTotalBasketProductCount(1);
        newBasketProduct.setBasketProductAmount(product.getPrice() * newBasketProduct.getTotalBasketProductCount());
        return basketProductRepository.save(newBasketProduct);
    }
}

