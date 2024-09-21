package com.javaakademi.ecommerce_homework.response;

public class ProductCategoryResponse {
    private String productCategoryName;
    public ProductCategoryResponse(){}

    public ProductCategoryResponse(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }
}
