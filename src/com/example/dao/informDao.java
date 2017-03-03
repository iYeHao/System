package com.example.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.demo.Information;

public class informDao extends baseDao {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<Information> show()throws Exception{
		
		ArrayList<Information> list = new ArrayList<Information>();
		String sql ="select * from inform";
		this.ConnetOrcl();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			Information inf =new Information();
			inf.setInformid(rs.getString(1));
			inf.setAuthor( rs.getString(2));
			inf.setDate(rs.getDate(3));
			inf.setTitle(rs.getString(4));
			int end =rs.getString(5).length();
			if(end>=30){
				end=30;
			}else
			{
			}
			inf.setText(rs.getString(5).substring(0,end));
			list.add(inf);
			
		}
		
		 return  list;
	}
	
	public  Information  addinform(String author,String title,String text, Date date) throws SQLException{
		 Information inf =new Information();
		int informid =(int)( Math.random()*1000);
	       String sql ="Insert into inform (informid,author,inf_date,title,text) values(?,?,?,?,?)";
	       this.ConnetOrcl();
	       PreparedStatement ps = this.conn.prepareStatement(sql);
	       	ps.setInt(1, informid);
			ps.setString(2, author);
			ps.setDate(3, date);
			ps.setString(4, title);
			ps.setString(5, text);
			ps.executeUpdate();
		return inf;
		
	}
	public void delete(String informid) throws SQLException{
		String sql="delete from inform where informid = ?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps=this.conn.prepareStatement(sql);
		ps.setObject(1, informid);
		ps.executeQuery();
	}
	public Information informcheck(String informid) throws SQLException{
		Information inf =new Information();
		String sql="select * from inform where informid =?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps=this.conn.prepareStatement(sql);
		ps.setObject(1, informid);
		java.sql.ResultSet rs =ps.executeQuery();
		while(rs.next()){
			inf.setDate(rs.getDate(3));
			inf.setAuthor(rs.getString(2));
			inf.setTitle(rs.getString(4));
			inf.setText(rs.getString(5));
		}
		return inf;
	}

}
