package com.javaakademi.ecommerce_homework.domain.productcategory.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javaakademi.ecommerce_homework.domain.product.impl.Product;
import com.javaakademi.ecommerce_homework.domain.shop.impl.Shop;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany
    @JsonIgnore
    private List<Product> products;
    @ManyToOne
    @JoinColumn(name = "shop_id")
    @JsonIgnore
    private Shop shop;
}
