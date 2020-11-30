package com.zx.zxtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zx.zxtest.mapper")
public class ZxtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZxtestApplication.class, args);
    }

}
