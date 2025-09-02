package com.ncu.comment.irepository;

import com.ncu.comment.model.Comment;
import java.util.List;

public interface ICommentRepository {
    Comment addComment(Comment comment);
    Comment getCommentById(int commentId);
    List<Comment> getCommentsByBlogId(int blogId);
    List<Comment> getCommentsByAuthId(String authId);
    void deleteComment(int commentId);
    long countCommentsByBlogId(int blogId);
}

