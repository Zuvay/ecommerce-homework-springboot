package com.javaakademi.ecommerce_homework.service;

import com.javaakademi.ecommerce_homework.entity.Basket;
import com.javaakademi.ecommerce_homework.entity.Product;
import com.javaakademi.ecommerce_homework.repository.BasketRepository;
import com.javaakademi.ecommerce_homework.repository.ProductRepository;
import com.javaakademi.ecommerce_homework.request.BasketRequest;
import com.javaakademi.ecommerce_homework.request.ProductRequest;
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
    private ProductRepository productRepository;

    public BasketResponse addProductInBasket(BasketRequest request, int userid) {
        Basket basket = basketRepository.findById(userid).orElseThrow(() -> new RuntimeException("Basket not found"));

        Product product = productRepository.findByName(request.getProductName());
        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        List<Product> products = basket.getProducts();

        // Sepette varsa miktarı arttır
        if (isProductAlreadyInBasket(products, product.getId())) {
            for (Product p : products) {
                if (p.getId() == product.getId()) {
                    p.setAmount(p.getAmount() + request.getAmount());
                    break;
                }
            }
        } else {
            // yoksa yeni ürün olarak ekle
            product.setAmount(request.getAmount());
            products.add(product);
        }

        basket.setProducts(products);
        basketRepository.save(basket);
        return toResponse(basket);
    }


    public boolean isProductAlreadyInBasket(List<Product> products,int productId){
        for(Product i:products){
            if(i.getId()==productId){
                return true;
            }
        }
        return false;
    }
    public List<BasketResponse> getAllProductsInBasket(){
        List<Basket> basketitems = basketRepository.findAll();
        List<BasketResponse> basketResponses = new ArrayList<>();

        for(Basket basket:basketitems){
            basketResponses.add(toResponse(basket));
        }
        return basketResponses;
    }
    public void deleteProductByIdFromBasket(int basketId, int productId) {
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(() -> new RuntimeException("Basket not found"));

        List<Product> productsInBasket = basket.getProducts();

        productsInBasket.removeIf(product -> product.getId() == productId);

        basketRepository.save(basket);
    }
    public BasketResponse doPaymentAndEmptyBasket(int id){
        Basket basket = basketRepository.findById(id).orElseThrow(()->new RuntimeException("Basket not found"));
        doPayment(); //Farazi olarak ödeme gerçekleşecek ve ilgili sepet boşaltılacak
        basket.setProducts(new ArrayList<>());
        basketRepository.save(basket);
        return toResponse(basket);
    }

    private void doPayment() {

    }

    public BasketResponse toResponse(Basket basket){
        BasketResponse response=new BasketResponse();
        List<Product> products = basket.getProducts();
        List<String> productNames = new ArrayList<>();
        for(Product product:products){
            productNames.add(product.getName()+" isimli ürün, "+product.getPrice()+" fiyatında ve "+product.getAmount()+" adedindedir.");
        }
        response.setProducts(productNames);
        return response;
    }

}
