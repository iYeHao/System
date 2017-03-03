package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.demo.Field;

public class filedDao extends baseDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<Field> show() throws SQLException{
		
		ArrayList<Field> flist= new ArrayList<Field>();
		String sql="select * from filed ";
		this.ConnetOrcl();
		PreparedStatement ps =this.conn.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
		while(rs.next()){
			Field filed =new Field();
			filed.setFid(rs.getInt(1));
			filed.setFname(rs.getString(4));
			int end =rs.getString(5).length();
			if(end>=30){
				end=30;
			}else
			{
			}
			filed.setFtext(rs.getString(5).substring(0,end));
			filed.setUserid(rs.getInt(3));
			filed.setFdate(rs.getDate(7));
			flist.add(filed);
		}
		return flist;
	}
	public Field filedcheck(int fid) throws SQLException{
		Field f = new Field();
		String sql="select * from filed where fid=?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps=this.conn.prepareStatement(sql);
		ps.setObject(1, fid);
		java.sql.ResultSet rs =ps.executeQuery();
		while(rs.next()){
			f.setFid(fid);
			f.setFdate(rs.getDate(7));
			f.setFatherid(rs.getInt(6));
			f.setPid(rs.getInt(2));
			f.setUserid(rs.getInt(3));
			f.setFname(rs.getString(4));
			f.setFtext(rs.getString(5));
		}
		String ssql="select * from users where userid = ?";
		java.sql.PreparedStatement pps =this.conn.prepareStatement(ssql);
		pps.setObject(1,f.getUserid());
		java.sql.ResultSet rrs =pps.executeQuery();
		while(rrs.next()){
			f.setAuthor(rrs.getString(3));
		}
		String sssql="select * from plan where pid = ?";
		java.sql.PreparedStatement ppps = this.conn.prepareStatement(sssql);
		ppps.setObject(1, f.getPid());
		java.sql.ResultSet rrrs = ppps.executeQuery();
		while(rrrs.next()){
			f.setPlanname(rrrs.getString(4));
		}
		return f;
	}
	public void deletefiled(int fid) throws SQLException{
		String sql="delete from filed where fid = ?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setObject(1, fid);
		ps.execute();
	}

}