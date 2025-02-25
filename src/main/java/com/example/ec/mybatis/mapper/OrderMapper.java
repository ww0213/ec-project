package com.example.ec.mybatis.mapper;

import com.example.ec.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface OrderMapper {
    List<Order> getOrdersByPage(@Param("offset") int offset, @Param("pageSize") int pageSize);
}
