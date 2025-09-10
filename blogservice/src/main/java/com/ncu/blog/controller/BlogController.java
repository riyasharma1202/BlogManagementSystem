package com.ncu.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.modelmapper.ModelMapper;
import java.util.List;
import com.ncu.blog.dto.*;
import com.ncu.blog.model.Blog;
import com.ncu.blog.service.*;

@RequestMapping("/blogs")     // means this controller starts with courses
@RestController                 //this class acts as controller
public class BlogController 
{

    private final BlogService _BlogService;

    @Autowired
    public BlogController(BlogService blogService){
        this._BlogService = blogService;
    }
     /*
     * http://localhost:9002/blogs/allblogs
     */
    @GetMapping(path = "/allblogs")                    //retrieve data
    public List<BlogDto> getAllBlogs() 
    {
        return _BlogService.getAllBlogs();
    }

       // GET blog by ID
    @GetMapping("/{id}")
    public BlogDto getBlogById(@PathVariable("id") int blogID) {
        return _BlogService.getBlogById(blogID);
    }

    // GET blogs by author ID
    @GetMapping("/author/{authId}")
    public List<BlogDto> getBlogsByAuthorId(@PathVariable("authId") String authID) {
        return _BlogService.getBlogsByAuthorId(authID);
    }

    // POST a new blog
    @PostMapping("/")
    public BlogDto addBlog(@RequestBody BlogDto blogDto) {
        return _BlogService.addBlog(blogDto); // Service handles mapping
    }

    // DELETE a blog by ID
    @DeleteMapping("/{id}")
    public String deleteBlog(@PathVariable("id") int blogID) {
        _BlogService.deleteBlog(blogID);
        return "Blog deleted successfully.";
    }

    @GetMapping("/with-comments/{id}")
    public BlogWithCommentsDto getBlogWithComments(@PathVariable("id") int blogID) {
    return _BlogService.getBlogWithComments(blogID);
}

   

    

}
