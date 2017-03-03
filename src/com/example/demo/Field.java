package com.example.demo;

import java.sql.Date;

public class Field {
	private int fid;
	private int pid;
	private int userid;
	private String fname;
	private String ftext;
	private int fatherid;
	private Date fdate;
	private String author;
	private String planname;
	public void setPlanname(String planname){
		this.planname=planname;
	}
	public String getPlanname(){
		return planname;
	}
	public void setAuthor(String author){
		this.author=author;
	}
	public String getAuthor(){
		return author;
	}
	public void setFid(int fid){
		this.fid=fid;
	}
	public int getFid(){
		return fid;
	}
	public void setPid(int pid)
	{
		this.pid=pid;
	}
	public int getPid(){
		return pid;
	}
	public void setUserid(int userid)
	{
		this.userid=userid;
	}
	public int getUserid(){
		return userid;
	}
	public void setFname(String fname)
	{
		this.fname=fname;
	}
	public String getFname()
	{
		return fname;
	}
	public void setFtext(String ftext)
	{
		this.ftext=ftext;
	}
	public String getFtext()
	{
		return ftext;
	}
	public void setFatherid(int fatherid)
	{
		this.fatherid=fatherid;
	}
	public int getFatherid(){
		return fatherid;
	}
	public void setFdate(Date fdate){
		this.fdate=fdate;
	}
	public Date getFdate()
	{
		return fdate;
	}

}
