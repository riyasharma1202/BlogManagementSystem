package com.ncu.comment.repository;

import com.ncu.comment.irepository.ICommentRepository;
import com.ncu.comment.model.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CommentRepository implements ICommentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Comment> getCommentsByBlogId(int blogID) {
        String sql = "SELECT * FROM comment WHERE blogID = ?";
        return jdbcTemplate.query(sql, new CommentRowMapper(), blogID);
    }

    @Override
    public Comment addComment(Comment comment) {
        String sql = "INSERT INTO comment (commenterName, content, blogID) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, comment.getCommenterName(), comment.getContent(), comment.getBlogID());
        return comment;
    }

    @Override
    public void deleteComment(int commentID) {
        String sql = "DELETE FROM comment WHERE commentID = ?";
        jdbcTemplate.update(sql, commentID);
    }
}