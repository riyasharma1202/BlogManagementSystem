package com.ncu.blog.model;

public class Blog {
    
    String _BlogName;
    String _AuthId;     
    int _BlogId;

    public Blog()
    {

    }

    public Blog(String blogName, String authId, int blogId){
        this._BlogName = blogName;
        this._AuthId = authId;
        this._BlogId = blogId;
    }

    //setters and getter
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

    public int get_BlogId(){
        return _BlogId;
    }
    public void set_BlogId(int blogId){
        _BlogId = blogId;
    }


}
