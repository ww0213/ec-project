package com.example.ec.service.PricingStrategy;

import com.example.ec.model.Order;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class PricingService {
    private final PricingStrategyFactory strategyFactory;

    public PricingService(PricingStrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    public BigDecimal calculateOrderPrice(Order order) {
        PricingStrategy strategy = strategyFactory.getStrategy(order.getType());
        return strategy.calculatePrice(order);
    }
}