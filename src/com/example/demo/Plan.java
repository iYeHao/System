package com.example.demo;

import java.sql.Date;

public class Plan {
private int pid;
private int userid;
private String ptype;
private String pname;
private Date pdate;
private String username;
public void setUsername(String uname){
	this.username =uname;
}
public String getUsername(){
	return username;
}
public void setPid(int pid){
	this.pid=pid;
}
public int getPid(){
	return pid;
}
public void setUserid(int userid){
	this.userid=userid;
}
public int getUserid(){
	return userid;
}
public void setPtype(String ptype){
	this.ptype=ptype;
}
public String getPtype(){
	return ptype;
}
public void setPname(String pname){
	this.pname=pname;
}
public String getPname(){
	return pname;
}
public void setPdate(Date pdate){
	this.pdate=pdate;
}
public Date getPdate(){
	return pdate;
}
}
