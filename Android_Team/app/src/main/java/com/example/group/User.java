package com.example.group;

public class User{
	public String name;
	public String password;
	public String account;
	public int id;
	public User(){
		name="";
		password="";
		id=-1;
	}
	public User(int id,String name,String account,String password){
		this.name=name;
		this.password=password;
		this.id=id;
		this.account=account;
	}
}
