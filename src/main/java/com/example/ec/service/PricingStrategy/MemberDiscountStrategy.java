package com.example.ec.service.PricingStrategy;

import com.example.ec.model.Order;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component("member")
public class MemberDiscountStrategy implements PricingStrategy {
    @Override
    public BigDecimal calculatePrice(Order order) {
        return order.getTotalPrice().multiply(new BigDecimal("0.90")); // 會員9折
    }
}