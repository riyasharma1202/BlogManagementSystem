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

        String blogName = rs.getString("blogName");
        String authID  = rs.getString("authID");
        int blogID = rs.getInt("blogID");
        return new Blog(blogName, authID, blogID);
    }
}
