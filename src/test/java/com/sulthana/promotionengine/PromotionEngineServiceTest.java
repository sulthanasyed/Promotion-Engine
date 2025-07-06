package com.sulthana.promotionengine;

import com.sulthana.promotionengine.model.*;
import com.sulthana.promotionengine.model.promotion.BulkPromotion;
import com.sulthana.promotionengine.model.promotion.ComboPromotion;
import com.sulthana.promotionengine.model.promotion.Promotion;
import com.sulthana.promotionengine.service.ProductService;
import com.sulthana.promotionengine.service.PromotionEngineService;
import com.sulthana.promotionengine.service.PromotionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PromotionEngineServiceTest {

    @Mock
    private ProductService productService;

    @Mock
    private PromotionService promotionService;

    private PromotionEngineService promotionEngineService;

    @BeforeEach
    void setUp() {
        Map<String, Product> catalog = Map.of(
                "A", new Product("A", 50),
                "B", new Product("B", 30),
                "C", new Product("C", 20),
                "D", new Product("D", 15)
        );

        Mockito.when(productService.getCatalog()).thenReturn(catalog);

        List<Promotion> promotions = List.of(
                new BulkPromotion("A", 3, 130),
                new BulkPromotion("B", 2, 45),
                new ComboPromotion("C", "D", 30)
        );

        Mockito.when(promotionService.getActivePromotions()).thenReturn(promotions);

        promotionEngineService = new PromotionEngineService(productService, promotionService);
    }

    private CartEntry entry(String sku, int quantity) {
        return new CartEntry(sku, quantity);
    }

    @Test
    void shouldApplyBulkPromotionOnA() {
        List<CartEntry> cart = List.of(entry("A", 3));
        int total = promotionEngineService.calculateTotal(cart);
        assertEquals(130, total);
    }

    @Test
    void shouldApplyBulkPromotionOnB() {
        List<CartEntry> cart = List.of(entry("B", 2));
        int total = promotionEngineService.calculateTotal(cart);
        assertEquals(45, total);
    }

    @Test
    void shouldApplyComboPromotionOnD() {
        List<CartEntry> cart = List.of(entry("C", 1), entry("D", 1));
        int total = promotionEngineService.calculateTotal(cart);
        assertEquals(30, total);
    }

    @Test
    void shouldApplyMixedPromotions() {
        List<CartEntry> cart = List.of(
                entry("A", 3),
                entry("B", 5),
                entry("C", 1),
                entry("D", 1)
        );
        int total = promotionEngineService.calculateTotal(cart);
        assertEquals(130 + 120 + 30, total);
    }

    @Test
    void shouldHandleNoApplicablePromotions() {
        List<CartEntry> cart = List.of(entry("A", 1), entry("B", 1));
        int total = promotionEngineService.calculateTotal(cart);
        assertEquals(50 + 30, total);
    }
}
