package com.example.daoimp;

import java.util.ArrayList;

import com.example.dao.adminDao;
import com.example.demo.Administrator;



public class adminImp {
public Administrator login(String uname,String upassword) throws Exception{
		
	Administrator user = null;
		
		adminDao dao = new adminDao();
		try {
			user = dao.login(uname, upassword);	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			dao.Close();			
		}		
		
		return user;
		
	}
public  Administrator register(String uname,String upassword) throws Exception{
	Administrator user=null;
	adminDao dao=new adminDao();
	try{
		user = dao.register(uname,upassword);
	}catch(Exception e){
		e.printStackTrace();
		throw e;
	}finally {
		dao.Close();
	}
	return user;
}
public  boolean find(String uname) throws Exception{
	boolean b=false;
	adminDao dao=new adminDao();
	try{
		b= dao.find(uname);
	}catch(Exception e){
		e.printStackTrace();
		throw e;
	}finally {
		dao.Close();
	}
	return b;
}
public  Administrator MyAccount(String uname) throws Exception{
	Administrator user= null;
	adminDao dao=new adminDao();
	try{
		user= dao.MyAccount(uname);
	}catch(Exception e){
		e.printStackTrace();
		throw e;
	}finally {
		dao.Close();
	}
	return user;
}
public  ArrayList<String> ShowUser() throws Exception{
	ArrayList<String> list = new ArrayList<String>();
	adminDao dao = new adminDao();
	try{
		list=dao.ShowUser();
	}catch(Exception e){
		e.printStackTrace();
		throw e;
	}finally{
		dao.Close();
	}
	return list;
	
	
}

}
