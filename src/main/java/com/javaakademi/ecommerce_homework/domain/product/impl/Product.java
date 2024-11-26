package com.javaakademi.ecommerce_homework.domain.product.impl;

import com.javaakademi.ecommerce_homework.domain.productcategory.impl.ProductCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

}
