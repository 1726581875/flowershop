package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lnsf.DButils.DButil;
import com.lnsf.dao.Iindentdao;
import com.lnsf.model.Car;
import com.lnsf.model.Flower;
import com.lnsf.model.Indent;

public class Indentdaoimpl implements Iindentdao{
	
	@Override
	public ArrayList<Indent> selectAllIndent() {
		//查看购物车信息
		ArrayList<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConnection();
			String sql = "select * from indent";
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();
			while(rs.next()) {
				Indent indent = new Indent();
				indent.setIid(rs.getInt(1));
				indent.setFid(rs.getInt(2));
				indent.setMamount(rs.getInt(3));
				indent.setMid(rs.getInt(4));
				list.add(indent);
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.closeConnection(rs, prep, conn);
		}
             return list;		
	}

	@Override
	public boolean updateIndent(int iid, int mamount, int fid ) {
		// 更改花的种类和数量
		boolean flag = false;
	    Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DButil.getConnection();
			prep = (PreparedStatement) conn.prepareStatement("update indent set mamount = ? , fid = ? where iid = ?");
			prep.setInt(1, mamount);
			prep.setInt(2,fid);
			prep.setInt(3, iid);
			prep.executeUpdate();
			flag = true;			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.closeConnection(prep, conn);
		}			    
	    return flag;		
	}

	@Override
	public boolean deleteIndent(int iid) {
		//删除购物车里面的商品
		
		Connection conn = null;
		PreparedStatement prep = null;
		conn = DButil.getConnection();
		PreparedStatement prep1 = null;
		
		try {
			prep1 = conn.prepareStatement("delete from indent where iid = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		}				
			try {
				prep1.setInt(1,iid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				prep1.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public int addIndent(Indent in) {
		// 增加要买的商品
		int flag = 0;
		Object indent = null;
		Connection conn = null;
		PreparedStatement prep = null;
		conn = DButil.getConnection();
		
		try {
			
			prep =conn.prepareStatement("insert into indent(fid,mamount,mid) values(?,?,?)");
			prep.setInt(1,in.getFid());
			prep.setInt(2,in.getMamount());
		    prep.setInt(3,in.getMid());
		    prep.executeUpdate();	
		flag = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			if(prep!=null)
				try {
					prep.close();
					if(conn!=null)
			    conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	return flag;
	}

	
	@Override
	public ArrayList<Car> findIntendByMid(int mid) {
		
		ArrayList<Car> indentList = new ArrayList<Car>();
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select i.fid,f.fname,f.fprice,i.mamount "
					+ "from indent i,flower  f "
					+ "where i.fid = f.fid and i.mid = '"+mid+"';");
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
	
	
	
	

}
