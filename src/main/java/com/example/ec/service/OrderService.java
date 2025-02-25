package com.example.ec.service;

import com.example.ec.mybatis.mapper.OrderMapper;
import com.example.ec.model.Order;
import com.example.ec.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;  // MyBatis 查詢

    @Autowired
    private OrderRepository orderRepository; // JPA 操作

    // 使用 MyBatis 分頁
    public List<Order> getOrdersByPage(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        return orderMapper.getOrdersByPage(offset, pageSize);
    }

    // 使用 JPA 查詢單筆訂單
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}