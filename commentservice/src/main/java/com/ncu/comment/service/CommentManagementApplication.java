package com.ncu.comment.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.ncu.comment")
public class CommentManagementApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(CommentManagementApplication.class, args);
    }
}
