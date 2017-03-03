package com.example.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.demo.User;

public class UserDao extends baseDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<User> show() throws SQLException{
		ArrayList<User> ulist = new ArrayList<User> ();
		String sql="select * from users";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps =this.conn.prepareStatement(sql);
		java.sql.ResultSet rs = ps.executeQuery();
		while(rs.next()){
			User user=new User();
			user.setUserid(rs.getInt(1));
			user.setUpassword(rs.getString(4));
			user.setUname(rs.getString(3));
			user.setUemail(rs.getString(2));
			user.setUage(rs.getInt(5));
			user.setUlevel(rs.getInt(6));
			user.setUsex(rs.getString(7));
			ulist.add(user);
		}
		return ulist;
	}
	public User DetailShow(int userid) throws SQLException{
		User user =new User();
		String sql="select * from users where userid = ?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps =this.conn.prepareStatement(sql);
		ps.setObject(1, userid);
		java.sql.ResultSet rs =ps.executeQuery();
		while(rs.next()){
			
			user.setUserid(rs.getInt(1));
			user.setUpassword(rs.getString(4));
			user.setUname(rs.getString(3));
			user.setUemail(rs.getString(2));
			user.setUage(rs.getInt(5));
			user.setUlevel(rs.getInt(6));
			user.setUsex(rs.getString(7));
		}
		return user;
		
	}
	public void Delete(int userid) throws SQLException{
		String sql ="delete from plan where userid =?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setObject(1, userid);
		java.sql.ResultSet rs =ps.executeQuery();
		rs.deleteRow();
	}

}
