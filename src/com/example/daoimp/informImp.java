package com.example.daoimp;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.dao.informDao;
import com.example.demo.Information;

public class informImp {
public ArrayList<Information> show()throws Exception{
		
		
	ArrayList<Information> list = new ArrayList<Information>();	
	informDao dao = new informDao();
	try{
		list = dao.show();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		dao.Close();
	}
   return list ;
}
public Information addform(String author,String title, String text, Date date){
	Information inf = new Information();
	informDao dao = new informDao();
	try{
		inf= dao.addinform(author, title, text,date);
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		dao.Close();
	}
	return inf;
	}
public void delete(String informid){
	informDao dao = new informDao();
	try {
		dao.delete(informid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		dao.Close();
	}
}
public Information informcheck(String informid){
	Information inf=new Information();
	informDao dao =new informDao();
	try {
		inf=dao.informcheck(informid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		dao.Close();
	}
	return inf;
}
}






