package com.lnsf.dao;

import java.util.ArrayList;

import com.lnsf.model.Car;
import com.lnsf.model.Stock;

public interface Istockdao {
    
	boolean addNewFlower(String fid);//����
	boolean flowerStock(ArrayList<Car> list);
	 String getNowTime();
	 ArrayList<Stock> findAllStock();//��ѯ���н�����¼
	 ArrayList<Stock> findAllStock(String month);//��ѯĳ�½�����¼
	 ArrayList<Stock> selectStockBySid(int sid);//�鿴������¼
	
	
}
