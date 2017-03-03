package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;

public class baseDao extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Connection conn;
	public void ConnetOrcl() {
		try {  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            conn = DriverManager  
                    .getConnection("jdbc:oracle:thin:@localhost:1521:orcl123", "Hang", "ting");   
        } catch (SQLException e) {  
            // TODO 自动生成 catch 块  
            e.printStackTrace();  
        } catch (ClassNotFoundException e) {  
            // TODO 自动生成 catch 块  
            e.printStackTrace();  
        }
	}
	public void Close(){
		try{
			if(conn!=null)
			{
				conn.close();
			}
		}catch (Exception e){
		e.printStackTrace();
		}
	}

}
