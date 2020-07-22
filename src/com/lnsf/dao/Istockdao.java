package com.lnsf.dao;

import java.util.ArrayList;

import com.lnsf.model.Car;
import com.lnsf.model.Stock;

public interface Istockdao {
    
	boolean addNewFlower(String fid);//进货
	boolean flowerStock(ArrayList<Car> list);
	 String getNowTime();
	 ArrayList<Stock> findAllStock();//查询所有进货记录
	 ArrayList<Stock> findAllStock(String month);//查询某月进货记录
	 ArrayList<Stock> selectStockBySid(int sid);//查看单个记录
	
	
}
