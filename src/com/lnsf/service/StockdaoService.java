package com.lnsf.service;

import java.util.ArrayList;

import com.lnsf.model.Car;
import com.lnsf.model.Stock;
import com.lnsf.model.StockIndent;
import com.lnsf.service.impl.IndentdaoServiceimpl;

public interface StockdaoService {

	boolean flowerStock(ArrayList<Car> list);
	 ArrayList<Stock> findAllStock();
		//���˵�
	 ArrayList<Car> findIntendBySid(int sid);
	 ArrayList<Stock> findAllStock(String month);//��ѯĳ�½�����¼
}
