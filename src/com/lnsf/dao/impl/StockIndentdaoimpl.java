package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lnsf.DButils.DButil;
import com.lnsf.dao.IStockIndentdao;
import com.lnsf.model.Car;
import com.lnsf.model.StockIndent;

public class StockIndentdaoimpl implements IStockIndentdao {

	@Override
	public ArrayList<Car> findIndentBySid(int sid) {
		
       ArrayList<Car> indentList = new ArrayList<Car>();
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select i.fid,f.fname,i.fprice,i.samount "
					+ "from stockindent i,flower  f "
					+ "where i.fid = f.fid and i.sid = '"+sid+"';");
			while (rs.next()) {
				Car c = new Car();
				c.setFid(rs.getInt(1));
				c.setFname(rs.getString(2));
				c.setFprice(rs.getInt(3));
				c.setAmount(rs.getInt(4));
				indentList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.closeConnection(rs, stmt, conn);
		}
	
		return indentList;
		
	}

	@Override
	public boolean inserStockIdent(StockIndent si) {
		
		return false;
	}
	
	

}
