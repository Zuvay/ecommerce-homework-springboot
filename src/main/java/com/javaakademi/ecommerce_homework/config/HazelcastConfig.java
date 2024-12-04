package com.javaakademi.ecommerce_homework.config;


import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.javaakademi.ecommerce_homework.domain.product.impl.Product;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class HazelcastConfig {
    public static final String PRODUCTS = "products";
    private final HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(createConfig());

    public Config createConfig() {
        Config config = new Config();
        config.addMapConfig(mapConfig());
        config.getSerializationConfig().addSerializerConfig(serializerConfig());
        return config;
    }

    private MapConfig mapConfig() {
        MapConfig mapConfig = new MapConfig(PRODUCTS);
        mapConfig.setTimeToLiveSeconds(360);
        mapConfig.setMaxIdleSeconds(400);
        return mapConfig;
    }
    private SerializerConfig serializerConfig() {
        return new SerializerConfig().setImplementation(new ProductSerializer()).setTypeClass(Product.class);
    }
    public Product put(String number, Product product) {
        IMap<String, Product> map = hazelcastInstance.getMap(PRODUCTS);
        return map.putIfAbsent(number, product);
    }

    public Product get(String key) {
        IMap<String, Product> map = hazelcastInstance.getMap(PRODUCTS);
        return map.get(key);
    }
}
