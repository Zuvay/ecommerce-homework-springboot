package com.javaakademi.ecommerce_homework.cacheconfig;

import com.javaakademi.ecommerce_homework.domain.product.impl.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/products")
public class CacheController {

    private final HazelcastConfig hazelCastConfig;

    @PostMapping(path = "/{rollNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product put(@RequestBody Product product, @PathVariable String rollNumber) {
        return hazelCastConfig.put(rollNumber, product);
    }

    @GetMapping(value = "/{rollNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product get(@PathVariable String rollNumber) {
        return hazelCastConfig.get(rollNumber);
    }
}
