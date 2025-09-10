package com.ncu.comment.irepository;

import java.util.List;

import com.ncu.comment.model.Comment;

public interface ICommentRepository {

    List<Comment> getCommentsByBlogId(int blogID);

    Comment addComment(Comment comment);

    void deleteComment(int commentID);
}

