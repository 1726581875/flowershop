package com.lnsf.service.impl;

import java.util.ArrayList;

import com.lnsf.dao.impl.Indentdaoimpl;
import com.lnsf.dao.impl.Marketdaoimpl;
import com.lnsf.model.Car;
import com.lnsf.model.Market;
import com.lnsf.service.IndentdaoService;

public class IndentdaoServiceimpl implements IndentdaoService {
	  Indentdaoimpl indent = new Indentdaoimpl();
	  Marketdaoimpl market = new Marketdaoimpl();
	@Override
	
	public ArrayList<Car> findIntendByMid(int mid) {
		
		ArrayList<Car> indentList = new ArrayList<Car>();
			
		if(market.selectMarketByMid(mid).isEmpty()){
			System.out.println("该订单号不存在!");
		}else{	
			indentList = indent.findIntendByMid(mid);
		}
		
		return indentList;
	}
	

}
