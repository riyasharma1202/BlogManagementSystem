package com.ncu.blog.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ncu.blog.model.Blog;

public class BlogRowMapper implements RowMapper<Blog>{
    
     @Override
    public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {

        if(rs == null)
        {
            return null;
        }

        String blogName = rs.getString("b_name");
        String authId  = rs.getString("authname");
        int blogId = rs.getInt("b_id");
        return new Blog(blogName, authId, blogId);
    }
}
