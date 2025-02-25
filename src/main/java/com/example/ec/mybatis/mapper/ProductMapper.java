package com.example.ec.mybatis.mapper;

import com.example.ec.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> getProductsByPage(@Param("offset") int offset, @Param("pageSize") int pageSize);
}
