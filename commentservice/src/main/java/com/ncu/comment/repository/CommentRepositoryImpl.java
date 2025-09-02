package com.ncu.comment.repository;

import com.ncu.comment.irepository.ICommentRepository;
import com.ncu.comment.model.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("CommentRepositoryImpl")
public class CommentRepositoryImpl implements ICommentRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CommentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Comment addComment(Comment comment) {
        String sql = "INSERT INTO comment (content, auth_id, blog_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, comment.getContent(), comment.getAuthId(), comment.getBlogId());
        return comment;
    }

    @Override
    public Comment getCommentById(int commentId) {
        String sql = "SELECT * FROM comment WHERE comment_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Comment.class), commentId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Comment> getCommentsByBlogId(int blogId) {
        String sql = "SELECT * FROM comment WHERE blog_id = ?";
        List<Comment> comments = jdbcTemplate.query(sql, new Object[]{blogId}, new BeanPropertyRowMapper<>(Comment.class));
        return comments.isEmpty() ? new ArrayList<>() : comments;
    }

    @Override
    public List<Comment> getCommentsByAuthId(String authId) {
        String sql = "SELECT * FROM comment WHERE auth_id = ?";
        List<Comment> comments = jdbcTemplate.query(sql, new Object[]{authId}, new BeanPropertyRowMapper<>(Comment.class));
        return comments.isEmpty() ? new ArrayList<>() : comments;
    }

    @Override
    public void deleteComment(int commentId) {
        String sql = "DELETE FROM comment WHERE comment_id = ?";
        jdbcTemplate.update(sql, commentId);
    }

    @Override
    public long countCommentsByBlogId(int blogId) {
        String sql = "SELECT COUNT(*) FROM comment WHERE blog_id = ?";
        return jdbcTemplate.queryForObject(sql, Long.class, blogId);
    }
}