package com.lnsf.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.lnsf.dao.impl.Userdaoimpl;
import com.lnsf.model.Car;
import com.lnsf.model.Flower;
import com.lnsf.model.Market;
import com.lnsf.model.User;
import com.lnsf.service.impl.FlowerdaoServiceimpl;
import com.lnsf.service.impl.IndentdaoServiceimpl;
import com.lnsf.service.impl.MarketdaoServiceimpl;
import com.lnsf.service.impl.ShoppingCarServiceimpl;
import com.lnsf.service.impl.UserdaoServiceimpl;

public class UserController {
        UserdaoServiceimpl user = new UserdaoServiceimpl();
    	FlowerdaoServiceimpl fs = new FlowerdaoServiceimpl();
    	ShoppingCarServiceimpl scar = new ShoppingCarServiceimpl();
    	
    	
    	public User selectByName(String username){
    		
    		return user.selectByName(username);
    	}
    	
    	//登录
	public int login(String username,String password){
		
		return user.login(username, password);
		
	}
	
	//注册
	public int register(User u){	
		return user.register(u);
	}
	
	//更新用户信息
	public void updateUser(User u){
		Scanner in = new Scanner(System.in);
	      int flag;
	      String userStr;
		while(true){
	
			Userdaoimpl ud = new Userdaoimpl();
			
			System.out.println("您的信息：");
			  System.out.println(u);
			  System.out.println();
			 System.out.println("---1.修改用户名 ---2.修改密码  ---3.修改地址  ----4.返回");
			  
			flag = in.nextInt();
			if(flag == 4) break;
			switch(flag){
			
			case 1:
				System.out.println("输入修改后用户名：");
				userStr = in.next();
				u.setUsername(userStr);
				boolean f = user.updateById(u);
				if(f) System.out.println("修改成功！");
				else System.out.println("用户名已存在");
				break;
			case 2:
				System.out.println("输入修改后密码：");
				userStr = in.next();
				u.setPassword(userStr);
				   f = ud.updateById(u);
				if(f) System.out.println("修改成功！");
				else System.out.println("修改失败！");
				break;
			case 3:
				System.out.println("输入修改后地址：");
				userStr = in.next();
				u.setAddress(userStr);
				  f = ud.updateById(u);
				if(f) System.out.println("修改成功！");
				else System.out.println("修改失败！");
				
				break;
			
			default:
			System.out.println("输入有误！");
			
			}
				
			
		}
		
		
	}
	
	
	//查看购物车
	public void userSelectCar(ArrayList<Car> listCar){
		
		int count = 0;
		System.out.println("———————————————————————————-———————————————");
		System.out.println("       花编号      名字     单价     购买数量");
		for (Car car : listCar) {	
			System.out.println(car);
			count = count + car.getAmount()*car.getFprice();
		}
		System.out.println();
		System.out.println("                                    需要支付："+count+"元");
		System.out.println("———————————————————————————-———————————————");
		
	}
	
	
	//购买花
	public void userInsertCar(ArrayList<Car> listCar){
			
		Scanner in = new Scanner(System.in);
		Car car = new Car();
		System.out.println("输入要选购花(编号或名字）：");
		Flower flower = new Flower();
				flower = fs.findFlower(in.next());
		  if(flower.getFname() == null) System.out.println("该花不存在！");
		  else{
		System.out.println("购买的数量：");
		int amount= in.nextInt();
		if(amount > flower.getFamount()) System.err.println("库存不足！");
		else{
		car = new Car(flower.getFid(),flower.getFname(),flower.getFprice(),amount);
		scar.addInCar(car, listCar);
		
		userSelectCar(listCar);
		}
      
	}
	}
	
	
	public void userPayCar(User u,ArrayList<Car> listCar){
		 
		
		
	}
	
//查订单
public void selectMarketByUserid(int userid){
	MarketdaoServiceimpl market = new MarketdaoServiceimpl();
	ArrayList<Market> list = new ArrayList<Market>();
	list = market.selectMarketByUserid(userid);
	
	System.out.println("———————————————————————————————————————————————————————-———————————————");
	System.out.println("所有订单：");
	 for (Market market2 : list) {
		System.out.println(market2);
	}
	System.out.println("———————————————————————————————————————————————————————-———————————————");
	
	}
	
	//查账单
	public void findIntendByMid(int mid,int userid){
		IndentdaoServiceimpl indent = new IndentdaoServiceimpl();
		ArrayList<Car> indentList = new ArrayList<Car>();
		indentList = indent.findIntendByMid(mid);
		System.out.println("———————————————————————————-———————————————");
		System.out.println("您的订单：");
		System.out.println("订单号："+ mid);
		System.out.println("     花编号       名字       进货价格          数量 ");
		for (Car car : indentList) {		
			System.out.println(car);
			
		}
		System.out.println("———————————————————————————-———————————————");
	}
	
	
	public void updateById(User u) {
		
		 user.updateById(u);
	}
	
	public ArrayList<User> selectAllUser(){
	  return user.selectAllUser();
	}
	
	public void deleteUser(int id){
		user.deleteUser(id);
	}
	
}
