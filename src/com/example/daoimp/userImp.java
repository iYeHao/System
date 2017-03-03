package com.example.daoimp;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.dao.UserDao;
import com.example.demo.User;

public class userImp {
	
	public ArrayList<User> Show(){
		ArrayList<User>  ulist =new ArrayList<User> ();
		UserDao dao = new UserDao();
		try {
			ulist = dao.show();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		return ulist;
		
	}
	public User DetailShow(int userid){
		User user =new User();
		UserDao dao =new UserDao();
		try {
			user = dao.DetailShow(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		return user;
	}
	public void Delete(int userid){
		UserDao dao = new UserDao();
		try {
			dao.Delete(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
	}
}
