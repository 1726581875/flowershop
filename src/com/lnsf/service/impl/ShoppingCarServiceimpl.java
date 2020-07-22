package com.lnsf.service.impl;

import java.util.ArrayList;

import com.lnsf.model.Car;
import com.lnsf.service.ShoppingCartService;

public class ShoppingCarServiceimpl implements ShoppingCartService{

	@Override
	public Car selectById(Car c, ArrayList<Car> list) {//�鿴���ﳵ���Ƿ����

		
      	for (Car car : list) {
			
      		if(car.getFid() == c.getFid()){
      			return car; 			
      		}
      		
		}
		
		return null;
	}

	@Override
	public boolean addInCar(Car c, ArrayList<Car> list) {//��ӽ����ﳵ
boolean flag = false;
		
		Car old = selectById(c, list);
		if(old != null){		
			old.setAmount(old.getAmount() + c.getAmount());
		}
		else{
			list.add(c);
			
		}	
		return flag;
	}

	
	@Override
	public boolean delectForCar(String flower, ArrayList<Car> list) {
		
       for (Car car : list) {
		if(car.getFname().equals(flower)){
			list.remove(car);
			return true;
		}
       }
       
	   String regex = "[0-9]*";
		if(flower.matches(regex)){
		int fid = Integer.parseInt(flower);
		
		     for (Car c : list) {
			   		if(c.getFid() == fid){
			   		list.remove(c);
			   		return true;
			   		}	   		
		}	
       }
		
		System.err.println("���ﳵ��û�иû���");
		return false;
	
       }

	
	@Override
	public boolean updateCar(Car c, ArrayList<Car> list) {
		
		for (Car car : list) {
			if(car.getFid() == c.getFid()){
				car.setAmount(c.getAmount());
			   return true;	
			}	
		                     }	
		
		return false;
	}

	
}
