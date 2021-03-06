package com.lnsf.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.lnsf.model.Car;
import com.lnsf.model.Flower;
import com.lnsf.model.Market;
import com.lnsf.model.Stock;
import com.lnsf.model.StockIndent;
import com.lnsf.service.impl.FlowerdaoServiceimpl;
import com.lnsf.service.impl.IndentdaoServiceimpl;
import com.lnsf.service.impl.MarketdaoServiceimpl;
import com.lnsf.service.impl.ShoppingCarServiceimpl;
import com.lnsf.service.impl.StockdaoServiceimpl;

public class ManagerController {
	
	
	UserController ucon = new UserController();
	StockdaoServiceimpl stock = new StockdaoServiceimpl();
	public void flowerStock(ArrayList<Car> list){
	
		boolean flag = stock.flowerStock(list);
		if(flag) {
			list.clear();
			System.out.println("序歯撹孔");
			  }
	}
		

	//砿尖埀序歯
public void  ManagerAddInCar(ArrayList<Car> listCar){
	
	FlowerdaoServiceimpl fs = new FlowerdaoServiceimpl();
	ShoppingCarServiceimpl scar = new ShoppingCarServiceimpl();
	Scanner in = new Scanner(System.in);
	
	Car car = new Car();
	System.out.println("補秘勣僉杭雑(園催賜兆忖����");
	Flower flower = new Flower();
		flower = fs.findFlower(in.next());//臥心頁倦贋壓
	  if(flower.getFname() == null) {//音贋壓��峨秘仟雑
		  System.out.println("補秘雑兆��");
		  String fname = in.next();
		  flower.setFname(fname);
		  System.out.println("汽勺��");
		  flower.setFprice(in.nextInt());
		  System.out.println("序歯方楚��");
		  int amount = in.nextInt();
		  flower.setFamount(0);
		  fs.insertInFlower(flower);
		  flower = fs.findFlowerByName(fname);
		  
		  car = new Car(flower.getFid(),flower.getFname(),flower.getFprice(),amount);
		  scar.addInCar(car, listCar);
		  ucon.userSelectCar(listCar);
	  }
	  else{
		  int sprice;
		  System.out.println("序歯汽勺��");
		  sprice = in.nextInt();
		  System.out.println();
	  System.out.println("杭序議方楚��");
	int amount= in.nextInt();

	car = new Car(flower.getFid(),flower.getFname(),sprice,amount);
	
	scar.addInCar(car, listCar);
	
	ucon.userSelectCar(listCar);
	
}
	
}
	//臥畠何序歯芝村
	public void findAllStock(){
		
		ArrayList<Stock> list = stock.findAllStock();
		System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！-！！！！！！！！！！！！！！！");
		System.out.println("侭嗤議序歯芝村��");
		for (Stock stock : list) {
			System.out.println(stock);
		}
		System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
		
	}
	
	//臥蝶埖序歯芝村
		public void findAllStock(String month){
			
			
			System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！-！！！！！！！！！！！！！！！");
			System.out.println(month+"議侭嗤序歯芝村��");
			ArrayList<Stock> list = stock.findAllStock(month);
			for (Stock stock : list) {
				System.out.println(stock);
			}
			System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
			
		}

	
	//臥序歯嬲汽
	public void findIntendBySid(int sid){
		IndentdaoServiceimpl indent = new IndentdaoServiceimpl();
		ArrayList<Car> indentList = new ArrayList<Car>();
		indentList = stock.findIntendBySid(sid);
		System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！-！！！！！！！！！！！！！！！");
		System.out.println("艇議序歯匡汽��");
		System.out.println("匡汽催��"+ sid);
		System.out.println("     雑園催       兆忖       序歯勺鯉          方楚 ");
		for (Car car : indentList) {		
			System.out.println(car);
			
		}
		System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！-！！！！！！！！！！！！！！！");
	}
		

	
	//臥畠何喘薩匡汽
	public void selectAllMarket(){
		MarketdaoServiceimpl market = new MarketdaoServiceimpl();
		ArrayList<Market> list = new ArrayList<Market>();
		list = market.selectAllMarket();
		
		System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！-！！！！！！！！！！！！！！！");
		System.out.println("侭嗤匡汽��");
		 for (Market market2 : list) {
			System.out.println(market2);
		}
		System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！-！！！！！！！！！！！！！！！");
		
		}
	
   //臥蝶埖喘薩匡汽辺秘
		public void selectAllMarket(String month){
			MarketdaoServiceimpl market = new MarketdaoServiceimpl();
			ArrayList<Market> list = new ArrayList<Market>();
			System.out.println(month+"侭嗤��弁匡汽��");
			System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！-！！！！！！！！！！！！！！！");
			list = market.selectAllMarket(month);
			 for (Market market2 : list) {
				System.out.println(market2);
			}
			System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！-！！！！！！！！！！！！！！！");
			
			}
		
		
	//臥喘薩嬲汽坪否
		public void findIntendByMid(int mid){
			IndentdaoServiceimpl indent = new IndentdaoServiceimpl();
			ArrayList<Car> indentList = new ArrayList<Car>();
			indentList = indent.findIntendByMid(mid);
			System.out.println("艇議匡汽��");
			System.out.println("匡汽催��"+ mid);
			System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！-！！！！！！！！！！！！！！！");
			System.out.println("     雑園催       兆忖       序歯勺鯉          方楚 ");
			for (Car car : indentList) {		
				System.out.println(car);
				
			}
			System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！-！！！！！！！！！！！！！！！");
		}
	
	
		//由柴埖議哢雛。
		public void statistics(String month){
			MarketdaoServiceimpl market = new MarketdaoServiceimpl();
			market.statistics(month);
		}
		
}
