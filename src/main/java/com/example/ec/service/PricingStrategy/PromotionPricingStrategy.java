package com.example.ec.service.PricingStrategy;

import com.example.ec.model.Order;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component("promotion")
public class PromotionPricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal calculatePrice(Order order) {
        return order.getTotalPrice().multiply(new BigDecimal("0.80")); // 促銷8折
    }
}