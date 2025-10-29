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

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BlogRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Blog> getAllBlogs() {
        String sql = "SELECT * FROM blogdb.blog";

        return jdbcTemplate.query(sql, new BlogRowMapper());
    }

    @Override
    public Blog getBlogById(int blogID) {
        String sql = "SELECT * FROM blogdb.blog WHERE blogID = ?";

        try {
            return jdbcTemplate.queryForObject(sql, new BlogRowMapper(), blogID);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Blog not found with ID: " + blogID);
        }
    }

    @Override
    public List<Blog> getBlogsByAuthorId(String authID) {
        String sql = "SELECT * FROM blogdb.blog WHERE authID = ?";
        return jdbcTemplate.query(sql, new BlogRowMapper(), authID);
    }

    @Override
    public Blog addBlog(Blog blog) {
        String sql = "INSERT INTO blogdb.blog (blogName, authID, blogID) VALUES (?, ?, ?)";

        int rowsAffected = jdbcTemplate.update(sql, blog.get_BlogName(), blog.get_AuthId(), blog.get_BlogId());

        if (rowsAffected > 0) {
            return blog;
        }
        throw new RuntimeException("Failed to insert Blog into database");
    }

    @Override
    public void deleteBlog(int blogID) {
        String sql = "DELETE FROM blogdb.blog WHERE blogID = ?";
        int rowsAffected = jdbcTemplate.update(sql, blogID);

        if (rowsAffected == 0) {
            throw new RuntimeException("No blog found to delete with ID: " + blogID);
        }
    }
}





