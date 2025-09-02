package com.ncu.blog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlogDto {
    
    @JsonProperty("blogname")
    String _BlogName;

    @JsonProperty("authid")
    String _AuthId;

        BlogDto() 
    {

    }

    public BlogDto(String blogName, String authid) 
    {
        _BlogName = blogName;
        _AuthId = authid;
    }

    public String get_BlogName() 
    {
        return _BlogName;
    }

    public void set_BlogName(String blogname) 
    {
        _BlogName = blogname;
    }

    public String get_AuthId(){
        return _AuthId;
    }
    public void set_AuthId(String authid){
        _AuthId = authid;
    }
}
