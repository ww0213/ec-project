package com.example.ec.controller;

import com.example.ec.dto.PricingResponse;
import jakarta.validation.Valid;
import com.example.ec.model.Order;
import com.example.ec.service.OrderService;
import com.example.ec.service.PricingStrategy.PricingService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("api/orders")
@CrossOrigin(origins = "*")
public class OrderRestController {

    private final PricingService pricingService;

    private final OrderService orderService;

    public OrderRestController(PricingService pricingService, OrderService orderService) {
        this.pricingService = pricingService;
        this.orderService = orderService;
    }

    // JPA 新增訂單
    @PostMapping
    public Order addOrder(@Valid @RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    // JPA 更新訂單
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        order.setId(id);
        return orderService.saveOrder(order);
    }

    @PostMapping("/pricing/calculate")
    public Map<String, Object> calculate(@RequestBody Order order) {
        BigDecimal price = pricingService.calculateOrderPrice(order);
        return Map.of(
                "finalPrice", price
//                "discountApplied", true
        );
    }

    //使用DTO
    @PostMapping("/pricing/dto/calculate")
    public PricingResponse calculate2(@RequestBody Order order) {
        BigDecimal price = pricingService.calculateOrderPrice(order);
        return new PricingResponse(price, true);
    }




}
