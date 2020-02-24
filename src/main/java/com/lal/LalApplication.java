package com.lal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lal.mapper") //扫描的mapper
@SpringBootApplication()
public class LalApplication {

    public static void main(String[] args) {
        SpringApplication.run(LalApplication.class, args);
    }

}
