package com.example.ec.controller;

import com.example.ec.model.User;
import com.example.ec.model.Product;
import com.example.ec.model.Order;
import com.example.ec.service.OrderService;
import com.example.ec.repository.UserRepository;
import com.example.ec.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class JspController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderService orderService;

    @GetMapping("/jsp-demo")
    public String showJspDemo(Model model) {
        model.addAttribute("message", "這是來自 Controller 的訊息！");
        return "index";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> users = userRepository.findAll(); // 取得所有用戶
        model.addAttribute("users", users);
        return "users"; // 對應 WEB-INF/views/users.jsp
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "products"; // 對應 `products.jsp`
    }

    @GetMapping("/orders")
    public String getOrders(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            Model model) {

        List<Order> orders = orderService.getOrdersByPage(page, pageSize);
        model.addAttribute("orders", orders);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);

        return "orders"; // 對應到 `orders.jsp`
    }



}