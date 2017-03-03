package com.example.daoimp;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.dao.filedDao;
import com.example.demo.Field;

public class filedImp {
	public ArrayList<Field> show(){
		ArrayList<Field> flist =new ArrayList<Field>();
		filedDao dao = new filedDao();
		
		try {
			flist=dao.show();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		return flist;
		
	}
	public Field filedcheck(int fid){
		Field f =new Field();
		filedDao dao =new filedDao();
		try {
			f=dao.filedcheck(fid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		return f;
	}
	public void deletefiled(int fid){
		filedDao dao =new filedDao();
		try {
			dao.deletefiled(fid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
	}
}
