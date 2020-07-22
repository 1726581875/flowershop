package com.lnsf.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.lnsf.model.Car;
import com.lnsf.model.Flower;
import com.lnsf.service.impl.FlowerdaoServiceimpl;
import com.lnsf.service.impl.ShoppingCarServiceimpl;

public class ShoppingController {
	
    ArrayList<Car> list = new ArrayList<Car>();
	ShoppingCarServiceimpl scar = new ShoppingCarServiceimpl();
	
	public boolean addInCar(Car c,ArrayList<Car> list){
		
		return scar.addInCar(c, list);
		
	}
	
	public Car selectById(Car c,ArrayList<Car> list){
		
		return scar.selectById(c, list);
	}
	
	public boolean delectForCar(String flower,ArrayList<Car> list){
		    
		
			return scar.delectForCar(flower, list);
			
	}
	
	
	public void updateCar(ArrayList<Car> listCar){
		FlowerdaoServiceimpl fd = new FlowerdaoServiceimpl();
		Scanner in = new Scanner(System.in);
		
		Car car = new Car();
		System.out.println("������Ҫ�޸ĵĻ�id��");
		int fid = in.nextInt();
		car.setFid(fid);
		car = selectById(car, listCar);//���Ǹû��Ƿ���ڹ��ﳵ
		System.out.println(car);
		if(car == null){System.err.println("���ﳵ��û�иû���");}
		else{
		System.out.println("�޸�������");
		int amount = in.nextInt();
		Flower f = new Flower();
		f = fd.findFlowerById(fid);
		if((f.getFamount() < amount))System.err.println("��治�㣡");
		else if(amount <= 0) System.out.println("�����Ǹ�����");
		else{
		car.setFid(fid);
		car.setAmount(amount);
		scar.updateCar(car, listCar);
		System.out.println("���³ɹ���");
		
		
		}
	}
	}
	
	
		}
