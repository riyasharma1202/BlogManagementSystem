package com.ncu.blog.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.ncu.blog")
public class BlogManagementApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(BlogManagementApplication.class, args);
    }
}
