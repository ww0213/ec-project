package com.example.ec.service.PricingStrategy;

import com.example.ec.model.Order;
import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal calculatePrice(Order order);
}