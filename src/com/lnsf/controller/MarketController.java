package com.lnsf.controller;

import java.util.ArrayList;

import com.lnsf.model.Car;
import com.lnsf.model.User;
import com.lnsf.service.impl.MarketdaoServiceimpl;

public class MarketController {

	MarketdaoServiceimpl market = new MarketdaoServiceimpl();
	public void payCar(User u, ArrayList<Car> list){
		
		boolean flag = market.payCar(u, list);
		if(flag) {
			list.clear();
			System.out.println("Ö§¸¶³É¹¦");}
	}
	
}
