package com.ncu.blog.dto;

import java.util.List;

public class BlogWithCommentsDto {
    private BlogDto blog;
    private List<CommentDto> comments;

    public BlogWithCommentsDto() {}

    public BlogWithCommentsDto(BlogDto blog, List<CommentDto> comments) {
        this.blog = blog;
        this.comments = comments;
    }

    public BlogDto getBlog() {
        return blog;
    }

    public void setBlog(BlogDto blog) {
        this.blog = blog;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }
}