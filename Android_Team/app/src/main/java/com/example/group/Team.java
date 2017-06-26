package com.example.group;

public class Team{
	public String name;
	public String password;
	public String account;
	public int id;
	public Team(){
		name="";
		password="";
		id=-1;
	}
	public Team(int id,String name,String account,String password){
		this.name=name;
		this.password=password;
		this.id=id;
		this.account=account;
	}
}
