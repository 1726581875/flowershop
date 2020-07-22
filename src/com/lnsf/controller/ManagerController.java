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
			System.out.println("�����ɹ�");
			  }
	}
		

	//����Ա����
public void  ManagerAddInCar(ArrayList<Car> listCar){
	
	FlowerdaoServiceimpl fs = new FlowerdaoServiceimpl();
	ShoppingCarServiceimpl scar = new ShoppingCarServiceimpl();
	Scanner in = new Scanner(System.in);
	
	Car car = new Car();
	System.out.println("����Ҫѡ����(��Ż����֣���");
	Flower flower = new Flower();
		flower = fs.findFlower(in.next());//�鿴�Ƿ����
	  if(flower.getFname() == null) {//�����ڣ������»�
		  System.out.println("���뻨����");
		  String fname = in.next();
		  flower.setFname(fname);
		  System.out.println("���ۣ�");
		  flower.setFprice(in.nextInt());
		  System.out.println("����������");
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
		  System.out.println("�������ۣ�");
		  sprice = in.nextInt();
		  System.out.println();
	  System.out.println("������������");
	int amount= in.nextInt();

	car = new Car(flower.getFid(),flower.getFname(),sprice,amount);
	
	scar.addInCar(car, listCar);
	
	ucon.userSelectCar(listCar);
	
}
	
}
	//��ȫ��������¼
	public void findAllStock(){
		
		ArrayList<Stock> list = stock.findAllStock();
		System.out.println("������������������������������������������������������-������������������������������");
		System.out.println("���еĽ�����¼��");
		for (Stock stock : list) {
			System.out.println(stock);
		}
		System.out.println("����������������������������������������������������������������������������������������");
		
	}
	
	//��ĳ�½�����¼
		public void findAllStock(String month){
			
			
			System.out.println("������������������������������������������������������-������������������������������");
			System.out.println(month+"�����н�����¼��");
			ArrayList<Stock> list = stock.findAllStock(month);
			for (Stock stock : list) {
				System.out.println(stock);
			}
			System.out.println("����������������������������������������������������������������������������������������");
			
		}

	
	//������˵�
	public void findIntendBySid(int sid){
		IndentdaoServiceimpl indent = new IndentdaoServiceimpl();
		ArrayList<Car> indentList = new ArrayList<Car>();
		indentList = stock.findIntendBySid(sid);
		System.out.println("������������������������������������������������������-������������������������������");
		System.out.println("���Ľ���������");
		System.out.println("�����ţ�"+ sid);
		System.out.println("     �����       ����       �����۸�          ���� ");
		for (Car car : indentList) {		
			System.out.println(car);
			
		}
		System.out.println("������������������������������������������������������-������������������������������");
	}
		

	
	//��ȫ���û�����
	public void selectAllMarket(){
		MarketdaoServiceimpl market = new MarketdaoServiceimpl();
		ArrayList<Market> list = new ArrayList<Market>();
		list = market.selectAllMarket();
		
		System.out.println("��������������������������������������������������������������������������������������������������������������-������������������������������");
		System.out.println("���ж�����");
		 for (Market market2 : list) {
			System.out.println(market2);
		}
		System.out.println("��������������������������������������������������������������������������������������������������������������-������������������������������");
		
		}
	
   //��ĳ���û���������
		public void selectAllMarket(String month){
			MarketdaoServiceimpl market = new MarketdaoServiceimpl();
			ArrayList<Market> list = new ArrayList<Market>();
			System.out.println(month+"�������۶�����");
			System.out.println("��������������������������������������������������������������������������������������������������������������-������������������������������");
			list = market.selectAllMarket(month);
			 for (Market market2 : list) {
				System.out.println(market2);
			}
			System.out.println("��������������������������������������������������������������������������������������������������������������-������������������������������");
			
			}
		
		
	//���û��˵�����
		public void findIntendByMid(int mid){
			IndentdaoServiceimpl indent = new IndentdaoServiceimpl();
			ArrayList<Car> indentList = new ArrayList<Car>();
			indentList = indent.findIntendByMid(mid);
			System.out.println("���Ķ�����");
			System.out.println("�����ţ�"+ mid);
			System.out.println("������������������������������������������������������-������������������������������");
			System.out.println("     �����       ����       �����۸�          ���� ");
			for (Car car : indentList) {		
				System.out.println(car);
				
			}
			System.out.println("������������������������������������������������������-������������������������������");
		}
	
	
		//ͳ���µ�ӯ����
		public void statistics(String month){
			MarketdaoServiceimpl market = new MarketdaoServiceimpl();
			market.statistics(month);
		}
		
}
