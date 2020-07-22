package com.lnsf.dao;

import java.util.ArrayList;

import com.lnsf.model.Car;
import com.lnsf.model.StockIndent;

public interface IStockIndentdao {

	ArrayList<Car> findIndentBySid(int sid);
	boolean inserStockIdent(StockIndent si);
	
}
