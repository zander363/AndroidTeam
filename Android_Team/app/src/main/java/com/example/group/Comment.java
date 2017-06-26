package com.example.group;

public class Comment{
	public int order;
	public String name;
	public String context;
<<<<<<< HEAD
	public int id;
	public Comment(){
		this.order=0;
		this.name="";
		this.id=0;
=======
	public int group_id;
	public Comment(){
		this.order=0;
		this.name="";
		this.group_id=0;
>>>>>>> origin/master
		this.context="";
	}
	public Comment(int order,String name,int id,String context){
		this.order=order;
		this.name=name;
<<<<<<< HEAD
		this.id=id;
=======
		this.group_id=group_id;
>>>>>>> origin/master
		this.context=context;
	}
}
