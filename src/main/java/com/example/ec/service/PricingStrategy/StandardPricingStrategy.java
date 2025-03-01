package com.example.ec.service.PricingStrategy;

import com.example.ec.model.Order;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component("standard")
public class StandardPricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal calculatePrice(Order order) {
        return order.getTotalPrice(); // 不打折，直接回傳價格
    }
}