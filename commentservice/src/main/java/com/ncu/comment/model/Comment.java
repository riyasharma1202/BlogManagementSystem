package com.ncu.comment.model;

public class Comment {
    private int commentId;
    private String content;
    private String authId;
    private int blogId;

    // Getters and Setters
    public int getCommentId()
     { 
        return commentId; 
    }
    public void setCommentId(int commentId)
     { 
        this.commentId = commentId;
     }

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