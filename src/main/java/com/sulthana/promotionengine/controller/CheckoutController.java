package com.sulthana.promotionengine.controller;

import com.sulthana.promotionengine.model.CartEntry;
import com.sulthana.promotionengine.service.PromotionEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CheckoutController {

    @Autowired
    private PromotionEngineService promotionEngineService;

    @PostMapping("/checkout")
    public int checkout(@RequestBody List<CartEntry> cart) {
        return promotionEngineService.calculateTotal(cart);
    }
}