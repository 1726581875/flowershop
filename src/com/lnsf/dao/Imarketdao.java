package com.lnsf.dao;

import java.util.ArrayList;

import com.lnsf.model.Car;
import com.lnsf.model.Flower;
import com.lnsf.model.Market;
import com.lnsf.model.User;


public interface Imarketdao {
	ArrayList<Market> selectAllMarket();
	boolean payCar(User u,ArrayList<Car> list);//Ω·’À
	int deleteForCar(Flower f,String userid);
	String getNowTime();
	ArrayList<Market> selectMarketByUserid(int userid);
	ArrayList<Market> selectMarketByMid(int mid);
}
