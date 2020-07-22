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
			System.out.println("½ø»õ³É¹¦");
			  }
	}
		

	//¹ÜÀíÔ±½ø»õ
public void  ManagerAddInCar(ArrayList<Car> listCar){
	
	FlowerdaoServiceimpl fs = new FlowerdaoServiceimpl();
	ShoppingCarServiceimpl scar = new ShoppingCarServiceimpl();
	Scanner in = new Scanner(System.in);
	
	Car car = new Car();
	System.out.println("ÊäÈëÒªÑ¡¹º»¨(±àºÅ»òÃû×Ö£©£º");
	Flower flower = new Flower();
		flower = fs.findFlower(in.next());//²é¿´ÊÇ·ñ´æÔÚ
	  if(flower.getFname() == null) {//²»´æÔÚ£¬²åÈëÐÂ»¨
		  System.out.println("ÊäÈë»¨Ãû£º");
		  String fname = in.next();
		  flower.setFname(fname);
		  System.out.println("µ¥¼Û£º");
		  flower.setFprice(in.nextInt());
		  System.out.println("½ø»õÊýÁ¿£º");
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
		  System.out.println("½ø»õµ¥¼Û£º");
		  sprice = in.nextInt();
		  System.out.println();
	  System.out.println("¹º½øµÄÊýÁ¿£º");
	int amount= in.nextInt();

	car = new Car(flower.getFid(),flower.getFname(),sprice,amount);
	
	scar.addInCar(car, listCar);
	
	ucon.userSelectCar(listCar);
	
}
	
}
	//²éÈ«²¿½ø»õ¼ÇÂ¼
	public void findAllStock(){
		
		ArrayList<Stock> list = stock.findAllStock();
		System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª-¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª");
		System.out.println("ËùÓÐµÄ½ø»õ¼ÇÂ¼£º");
		for (Stock stock : list) {
			System.out.println(stock);
		}
		System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª");
		
	}
	
	//²éÄ³ÔÂ½ø»õ¼ÇÂ¼
		public void findAllStock(String month){
			
			
			System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª-¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª");
			System.out.println(month+"µÄËùÓÐ½ø»õ¼ÇÂ¼£º");
			ArrayList<Stock> list = stock.findAllStock(month);
			for (Stock stock : list) {
				System.out.println(stock);
			}
			System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª");
			
		}

	
	//²é½ø»õÕËµ¥
	public void findIntendBySid(int sid){
		IndentdaoServiceimpl indent = new IndentdaoServiceimpl();
		ArrayList<Car> indentList = new ArrayList<Car>();
		indentList = stock.findIntendBySid(sid);
		System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª-¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª");
		System.out.println("ÄúµÄ½ø»õ¶©µ¥£º");
		System.out.println("¶©µ¥ºÅ£º"+ sid);
		System.out.println("     »¨±àºÅ       Ãû×Ö       ½ø»õ¼Û¸ñ          ÊýÁ¿ ");
		for (Car car : indentList) {		
			System.out.println(car);
			
		}
		System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª-¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª");
	}
		

	
	//²éÈ«²¿ÓÃ»§¶©µ¥
	public void selectAllMarket(){
		MarketdaoServiceimpl market = new MarketdaoServiceimpl();
		ArrayList<Market> list = new ArrayList<Market>();
		list = market.selectAllMarket();
		
		System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª-¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª");
		System.out.println("ËùÓÐ¶©µ¥£º");
		 for (Market market2 : list) {
			System.out.println(market2);
		}
		System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª-¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª");
		
		}
	
   //²éÄ³ÔÂÓÃ»§¶©µ¥ÊÕÈë
		public void selectAllMarket(String month){
			MarketdaoServiceimpl market = new MarketdaoServiceimpl();
			ArrayList<Market> list = new ArrayList<Market>();
			System.out.println(month+"ËùÓÐÏúÊÛ¶©µ¥£º");
			System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª-¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª");
			list = market.selectAllMarket(month);
			 for (Market market2 : list) {
				System.out.println(market2);
			}
			System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª-¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª");
			
			}
		
		
	//²éÓÃ»§ÕËµ¥ÄÚÈÝ
		public void findIntendByMid(int mid){
			IndentdaoServiceimpl indent = new IndentdaoServiceimpl();
			ArrayList<Car> indentList = new ArrayList<Car>();
			indentList = indent.findIntendByMid(mid);
			System.out.println("ÄúµÄ¶©µ¥£º");
			System.out.println("¶©µ¥ºÅ£º"+ mid);
			System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª-¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª");
			System.out.println("     »¨±àºÅ       Ãû×Ö       ½ø»õ¼Û¸ñ          ÊýÁ¿ ");
			for (Car car : indentList) {		
				System.out.println(car);
				
			}
			System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª-¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª");
		}
	
	
		//Í³¼ÆÔÂµÄÓ¯¿÷¡£
		public void statistics(String month){
			MarketdaoServiceimpl market = new MarketdaoServiceimpl();
			market.statistics(month);
		}
		
}
