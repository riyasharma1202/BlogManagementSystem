package com.ncu.blog.irepository;

import java.util.List;
import com.ncu.blog.model.Blog;

public interface IBlogRepository {

    public List<Blog> getAllBlogs();
    Blog getBlogById(int blogID);
    List<Blog> getBlogsByAuthorId(String authID);

    Blog addBlog(Blog blog);

    void deleteBlog(int blogID);
    
}
