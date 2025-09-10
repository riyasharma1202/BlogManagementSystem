package com.ncu.blog.model;

public class Blog {
    
    String _BlogName;
    String _AuthId;     
    int _BlogId;

    public Blog()
    {

    }

    public Blog(String blogName, String authID, int blogID){
        this._BlogName = blogName;
        this._AuthId = authID;
        this._BlogId = blogID;
    }

    //setters and getter
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

    public int get_BlogId(){
        return _BlogId;
    }
    public void set_BlogId(int blogID){
        _BlogId = blogID;
    }


}
