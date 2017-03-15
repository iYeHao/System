package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
import com.example.demo.Administrator;

public class adminDao extends baseDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 管理员登录软件
	 */
	public Administrator login(String uname,String upassword) throws Exception{
		
		Administrator admin = null;
		
		String sql = "select * from admin where uname=? and uPASSWORD=?";
		this.ConnetOrcl();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1, uname);
		ps.setString(2, upassword);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			
			admin = new Administrator();
			admin.setUname(uname);
			admin.setUpassword(upassword);
			break;			
		}
		
		return admin;
		
	}
	/*
	 * 管理员注册
	 */
	public  Administrator register(String uname,String upassword) throws SQLException{
		Administrator user=null;
			String userid= UUID.randomUUID().toString();
	        String sql ="Insert into admin (userid,uname,upassword) values(?,?,?)";
	        this.ConnetOrcl();
	        PreparedStatement ps = this.conn.prepareStatement(sql);
	        ps.setObject(1, userid);
	        ps.setObject(2, uname);
	        ps.setObject(3, upassword);
	       	ps.setString(1, userid);
			ps.setString(2, uname);
			ps.setString(3, upassword);
			ps.executeUpdate();
			user=new  Administrator();
			
		return user;
	}
	/*
	 * 查询用户是否已经注册
	 */
	public boolean find(String uname) throws SQLException
	{
		boolean b=false;
		String sql="Select uname from admin where uname=?";
		this.ConnetOrcl();
		PreparedStatement ps =this.conn.prepareStatement(sql);
		ps.setString(1, uname);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			b=true;
		}
		return b;
	}
	/*
	 * 查看用户的详情
	 */
	public  Administrator MyAccount(String uname) throws SQLException
	{
		Administrator user=null;
		String sql="Select * from admin where uname=?";
		this.ConnetOrcl();
		PreparedStatement ps =this.conn.prepareStatement(sql);
		ps.setString(1, uname);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			user=new Administrator();
			user.setUname(uname);
		}
		return user;
	}
	/*
	 * 查看用户列表
	 */
	public ArrayList<String> ShowUser() throws SQLException
	{
		ArrayList<String> list = new ArrayList<String>();
		this.ConnetOrcl();
		String sql="Select * from admin ";
		PreparedStatement ps =this.conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
					list.add(rs.getString(2));
		}
		return list;
		
	}

}

