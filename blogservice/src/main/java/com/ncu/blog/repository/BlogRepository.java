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

@Repository(value = "BlogRepository")
public class BlogRepository implements IBlogRepository {
     
    JdbcTemplate _JdbcTemplate ;
    
    @Autowired
    BlogRepository(JdbcTemplate jdbcTemplate){
        this._JdbcTemplate = jdbcTemplate;
    }


     @Override
     public List<Blog> getAllBlogs(){

        List<Blog> blogs;
        String sql = "select * from blogdb.blog";

        try {
            blogs = _JdbcTemplate.query(sql, new BlogRowMapper());
        } catch (Exception e) {
            System.out.println("Error fetching blogs : " + e.getMessage());
            return null;
        }
        return blogs;
     }


     @Override
public Blog getBlogById(int blogID) {
    String sql = "SELECT * FROM blogdb.blog WHERE id = ?";
    try {
        return _JdbcTemplate.queryForObject(sql, new BlogRowMapper(), blogID);
    } catch (EmptyResultDataAccessException e) {
        System.out.println("No blog found with ID: " + blogID);
        return null;
    } catch (Exception e) {
        System.out.println("Error fetching blog by ID: " + e.getMessage());
        return null;
    }
}

@Override
public List<Blog> getBlogsByAuthorId(String authID) {
    String sql = "SELECT * FROM blogdb.blog WHERE author_id = ?";
    try {
        return _JdbcTemplate.query(sql, new BlogRowMapper(), authID);
    } catch (Exception e) {
        System.out.println("Error fetching blogs by author ID: " + e.getMessage());
        return new ArrayList<>();
    }
}

@Override
public Blog addBlog(Blog blog) {
    String sql = "INSERT INTO blogdb.blog (title, content, author_id) VALUES (?, ?, ?)";
    try {
        int rowsAffected = _JdbcTemplate.update(sql, blog.get_BlogName(), blog.get_BlogId(), blog.get_AuthId());
        if (rowsAffected > 0) {
            // Optionally fetch the inserted blog (if you have auto-generated ID logic)
            return blog;
        }
    } catch (Exception e) {
        System.out.println("Error adding blog: " + e.getMessage());
    }
    return null;
}

@Override
public void deleteBlog(int blogID) {
    String sql = "DELETE FROM blogdb.blog WHERE id = ?";
    try {
        _JdbcTemplate.update(sql, blogID);
    } catch (Exception e) {
        System.out.println("Error deleting blog: " + e.getMessage());
    }
}
}




