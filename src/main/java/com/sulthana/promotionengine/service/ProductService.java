package com.sulthana.promotionengine.service;

import com.sulthana.promotionengine.model.Product;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductService {
    public Map<String, Product> getCatalog() {
        return Map.of(
                "A", new Product("A", 50),
                "B", new Product("B", 30),
                "C", new Product("C", 20),
                "D", new Product("D", 15)
        );
    }

}