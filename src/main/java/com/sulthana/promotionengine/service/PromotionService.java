package com.sulthana.promotionengine.service;

import com.sulthana.promotionengine.model.promotion.BulkPromotion;
import com.sulthana.promotionengine.model.promotion.ComboPromotion;
import com.sulthana.promotionengine.model.promotion.Promotion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {
    public List<Promotion> getActivePromotions() {
        return List.of(
                new BulkPromotion("A", 3, 130),
                new BulkPromotion("B", 2, 45),
                new ComboPromotion("C", "D", 30)
        );
    }
}