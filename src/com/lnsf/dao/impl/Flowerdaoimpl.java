package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.DButils.DButil;
import com.lnsf.dao.Iflowerdao;
import com.lnsf.model.Car;
import com.lnsf.model.Flower;

public class Flowerdaoimpl implements Iflowerdao {

	@Override
	public ArrayList<String> flowerRanking() {

		ArrayList<String> ranking = new ArrayList<String>();
		int row = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DButil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select flower.fname,count(mamount) "
					+ "from indent,flower where indent.fid = flower.fid "
					+ "group by indent.fid " + "order by count(mamount) desc;");

			while (rs.next()) {
				row++;
				String fname = rs.getString(1);
				int count = rs.getInt(2);
				ranking.add(row + "    " + fname + "    " + count);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DButil.closeConnection(rs, stmt, conn);
		}

		return ranking;
	}

	@Override
	public ArrayList<String> flowerAmountRanking() {

		ArrayList<String> ranking = new ArrayList<String>();
		int row = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DButil.getConnection();
			stmt = conn.createStatement();
			rs = stmt
					.executeQuery("select flower.fname,sum(mamount) from indent,flower  "
							+ "where indent.fid = flower.fid "
							+ "group by indent.fid "
							+ "order by sum(mamount) desc;");

			while (rs.next()) {
				row++;
				String fname = rs.getString(1);
				int count = rs.getInt(2);
				ranking.add(row + "    " + fname + "    " + count);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DButil.closeConnection(rs, stmt, conn);
		}

		return ranking;

	}

	@Override
	public ArrayList<Flower> findAllFlower() {

		ArrayList<Flower> list = new ArrayList<Flower>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from flower");
			while (rs.next()) {
				Flower f = new Flower();
				f.setFid(rs.getInt(1));
				f.setFname(rs.getString(2));
				f.setFprice(rs.getInt(3));
				f.setFamount(rs.getInt(4));
				list.add(f);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.closeConnection(rs, stmt, conn);
		}
		return list;
	}

	@Override
	public int insertInFlower(Flower f) {
		int flag = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		PreparedStatement prep1 = null;
		ResultSet rs1 = null;
		try {
			conn = DButil.getConnection();
			prep1 = conn.prepareStatement("select * from flower where fid = ?");
			prep1.setInt(1, f.getFid());
			rs1 = prep1.executeQuery();
			while (rs1.next()) {
				flag = 2;
				return flag;
			}
			prep = conn
					.prepareStatement("insert into flower (fname,fprice,famount) values (?,?,?)");
			prep.setString(1, f.getFname());
			prep.setInt(2, f.getFprice());
			prep.setInt(3, f.getFamount());
			prep.executeUpdate();
			flag = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.closeConnection(prep, conn);
			DButil.closeConnection(rs1, prep1, conn);
		}
		return flag;
	}

	@Override
	public int updateFlower(Flower f) {

		int flag = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		PreparedStatement prep1 = null;
		ResultSet rs1 = null;
		try {
			conn = DButil.getConnection();
			// 不存在返回2
			prep1 = conn.prepareStatement("select * from flower where fid = ?");
			prep1.setInt(1, f.getFid());
			rs1 = prep1.executeQuery();
			while (!rs1.next()) {
				flag = 2;
				return flag;
			}
			// 都存在
			prep = conn
					.prepareStatement("update flower set fname = ?,fprice = ?,famount = ? where fid = ?");
			prep.setString(1, f.getFname());
			prep.setInt(2, f.getFprice());
			prep.setInt(3, f.getFamount());
			prep.setInt(4, f.getFid());
			prep.executeUpdate();
			flag = 1;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			DButil.closeConnection(prep1, conn);
			DButil.closeConnection(rs1, prep1, conn);

		}

		return flag;
	}

	@Override
	public boolean deleteFlower(int _fid) {

		boolean flag = false;

		Connection conn = null;
		conn = DButil.getConnection();
		PreparedStatement prep = null;
		PreparedStatement prep1 = null;
		PreparedStatement prep2 = null;
		PreparedStatement prep3 = null;
		ResultSet rs = null;
		try {
			prep = conn.prepareStatement("select * from flower where fid = ?");
			prep.setInt(1, _fid);
			rs = prep.executeQuery();
			while (!rs.next()) {
				flag = false;
				return flag;
			}
			// 最后
			prep3 = conn.prepareStatement("delete from flower where fid = ?");
			prep3.setInt(1, _fid);
			prep3.executeUpdate();
			flag = true;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DButil.closeConnection(prep3, conn);
			DButil.closeConnection(rs, prep, conn);
			DButil.closeConnection(prep1, conn);
			DButil.closeConnection(prep2, conn);
		}
		return flag;
	}

	@Override
	public Flower findFlowerByName(String fname) {

		Flower flower = new Flower();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConnection();
			prep = conn
					.prepareStatement("select * from flower where fname = ?");
			prep.setString(1, fname);
			rs = prep.executeQuery();
			while (rs.next()) {
				flower.setFid(rs.getInt(1));
				flower.setFname(rs.getString(2));
				flower.setFprice(rs.getInt(3));
				flower.setFamount(rs.getInt(4));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.closeConnection(rs, prep, conn);
		}
		return flower;
	}

	public ArrayList<Car> findFlowerIdentMax(String month) {

		ArrayList<Car> list = new ArrayList<Car>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConnection();
			stmt = conn.createStatement();
			rs = stmt
					.executeQuery("select f.fid,f.fname,f.fprice,sum(i.mamount),m.mdate "
							+ " from indent i,flower  f ,market m "
							+ " where i.fid = f.fid and m.mid = i.mid and m.mdate  "
							+ " group by i.fid  "
							+ " order by sum(i.mamount) desc; ");
                if(rs.next()){
        			int end = rs.getString(5).indexOf("月");
        			String str = rs.getString(5).substring(0, end + 1);
        			if(str.equals(month)){
                    	Car c = new Car();
        				c.setFid(rs.getInt(1));
        				c.setFname(rs.getString(2));
        				c.setFprice(rs.getInt(3));
        				c.setAmount(rs.getInt(4));
        				list.add(c);
        				
        			}

                }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.closeConnection(rs, stmt, conn);
		}

		return list;

	}
	
	
	
	public ArrayList<Car> findFlowerAmountMax(String month) {
		ArrayList<Car> list = new ArrayList<Car>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConnection();
			stmt = conn.createStatement();
			rs = stmt
					.executeQuery("select f.fid,f.fname,f.fprice,count(i.mamount),m.mdate "
							+ " from indent i,flower  f ,market m "
							+ " where i.fid = f.fid and m.mid = i.mid and m.mdate  "
							+ " group by i.fid  "
							+ " order by sum(i.mamount) desc; ");
                if(rs.next()){
        			int end = rs.getString(5).indexOf("月");
        			String str = rs.getString(5).substring(0, end + 1);
        			if(str.equals(month)){
                    	Car c = new Car();
        				c.setFid(rs.getInt(1));
        				c.setFname(rs.getString(2));
        				c.setFprice(rs.getInt(3));
        				c.setAmount(rs.getInt(4));
        				list.add(c);      				
        			}

                }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.closeConnection(rs, stmt, conn);
		}

		return list;

	}
	

}
