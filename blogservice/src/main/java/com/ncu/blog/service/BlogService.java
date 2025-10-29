package com.ncu.blog.service;

import com.ncu.blog.dto.*;
import com.ncu.blog.service.exceptions.*;
import com.ncu.blog.irepository.IBlogRepository;
import com.ncu.blog.model.Blog;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {

    private final IBlogRepository blogRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    @Autowired
    public BlogService(IBlogRepository blogRepository, ModelMapper modelMapper, RestTemplate restTemplate) {
        this.blogRepository = blogRepository;
        this.modelMapper = modelMapper;
        this.restTemplate = restTemplate;
    }

    public List<BlogDto> getAllBlogs() {
        try {
            List<Blog> blogs = blogRepository.getAllBlogs();
            List<BlogDto> dtos = new ArrayList<>();
            for (Blog b : blogs) dtos.add(modelMapper.map(b, BlogDto.class));
            return dtos;
        } catch (Exception e) {
            throw new DatabaseException("Failed to fetch blogs: " + e.getMessage());
        }
    }

    public BlogDto getBlogById(int blogId) {
        if (blogId <= 0) throw new ValidationException("Invalid blog ID");
        Blog blog = blogRepository.getBlogById(blogId);
        if (blog == null) throw new BlogNotFoundException("Blog not found with ID: " + blogId);
        return modelMapper.map(blog, BlogDto.class);
    }

    public List<BlogDto> getBlogsByAuthorId(String authID) {
        if (authID == null || authID.isBlank()) throw new ValidationException("Author ID cannot be empty");
        try {
            List<Blog> blogs = blogRepository.getBlogsByAuthorId(authID);
            List<BlogDto> dtos = new ArrayList<>();
            for (Blog b : blogs) dtos.add(modelMapper.map(b, BlogDto.class));
            return dtos;
        } catch (Exception e) {
            throw new DatabaseException("Failed to fetch blogs by author: " + e.getMessage());
        }
    }

    public BlogDto addBlog(BlogDto blogDto) {
        if (blogDto == null || blogDto.get_BlogName() == null || blogDto.get_BlogName().isBlank()) {
            throw new ValidationException("Blog name is required");
        }
        try {
            Blog blog = modelMapper.map(blogDto, Blog.class);
            Blog saved = blogRepository.addBlog(blog);
            return modelMapper.map(saved, BlogDto.class);
        } catch (Exception e) {
            throw new DatabaseException("Failed to add blog: " + e.getMessage());
        }
    }

    public void deleteBlog(int blogId) {
        if (blogId <= 0) throw new ValidationException("Invalid blog ID");
        try {
            blogRepository.deleteBlog(blogId);
        } catch (Exception e) {
            throw new DatabaseException("Failed to delete blog: " + e.getMessage());
        }
    }

    public List<CommentDto> getCommentsForBlog(int blogID) {
        try {
            String url = "http://localhost:9003/comments/blog/" + blogID; // Comment service base; configserver/eureka can be used to look up
            ResponseEntity<CommentDto[]> resp = restTemplate.getForEntity(url, CommentDto[].class);
            if (resp.getStatusCode().is2xxSuccessful() && resp.getBody() != null) {
                CommentDto[] arr = resp.getBody();
                List<CommentDto> list = new ArrayList<>();
                for (CommentDto c : arr) list.add(c);
                return list;
            } else {
                return new ArrayList<>();
            }
        } catch (RestClientException ex) {
            throw new ExternalServiceException("Comment service unavailable: " + ex.getMessage());
        }
    }

    public BlogWithCommentsDto getBlogWithComments(int blogID) {
        BlogDto blog = getBlogById(blogID); // throws if not found
        List<CommentDto> comments = getCommentsForBlog(blogID);
        return new BlogWithCommentsDto(blog, comments);
    }
}
