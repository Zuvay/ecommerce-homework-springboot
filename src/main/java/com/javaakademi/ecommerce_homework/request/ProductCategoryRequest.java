package com.javaakademi.ecommerce_homework.request;

public class ProductCategoryRequest {
    private String productCategoryName;
    public ProductCategoryRequest(){}

    public ProductCategoryRequest(String categoryName) {
        this.productCategoryName = categoryName;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }
}
