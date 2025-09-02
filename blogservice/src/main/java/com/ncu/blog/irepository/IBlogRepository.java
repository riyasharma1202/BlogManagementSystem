package com.ncu.blog.irepository;

import java.util.List;
import com.ncu.blog.model.Blog;

public interface IBlogRepository {

    
    Blog addBlog(Blog blog);
    
    Blog getBlogById(int blogId);
    List<Blog> getBlogsByAuthorId(String authorId);

    void deleteBlog(int blogId);

    String getBlogNameById(int blogId);
    long countBlogsByAuthorId(String authorId);

    
}
