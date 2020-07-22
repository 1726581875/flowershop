package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import com.lnsf.DButils.DButil;
import com.lnsf.dao.Istockdao;
import com.lnsf.model.Car;
import com.lnsf.model.Flower;
import com.lnsf.model.Stock;
import com.lnsf.model.User;

public class Stockdaoimpl implements Istockdao {
	
	
	public ArrayList<Stock> selectStockBySid(int sid){

		ArrayList<Stock> list = new ArrayList<Stock>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DButil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from stock where sid = '"+sid+"'");
			while (rs.next()) {
				Stock s = new Stock();
				s.setSid(rs.getInt(1));
				s.setSdate(rs.getString(2));
				s.setSprice(rs.getInt(3));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.closeConnection(rs, stmt, conn);
		}
		return list;
		
	}
	
	@Override
	public ArrayList<Stock> findAllStock(String month) {
		
		ArrayList<Stock> list = new ArrayList<Stock>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DButil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from stock where sdate = '"+month+"'");
			while (rs.next()) {
				Stock s = new Stock();
				s.setSid(rs.getInt(1));
				s.setSdate(rs.getString(2));
				s.setSprice(rs.getInt(3));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.closeConnection(rs, stmt, conn);
		}
		return list;
		
	}
	
	
	
	@Override
	public ArrayList<Stock> findAllStock() {
		
		ArrayList<Stock> list = new ArrayList<Stock>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DButil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from stock");
			while (rs.next()) {
				Stock s = new Stock();
				s.setSid(rs.getInt(1));
				s.setSdate(rs.getString(2));
				s.setSprice(rs.getInt(3));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.closeConnection(rs, stmt, conn);
		}
		return list;
		
	}


	@Override
	public boolean addNewFlower(String fid) {
		
		 Connection conn = null;
		 PreparedStatement prep = null;
		 ResultSet rs = null;
		 
		
		 
			return false;
	}
	
	
	public boolean flowerStock(ArrayList<Car> list) {
		boolean flag = false;
    	
		Connection conn = null;
		PreparedStatement prep = null;
		PreparedStatement prep1 = null;
		PreparedStatement prep2 = null;
		PreparedStatement prep3 = null;
		PreparedStatement prep4 = null;
		ResultSet rs2 = null;
		
		conn = DButil.getConnection();
            try {//向账单表插入一条记录,id自增长
	       prep = conn.prepareStatement("insert into stock(sdate,sprice) "
			+ "values(?,?)");
	       prep.setString(1,getNowTime());
	       prep.setInt(2,0);//默认总金额为0
	       prep.executeUpdate();
	       
	          //查找刚插入的账单Id号  
	       prep2 = conn.prepareStatement("select * from stock where sdate=?");
	       prep2.setString(1,getNowTime());
	       rs2 = prep2.executeQuery();
	       int sid = 0;
	       while(rs2.next()){
	    	   sid = rs2.getInt("sid");
	       }
	             
	       int count = 0;//计算总金额
	       for (Car car : list) {
	    	   
	    	 //把购物车里的选修记录插入indent表			
	       prep1 = conn.prepareStatement("insert into stockindent(fid,fprice,samount,sid) values(?,?,?,?)");
	       prep1.setInt(1,car.getFid());
	       prep1.setInt(2,car.getFprice());
	       prep1.setInt(3,car.getAmount());
	       prep1.setInt(4,sid);//所属账单号
	       prep1.executeUpdate();  
	         
	       //修改库存
	       Flowerdaoimpl fd = new Flowerdaoimpl();
	        Flower flower = fd.findFlowerByName(car.getFname());
	       prep4 = conn.prepareStatement("update flower set famount = ? where fid = ?");
	       prep4.setInt(1,flower.getFamount()+car.getAmount());
	       prep4.setInt(2,car.getFid());
	       prep4.executeUpdate();
	       
	      // 计算总金额
	       count = count + car.getAmount()*car.getFprice();
	       
	       }
	       
	       //修改账单总额（原本为0）
	       prep3 = conn.prepareStatement("update stock set sprice = ? where sid = ?");
	       prep3.setInt(1,count);
	       prep3.setInt(2,sid);
	       prep3.executeUpdate();
	                 
	       flag = true;
            } catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				DButil.closeConnection(rs2, prep2, conn);
				DButil.closeConnection(prep, conn);
				DButil.closeConnection(prep1, conn);
				DButil.closeConnection(prep3, conn);
				DButil.closeConnection(prep4, conn);
			}
		
    	
    	return flag;
	}
	
	
	public String getNowTime() {
		   //获取当前时间 
			Calendar c =  Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH)+1;
			int day = c.get(Calendar.DAY_OF_MONTH);
			
		    return year+"年"+month+"月"+day;
	}
	

}
