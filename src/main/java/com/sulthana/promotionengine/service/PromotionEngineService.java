package com.sulthana.promotionengine.service;

import com.sulthana.promotionengine.model.CartEntry;
import com.sulthana.promotionengine.model.Product;
import com.sulthana.promotionengine.model.promotion.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PromotionEngineService {

    private ProductService productService;

    private PromotionService promotionService;

    @Autowired
    public PromotionEngineService(ProductService productService, PromotionService promotionService) {
        this.productService = productService;
        this.promotionService = promotionService;
    }

    public int calculateTotal(List<CartEntry> cartEntries) {
        Map<String, Integer> cartMap = new HashMap<>();
        for (CartEntry entry : cartEntries) {
            cartMap.merge(entry.getProduct(), entry.getQuantity(), Integer::sum);
        }

        Map<String, Product> catalog = productService.getCatalog();
        List<Promotion> promotions = promotionService.getActivePromotions();

        int total = 0;
        for (Promotion promo : promotions) {
            total += promo.apply(cartMap, catalog);
        }

        // Calculating total of remaining items not covered by above promotions calculation
        for (Map.Entry<String, Integer> entry : cartMap.entrySet()) {
            String sku = entry.getKey();
            int qty = entry.getValue();
            if (qty > 0 && catalog.containsKey(sku)) {
                total += catalog.get(sku).getUnitPrice() * qty;
            }
        }

        return total;
    }
}
