package com.example.demo;

import java.sql.Date;

public class Information {
	private  String   informid;
	private  String title;
	private  String text;
	private  String author;
	private  Date     date;
	
	public String getInformid(){
		return informid;
		
	}
	public void setInformid(String informid)
	{
		this.informid=informid;
	}
	public String getTitle(){
		return title;
		
	}
	public void setTitle(String string)
	{
		this.title=string;
	}
	public String getText(){
		return text;
		
	}
	public void setText(String text)
	{
		this.text=text;
	}
	public String getAuthor(){
		return author;
		
	}
	public void setAuthor(String author)
	{
		this.author=author;
	}
	public Date getDate(){
		return date;
		
	}
	public void setDate(Date date)
	{
		this.date=date;
	}
	

}
