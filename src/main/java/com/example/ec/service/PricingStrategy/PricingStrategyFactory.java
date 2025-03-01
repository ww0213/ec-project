package com.example.ec.service.PricingStrategy;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class PricingStrategyFactory {
    private final Map<String, PricingStrategy> strategyMap;

    public PricingStrategyFactory(Map<String, PricingStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    //測試是否有注入
//    @PostConstruct
//    public void printStrategies() {
//        System.out.println("已注入的策略: " + strategyMap.keySet());
//    }

    public PricingStrategy getStrategy(String type) {
        return strategyMap.getOrDefault(type, strategyMap.get("standard"));  //預設標準計費
    }
}

