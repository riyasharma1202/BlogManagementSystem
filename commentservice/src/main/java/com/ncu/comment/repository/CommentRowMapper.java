package com.ncu.comment.repository;

import com.ncu.comment.model.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentRowMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setCommentId(rs.getInt("comment_id"));
        comment.setContent(rs.getString("content"));
        comment.setAuthId(rs.getString("auth_id"));
        comment.setBlogId(rs.getInt("blog_id"));
        return comment;
    }
}