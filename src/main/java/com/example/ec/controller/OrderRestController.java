package com.example.ec.controller;

import com.example.ec.dto.PricingResponse;
import com.example.ec.model.Order;
import com.example.ec.service.PricingStrategy.PricingService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("api/orders")
@CrossOrigin(origins = "*")
public class OrderRestController {

    private final PricingService pricingService;

    public OrderRestController(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @PostMapping("/pricing/calculate")
    public Map<String, Object> calculate(@RequestBody Order order) {
        BigDecimal price = pricingService.calculateOrderPrice(order);
        return Map.of(
                "finalPrice", price,
                "discountApplied", true
        );
    }
    //使用DTO
    @PostMapping("/pricing/dto/calculate")
    public PricingResponse calculate2(@RequestBody Order order) {
        BigDecimal price = pricingService.calculateOrderPrice(order);
        return new PricingResponse(price, true);
    }
}
