package com.sulthana.promotionengine.model.promotion;

import com.sulthana.promotionengine.model.Product;

import java.util.Map;

public interface Promotion {
    int apply(Map<String, Integer> cart, Map<String, Product> catalog);
}
