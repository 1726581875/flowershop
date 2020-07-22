package com.lnsf.service;

import java.util.ArrayList;

import com.lnsf.model.Car;
import com.lnsf.model.Market;
import com.lnsf.model.User;

public interface MarketdaoService {

	boolean payCar(User u, ArrayList<Car> list);
	ArrayList<Market> selectMarketByUserid(int userid);
	 ArrayList<Market> selectAllMarket();
}
