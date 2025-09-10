package com.ncu.comment.dto;

public class CommentDto {
    private String commenterName;
    private String content;
    private int blogID;

    public CommentDto() {}

    public CommentDto(String commenterName, String content, int blogID) {
        this.commenterName = commenterName;
        this.content = content;
        this.blogID = blogID;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBlogID() {
        return blogID;
    }

    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }
}