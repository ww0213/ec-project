package com.example.ec;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.ec.mybatis.mapper")
public class EcApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcApplication.class, args);
    }
}
