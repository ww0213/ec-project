package com.example.ec.service;

import com.example.ec.mybatis.mapper.ProductMapper;
import com.example.ec.model.Product;
import com.example.ec.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper; // 用於 MyBatis 分頁查詢

    @Autowired
    private ProductRepository productRepository; // 用於 JPA CRUD 操作

    // MyBatis 進行分頁查詢
    public List<Product> getProductsByPage(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        return productMapper.getProductsByPage(offset, pageSize);
    }

    // JPA 根據 ID 查詢
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // JPA 新增/更新商品
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // JPA 刪除商品
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}