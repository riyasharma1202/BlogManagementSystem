package com.ncu.blog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlogDto {
    
    @JsonProperty("blogName")
    String _BlogName;

    @JsonProperty("authID")
    String _AuthId;

    BlogDto() 
    {

    }

    public BlogDto(String blogName, String authID) 
    {
        _BlogName = blogName;
        _AuthId = authID;
    }

    public String get_BlogName() 
    {
        return _BlogName;
    }

    public void set_BlogName(String blogName) 
    {
        _BlogName = blogName;
    }

    public String get_AuthId(){
        return _AuthId;
    }
    public void set_AuthId(String authID){
        _AuthId = authID;
    }
}
