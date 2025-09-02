package com.ncu.blog.repository;

import com.ncu.blog.irepository.IBlogRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ncu.blog.model.Blog;

@Repository(value = "BlogRepositoryimpl")
public class BlogRepositoryimpl implements IBlogRepository {

    JdbcTemplate _JdbcTemplate;

    @Autowired
    BlogRepositoryimpl(JdbcTemplate jdbcTemplate) {
        this._JdbcTemplate = jdbcTemplate;
    }

    @Override
    public Blog addBlog(Blog blog) {
        try {
            String sql = "INSERT INTO blog (blog_name, author_id) VALUES (?, ?)";
            _JdbcTemplate.update(sql, blog.get_BlogName(), blog.get_AuthId());
            return blog;
        } catch (Exception e) {
            System.out.println("Error adding blog: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Blog getBlogById(int blogId) {
        String sql = "SELECT * FROM blog WHERE blog_id = ?";
        try {
            return _JdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Blog.class), blogId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

   @Override
   public List<Blog> getBlogsByAuthorId(String authorId) {
        String sql = "SELECT * FROM blog WHERE author_id = ?";
        List<Blog> blogs = _JdbcTemplate.query(
            sql,
            new Object[]{authorId},
            new BeanPropertyRowMapper<>(Blog.class)
        );
        return blogs.isEmpty() ? new ArrayList<>() : blogs;
    }


    // delete blog by blogId
    @Override
    public void deleteBlog(int blogId) {
        try {
            String sql = "DELETE FROM blog WHERE blog_id = ?";
            _JdbcTemplate.update(sql, blogId);
        } catch (Exception e) {
            System.out.println("Error deleting blog: " + e.getMessage());
        }
    }

    //  get blog name by blogId
    @Override
    public String getBlogNameById(int blogId) {
        String sql = "SELECT blog_name FROM blog WHERE blog_id = ?";
        try {
            return _JdbcTemplate.queryForObject(sql, String.class, blogId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    // count blogs by authorId
    @Override
    public long countBlogsByAuthorId(String authorId) {
        String sql = "SELECT COUNT(*) FROM blog WHERE author_id = ?";
        try {
            return _JdbcTemplate.queryForObject(sql, Long.class, authorId);
        } catch (Exception e) {
            System.out.println("Error counting blogs: " + e.getMessage());
            return 0;
        }
    }
}




