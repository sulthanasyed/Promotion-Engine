package com.sulthana.promotionengine.model.promotion;

import com.sulthana.promotionengine.model.Product;

import java.util.Map;

public class BulkPromotion  implements Promotion {
    private final String sku;
    private final int quantityRequired;
    private final int promoPrice;

    public BulkPromotion(String sku, int quantityRequired, int promoPrice) {
        this.sku = sku;
        this.quantityRequired = quantityRequired;
        this.promoPrice = promoPrice;
    }

    @Override
    public int apply(Map<String, Integer> cart, Map<String, Product> catalog) {
        if (!cart.containsKey(sku)) return 0;

        int count = cart.get(sku);
        int unitPrice = catalog.get(sku).getUnitPrice();
        int bulkSets = count / quantityRequired;
        int remainder = count % quantityRequired;

        cart.put(sku, 0);
        return bulkSets * promoPrice + remainder * unitPrice;
    }
}
