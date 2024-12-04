package com.javaakademi.ecommerce_homework.config;


import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;
import com.javaakademi.ecommerce_homework.domain.product.impl.Product;

import java.io.IOException;

public class ProductSerializer implements StreamSerializer<Product> {
    @Override
    public void write(ObjectDataOutput objectDataOutput, Product product) throws IOException {
        objectDataOutput.writeString(product.getName());
        objectDataOutput.writeDouble(product.getPrice());
        objectDataOutput.writeObject(product.getCategory());
        objectDataOutput.write(product.getId());
    }

    @Override
    public Product read(ObjectDataInput in) throws IOException {
        return Product.builder()
                .id(in.readInt())
                .name(in.readString())
                .price(in.readDouble())
                .category(in.readObject())
                .build();
    }

    @Override
    public int getTypeId() {
        return 1;
    }

    @Override
    public void destroy() {
        StreamSerializer.super.destroy();
    }


}
