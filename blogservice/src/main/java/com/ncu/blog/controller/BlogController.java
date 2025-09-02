package com.ncu.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/blogs")     // means this controller starts with courses
@RestController                 //this class acts as controller
public class BlogController 
{

     /*
     * http://localhost:9002/blogs/
     */
    @GetMapping(path = "/")                    //retrieve data
    public String getAllBlogs() 
    {
        System.out.println("Hello from blog controller!");
        //_BlogService.getAllBlogs();
        return "Hello from blog controller!";
    }

     

}
