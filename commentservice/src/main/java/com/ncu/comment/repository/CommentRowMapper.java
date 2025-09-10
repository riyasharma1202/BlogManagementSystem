package com.ncu.comment.repository;
import com.ncu.comment.*;
import com.ncu.comment.model.Comment;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CommentRowMapper implements RowMapper<Comment> {
    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        String commenterName = rs.getString("commenterName");
        String content = rs.getString("content");
        int blogID = rs.getInt("blogID");
        int commentID = rs.getInt("commentID");
        return new Comment(commenterName, content, blogID, commentID);
    }
}