package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.lnsf.DButils.DButil;
import com.lnsf.dao.Imarketdao;
import com.lnsf.model.Car;
import com.lnsf.model.Flower;
import com.lnsf.model.Market;
import com.lnsf.model.User;

public class Marketdaoimpl implements Imarketdao {

	@Override
	public ArrayList<Market> selectAllMarket(){
		ArrayList<Market> list = new ArrayList<Market>();			
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {			
			conn = DButil.getConnection();    
			prep = conn.prepareStatement("select * from market");
			rs = prep.executeQuery();
			while(rs.next()) {
				Market market = new Market();
				market.setMid(rs.getInt(1));
				market.setUserid(rs.getInt(2));
				market.setMprice(rs.getInt(3));
				market.setMdate(rs.getString(4));
				market.setAddress(rs.getString(5));
				list.add(market);
			}
			    
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			DButil.closeConnection(prep, conn);
		}		
		return list;
	}
	@Override
	public ArrayList<Market> selectMarketByUserid(int userid) {
		// 根据用户id查找订单
		ArrayList<Market> list = new ArrayList<Market>();			
			Connection conn = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			try {			
				conn = DButil.getConnection();    
				prep = conn.prepareStatement("select * from market where userid = ?");
				prep.setInt(1,userid);
				rs = prep.executeQuery();
				while(rs.next()) {
					Market market = new Market();
					market.setMid(rs.getInt(1));
					market.setUserid(rs.getInt(2));
					market.setMprice(rs.getInt(3));
					market.setMdate(rs.getString(4));
					market.setAddress(rs.getString(5));
					list.add(market);
				}
				    
			} catch (SQLException e) {

				e.printStackTrace();
			}finally {
				DButil.closeConnection(prep, conn);
			}		
			return list;
	}
	
	
	public ArrayList<Market> selectMarketByMid(int mid) {
		// 根据用户id查找订单
		ArrayList<Market> list = new ArrayList<Market>();			
			Connection conn = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			try {			
				conn = DButil.getConnection();    
				prep = conn.prepareStatement
					("select * from market where mid = ?");
				prep.setInt(1,mid);
				rs = prep.executeQuery();
				if(rs.next()) {
					Market market = new Market();
					market.setMid(rs.getInt(1));
					market.setUserid(rs.getInt(2));
					market.setMprice(rs.getInt(3));
					market.setMdate(rs.getString(4));
					market.setAddress(rs.getString(5));
					
					list.add(market);
				}
				    
			} catch (SQLException e) {

				e.printStackTrace();
			}finally {
				DButil.closeConnection(prep, conn);
			}		
			return list;
	}
	
	
	
	
	public boolean delectMarket(User u, int mid) {
		boolean flag = false;
    	
		Connection conn = null;
		PreparedStatement prep = null;
		PreparedStatement prep1 = null;
		PreparedStatement prep2 = null;
		PreparedStatement prep3 = null;
		PreparedStatement prep4 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		
		conn = DButil.getConnection();
            try {	
     	       prep = conn.prepareStatement("select * from indent where mid = ?");
    	       prep.setInt(1,mid);
    	       rs = prep.executeQuery();
    	       while(rs.next()){    
    	       //修改库   
    		       prep3 = conn.prepareStatement("select * from flower where fid = ?");
    		       prep3.setInt(1,rs.getInt("fid"));
    		       rs3 = prep3.executeQuery(); 
    		       int famount = 0;
    		       while(rs3.next()){
    		    	   famount = rs3.getInt("famount");	    	   
    		       }
    	    
    	       prep4 = conn.prepareStatement("update flower set famount = ? where fid = ?");
    	       prep4.setInt(1,famount + rs.getInt("mamount"));
    	       prep4.setInt(2,rs.getInt("fid"));
    	       prep4.executeUpdate();
    	       }
    	       
    	       
 	          //查找刚插入的账单Id号  
    	       prep1 = conn.prepareStatement("delete from indent where mid = ?");
    	       prep1.setInt(1,mid);
    	        prep1.executeUpdate();
    	       
    	       prep2 = conn.prepareStatement("delete from market where mid=?");
    	       prep2.setInt(1,mid);
    	        prep2.executeUpdate();  
            	  
	                 
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
	
	
	
	@Override
	public String getNowTime() {
		   //获取当前时间 
			Calendar c =  Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH)+1;
			int day = c.get(Calendar.DAY_OF_MONTH);
			
		    return year+"年"+month+"月"+day;
	}
	
	
	@Override
	public int deleteForCar(Flower f, String userid) {
		 int flag = 0;	
		
		 Connection conn = null;
         PreparedStatement prep = null;
              
        try {
			prep = conn.prepareStatement("delect from market where userid = ? and fid = ?");
	        prep.setString(1,userid);
	        prep.setInt(2,f.getFid());
	        if(prep.executeUpdate() ==1 ) flag = 1;
			     
        } catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			
			DButil.closeConnection(prep, conn);
		}
        		
		 return flag;
	}
	
	
	
	public boolean payCar(User u, ArrayList<Car> list) {
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
	       prep = conn.prepareStatement("insert into market(userid,mprice,mdate,address) "
			+ "values(?,?,?,?)");
	       prep.setInt(1,u.getUserid());
	       prep.setInt(2,0);//默认总金额为0
	       prep.setString(3,getNowTime());
	       prep.setString(4,u.getAddress());
	       prep.executeUpdate();
	       
	          //查找刚插入的账单Id号  
	       prep2 = conn.prepareStatement("select * from market where userid=?");
	       prep2.setInt(1,u.getUserid());
	       rs2 = prep2.executeQuery();
	       int mid = 0;
	       while(rs2.next()){
	    	   mid = rs2.getInt("mid");
	       }
	             
	       int count = 0;//计算总金额
	       for (Car car : list) {
	    	   
	    	 //把购物车里的选修记录插入indent表			
	       prep1 = conn.prepareStatement("insert into indent(fid,mamount,mid) values(?,?,?)");
	       prep1.setInt(1,car.getFid());
	       prep1.setInt(2,car.getAmount());
	       prep1.setInt(3,mid);//所属账单号
	       prep1.executeUpdate();  
	         
	       //修改库存
	       Flowerdaoimpl fd = new Flowerdaoimpl();
	        Flower flower = fd.findFlowerByName(car.getFname());
	       prep4 = conn.prepareStatement("update flower set famount = ? where fid = ?");
	       prep4.setInt(1,flower.getFamount()-car.getAmount());
	       prep4.setInt(2,car.getFid());
	       prep4.executeUpdate();
	       
	      // 计算总金额
	       count = count + car.getAmount()*car.getFprice();
	       
	       }
	       
	       //修改账单总额（原本为0）
	       prep3 = conn.prepareStatement("update market set mprice = ? where mid = ?");
	       prep3.setInt(1,count);
	       prep3.setInt(2,mid);
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
	
	
	
}
