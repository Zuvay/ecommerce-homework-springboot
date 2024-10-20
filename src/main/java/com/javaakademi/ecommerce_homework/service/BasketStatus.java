package com.javaakademi.ecommerce_homework.service;

public enum BasketStatus {
    NONE(0),
    SALED(1),
    DELIVERED(2),
    CANCELED(3);

    private final int statusCode;

    BasketStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

}

