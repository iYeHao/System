package com.example.demo;

public class User {
	private int userid;
	private String uemail;
	private String uname;
	private String upassword;
	private int uage;
	private int ulevel;
	private String usex;
	public void setUserid(int userid){
		this.userid=userid;
	}
	public int getUserid(){
		return userid;
	}
	public void setUemail(String uemail){
		this.uemail=uemail;
	}
	public String getUemail(){
		return uemail;
	}
	public void setUname(String uname){
		this.uname=uname;
	}
	public String getUname(){
		return uname;
	}
	public void setUpassword(String upassword){
		this.upassword=upassword;
	}
	public String getUpassword(){
		return upassword;
	}
	public void setUage(int uage){
		this.uage=uage;
	}
	public int getUage(){
		return uage;
	}
	public void setUlevel(int ulevel){
		this.ulevel=ulevel;
	}
	public int getUlevel(){
		return ulevel;
	}
	public void setUsex(String usex){
		this.usex=usex;
	}
	public String getUsex(){
		return usex;
	}

}
