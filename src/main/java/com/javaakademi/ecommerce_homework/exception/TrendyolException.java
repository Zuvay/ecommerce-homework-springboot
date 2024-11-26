package com.javaakademi.ecommerce_homework.exception;

public class TrendyolException extends NullPointerException {
    public int code;
    public String message;

    public TrendyolException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
