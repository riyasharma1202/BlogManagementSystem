package com.ncu.blog.controller;

import com.ncu.blog.dto.ApiResponse;
import com.ncu.blog.dto.BlogDto;
import com.ncu.blog.dto.BlogWithCommentsDto;
import com.ncu.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/blogs")
@RestController
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) { this.blogService = blogService; }

    @GetMapping("/allblogs")
    public ResponseEntity<ApiResponse<List<BlogDto>>> getAllBlogs() {
        List<BlogDto> dtos = blogService.getAllBlogs();
        return ResponseEntity.ok(ApiResponse.success(dtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BlogDto>> getBlogById(@PathVariable int id) {
        BlogDto dto = blogService.getBlogById(id);
        return ResponseEntity.ok(ApiResponse.success(dto));
    }

    @GetMapping("/author/{authId}")
    public ResponseEntity<ApiResponse<List<BlogDto>>> getBlogsByAuthorId(@PathVariable String authId) {
        List<BlogDto> list = blogService.getBlogsByAuthorId(authId);
        return ResponseEntity.ok(ApiResponse.success(list));
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<BlogDto>> addBlog(@RequestBody BlogDto blogDto) {
        BlogDto saved = blogService.addBlog(blogDto);
        return ResponseEntity.ok(ApiResponse.success(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteBlog(@PathVariable int id) {
        blogService.deleteBlog(id);
        return ResponseEntity.ok(ApiResponse.success("Blog deleted successfully"));
    }

    @GetMapping("/with-comments/{id}")
    public ResponseEntity<ApiResponse<BlogWithCommentsDto>> getBlogWithComments(@PathVariable int id) {
        BlogWithCommentsDto combined = blogService.getBlogWithComments(id);
        return ResponseEntity.ok(ApiResponse.success(combined));
    }
}
