package com.lnsf.DButils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DButil {

	
static public Connection getConnection()
	{
		Connection conn=null;
		try {
	 Class.forName("com.mysql.jdbc.Driver");
     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flowershop","root","y1234567");
	
		} 
		
		catch (ClassNotFoundException e) {
			 
			e.printStackTrace();
		}
	
			
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return conn;
	}

static public void closeConnection(ResultSet rs,PreparedStatement prep,Connection conn )
{
	
	try {
		if(rs!=null)
		rs.close();
		if(prep!=null)
			prep.close();
		if(conn!=null)
			conn.close();
		
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
}	
	

static public void closeConnection(PreparedStatement prep,Connection conn )
{
	
	try {
		if(prep!=null)
			prep.close();
		if(conn!=null)
			conn.close();
		
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
}

static public void closeConnection(ResultSet rs,Statement stmt,Connection conn )
{
	
	try {
		if(rs!=null)
		rs.close();
		if(stmt!=null)
			stmt.close();
		if(conn!=null)
			conn.close();
		
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
}

static public void closeConnection(Statement stmt,Connection conn )
{
	
	try {
		if(stmt!=null)
			stmt.close();
		if(conn!=null)
			conn.close();
		
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
}
	
}
