package com.ncu.comment.dto;

public class CommentDto {
    private String content;
    private String authId;
    private int blogId;

    // Getters and Setters
    public String getContent() 
    { 
        return content; 
    }
    public void setContent(String content) 
    { 
        this.content = content; 
    }

    public String getAuthId() 
    { 
        return authId; 
    }
    public void setAuthId(String authId) 
    { 
        this.authId = authId; 
    }

    public int getBlogId() 
    { 
        return blogId; 
    }
    public void setBlogId(int blogId) 
    { 
        this.blogId = blogId; 
    }
}