package com.ncu.comment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/comments")     // means this controller starts with courses
@RestController                 //this class acts as controller
public class CommentController 
{

     /*
     * http://localhost:9003/comments/
     */
    @GetMapping(path = "/")                    //retrieve data
    public String getAllComments() 
    {
        System.out.println("Hello from comment controller!");
        //_CommentService.getAllComments();
        return "Hello from comment controller!";
    }

     

}