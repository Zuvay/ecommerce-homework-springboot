package com.javaakademi.ecommerce_homework.dto;

import com.javaakademi.ecommerce_homework.entity.ProductCategory;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDto {

        private int id;
        private String name;
        private double price;
        private int categoryId;
}
