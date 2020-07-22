package com.lnsf.service.impl;

import java.util.ArrayList;

import com.lnsf.dao.impl.Flowerdaoimpl;
import com.lnsf.dao.impl.Marketdaoimpl;
import com.lnsf.dao.impl.Stockdaoimpl;
import com.lnsf.model.Car;
import com.lnsf.model.Flower;
import com.lnsf.model.Market;
import com.lnsf.model.Stock;
import com.lnsf.model.User;
import com.lnsf.service.MarketdaoService;

public class MarketdaoServiceimpl implements MarketdaoService {
	Marketdaoimpl market = new Marketdaoimpl();
	
	public ArrayList<Market> selectAllMarket(){
		
		return market.selectAllMarket();
	}
	

	//查询某月的收入订单
	public ArrayList<Market> selectAllMarket(String month){
		
		 int countAll = 0;
		 ArrayList<Market> list = new ArrayList<Market>();
		list = market.selectAllMarket();
		 for (int i = list.size() - 1;i >=0 ;i--) {
			String str = list.get(i).getMdate();
			int endStr = list.get(i).getMdate().indexOf("月");
			str = str.substring(0, endStr+1);
			if(!str.equals(month)){
				list.remove(list.get(i));
			}else{
				countAll = countAll+list.get(i).getMprice();
			}
			
		}
		 System.out.println(month+"销售总收入："+countAll+"元");
		 
		return list;
		
		
	}
	
	
	//统计月总收入
	public void statistics(String month){
		
		Flowerdaoimpl flower = new Flowerdaoimpl();
        //统计收入
		 int countAllIn = 0;
		 ArrayList<Market> list = new ArrayList<Market>();
		list = market.selectAllMarket();
		 for (int i = list.size() - 1;i >=0 ;i--) {
			String str = list.get(i).getMdate();
			int endStr = list.get(i).getMdate().indexOf("月");
			str = str.substring(0, endStr+1);
			if(!str.equals(month)){
				list.remove(list.get(i));
			}else{
				countAllIn = countAllIn + list.get(i).getMprice();
			}
		 }
			
		//统计支出
			 Stockdaoimpl sto = new Stockdaoimpl();
			 int countAllOut = 0;
			 ArrayList<Stock> listStock = new ArrayList<Stock>();
			listStock = sto.findAllStock();
			 for (int i = listStock.size() - 1;i >= 0 ;i--) {
				   String str = listStock.get(i).getSdate();
				int end = listStock.get(i).getSdate().indexOf("月");
				str = str.substring(0, end + 1);
				if(!str.equals(month)){
					listStock.remove(listStock.get(i));
				}else{
					countAllOut = countAllOut + listStock.get(i).getSprice();
				}
			 }
		     
//			//找出最大销量
     ArrayList<Car> listMax = flower.findFlowerIdentMax(month);
     ArrayList<Car> listMax2 = flower.findFlowerAmountMax(month);
     System.out.println("———————————————————————————————————————————————————————");
     System.out.println();
	  if(!listMax.isEmpty())
     System.out.println(month+"最大销量的花："+listMax.get(0).getFname()+"，一共卖出"+listMax.get(0).getAmount()+"朵");
		if(!listMax2.isEmpty())
 System.out.println(month+"多人购买的花："+listMax2.get(0).getFname()+"，一共有"+listMax2.get(0).getAmount()+"人购买");
	  System.out.println(month+"一共支出："+countAllOut);
			 System.out.println(month+"一共收入："+countAllIn);
			 int countAll = countAllIn - countAllOut;
		 System.out.println(month+"盈利："+countAll);
		 System.out.println();
	     System.out.println("———————————————————————————————————————————————————————"); 
	}
	
	@Override
	public boolean payCar(User u, ArrayList<Car> list) {
		
		return market.payCar(u, list);
	}
	
	
public ArrayList<Market> selectMarketByUserid(int userid){
		
		return market.selectMarketByUserid(userid);
	}
	

}
