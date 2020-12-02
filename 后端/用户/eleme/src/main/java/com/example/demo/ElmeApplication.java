package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication 来标注一个主程序，说明这是一个springboot应用
 */

@SpringBootApplication
public class ElmeApplication {

    public static void main(String[] args) {
        //spring应用启动
        SpringApplication.run(ElmeApplication.class, args);
    }

}
