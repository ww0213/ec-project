package com.example.ec.dto;

import java.math.BigDecimal;

public class PricingResponse {
    private BigDecimal finalPrice;
    private boolean discountApplied;

    public PricingResponse(BigDecimal finalPrice, boolean discountApplied) {
        this.finalPrice = finalPrice;
        this.discountApplied = discountApplied;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public boolean isDiscountApplied() {
        return discountApplied;
    }
}
