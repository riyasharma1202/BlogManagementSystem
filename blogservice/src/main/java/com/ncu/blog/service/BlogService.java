package com.ncu.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.core.ParameterizedTypeReference;

import java.util.ArrayList;
import java.util.List;

import com.ncu.blog.dto.*;
import com.ncu.blog.irepository.*;
import com.ncu.blog.model.Blog;

import org.modelmapper.ModelMapper;

@Service(value = "BlogService")
public class BlogService {

    private final IBlogRepository _BlogRepository;
    private final ModelMapper _ModelMapper;
    private final RestClient commentRestClient;

    @Autowired
    public BlogService(IBlogRepository blogRepository,
                       ModelMapper modelMapper,
                       RestClient commentRestClient) {
        this._BlogRepository = blogRepository;
        this._ModelMapper = modelMapper;
        this.commentRestClient = commentRestClient;
    }

    public List<BlogDto> getAllBlogs() {
        List<Blog> blogs = _BlogRepository.getAllBlogs();
        List<BlogDto> blogDtos = new ArrayList<>();
        for (Blog b : blogs) {
            BlogDto dto = _ModelMapper.map(b, BlogDto.class);
            blogDtos.add(dto);
        }
        return blogDtos;
    }

    public BlogDto getBlogById(int blogId) {
        Blog blog = _BlogRepository.getBlogById(blogId);
        if (blog == null) return null;
        return _ModelMapper.map(blog, BlogDto.class);
    }

    public List<BlogDto> getBlogsByAuthorId(String authID) {
        List<Blog> blogs = _BlogRepository.getBlogsByAuthorId(authID);
        List<BlogDto> blogDtos = new ArrayList<>();
        for (Blog b : blogs) {
            blogDtos.add(_ModelMapper.map(b, BlogDto.class));
        }
        return blogDtos;
    }

    public BlogDto addBlog(BlogDto blogDto) {
        Blog blog = _ModelMapper.map(blogDto, Blog.class);
        Blog savedBlog = _BlogRepository.addBlog(blog);
        return _ModelMapper.map(savedBlog, BlogDto.class);
    }

    public void deleteBlog(int blogId) {
        _BlogRepository.deleteBlog(blogId);
    }

    // Fetch comments from CommentService
    public List<CommentDto> getCommentsForBlog(int blogID) {
        return commentRestClient.get()
            .uri("/blog/{id}", blogID)
            .retrieve()
            .body(new ParameterizedTypeReference<List<CommentDto>>() {});
    }

    //Combine blog + comments
    public BlogWithCommentsDto getBlogWithComments(int blogID) {
        BlogDto blog = getBlogById(blogID);
        List<CommentDto> comments = getCommentsForBlog(blogID);
        return new BlogWithCommentsDto(blog, comments);
    }
}