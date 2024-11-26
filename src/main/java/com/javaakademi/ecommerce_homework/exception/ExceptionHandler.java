package com.javaakademi.ecommerce_homework.exception;

import com.javaakademi.ecommerce_homework.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(TrendyolException.class)
    public ResponseEntity<Object> handleException(TrendyolException exception) {
        BaseResponse response = new BaseResponse();
        response.code = exception.code;
        response.message = exception.message;
        ResponseEntity<Object> entity = new ResponseEntity<>(response, org.springframework.http.HttpStatus.OK);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleException2(NullPointerException exception) {

        BaseResponse response = new BaseResponse();
        response.code = 4000;
        response.message = exception.getMessage();
        ResponseEntity<Object> entity = new ResponseEntity<>(response, org.springframework.http.HttpStatus.OK);

        return entity;
    }
}
