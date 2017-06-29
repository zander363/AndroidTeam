package com.example.group;

public class Comment{
    public int order;
    public String name;
    public String context;
    public int id;
    public Comment(){
        this.order=0;
        this.name="";
        this.id=0;
        this.context="";
    }
    public Comment(int order,String name,int id,String context){
        this.order=order;
        this.name=name;
        this.id=id;
        this.context=context;
    }
}