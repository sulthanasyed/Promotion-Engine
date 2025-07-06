package com.sulthana.promotionengine.model.promotion;

import com.sulthana.promotionengine.model.Product;

import java.util.Map;

public class ComboPromotion implements Promotion {
    private final String sku1;
    private final String sku2;
    private final int comboPrice;

    public ComboPromotion(String sku1, String sku2, int comboPrice) {
        this.sku1 = sku1;
        this.sku2 = sku2;
        this.comboPrice = comboPrice;
    }

    @Override
    public int apply(Map<String, Integer> cart, Map<String, Product> catalog){
        int count1 = cart.getOrDefault(sku1, 0);
        int count2 = cart.getOrDefault(sku2, 0);
        int comboSets = Math.min(count1, count2);

        cart.put(sku1, count1 - comboSets);
        cart.put(sku2, count2 - comboSets);

        return comboSets * comboPrice;
    }
}
