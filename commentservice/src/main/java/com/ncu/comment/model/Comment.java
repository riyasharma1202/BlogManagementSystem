package com.ncu.comment.model;

public class Comment {
    private int commentID;
    private int blogID;
    private String commenterName;
    private String content;

    public Comment() {}

    public Comment(String commenterName, String content, int blogID, int commentID) {
        this.commenterName = commenterName;
        this.content = content;
        this.blogID = blogID;
        this.commentID = commentID;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getBlogID() {
        return blogID;
    }

    public void setBlogID(int blogID) {
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
}