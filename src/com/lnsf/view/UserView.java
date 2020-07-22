package com.lnsf.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.lnsf.controller.FlowerController;
import com.lnsf.controller.MarketController;
import com.lnsf.controller.ShoppingController;
import com.lnsf.controller.UserController;
import com.lnsf.dao.impl.Flowerdaoimpl;
import com.lnsf.dao.impl.Marketdaoimpl;
import com.lnsf.model.Car;
import com.lnsf.model.Flower;
import com.lnsf.model.User;
import com.lnsf.service.impl.FlowerdaoServiceimpl;
import com.lnsf.service.impl.ShoppingCarServiceimpl;
import com.lnsf.service.impl.UserdaoServiceimpl;

public class UserView {
	static Car car= new Car();
	static Flower flower = new Flower();
	static FlowerdaoServiceimpl fd = new FlowerdaoServiceimpl();
	static ArrayList<Car> listCar = new ArrayList<Car>();
	static FlowerController fcon = new FlowerController();
	static Marketdaoimpl md = new Marketdaoimpl();
	static ShoppingController  shopping =  new ShoppingController();
	static UserController uc = new UserController();
	public static void userView(User user){
		int flag;
		Scanner in = new Scanner(System.in);
		while(true){				
			System.out.println("---1.买花  ---2.个人信息  ---3.历史订单 ---4.退出");
			flag = selectFlag();
			if(flag == 4) break;;
			
			switch(flag){
			case 1 :
				System.out.println("---1.选购花 ---2.搜索花 ---3.花榜");
				flag = selectFlag();
				if(flag == 1){    
					fcon.printAllFlower();
					while(true){
					System.out.println("---1.购买 ---2.查看购物车 ---3.查看所有花 ---4.返回");
					flag = selectFlag();
					if(flag == 4) break;
					switch(flag){
					case 1 :					
							
						uc.userInsertCar(listCar);//选花进购物车
		
					break;
					case 2 :
						while(true){
							if(listCar.isEmpty()){ System.out.println("您的购物车是空的");break;}
							else{
						uc.userSelectCar(listCar);
						System.out.println("---1.移除商品 ---2.修改 ---3.支付 ---4.返回");
						flag = selectFlag();
						if(flag == 4) break;
						
						switch(flag){
						case 1:
							System.out.println("输入要删除的花（Id或名字）:");
							shopping.delectForCar(in.next(), listCar);//调用移出方法
							break;
						case 2:
							shopping.updateCar(listCar);						
							break;
						case 3:
							MarketController mk = new MarketController();
							mk.payCar(user, listCar);
							
							break;
						default:
							System.out.println("您输入的数字有误,请重新输入!");
						
						            }
					     	}
						}
						break;
					case 3:
						fcon.printAllFlower();
						break;
					  default:
						System.out.println("您输入的数字有误,请重新输入!");
						}
					}
					}
			else if(flag == 2){
						System.out.println("输入花名或Id：");
						Flower f =fcon.findOneFlower(in.next());
						if(f.getFname() != null){
						System.out.println("          花Id   名字          单价         库存");
						System.out.println(f);}else System.out.println("该花不存在！");
					}
						else if(flag == 3){//看花榜
						System.out.println("---1.查看销售榜 ---2.查看热售榜");
						flag = selectFlag();
						if(flag==1){
							System.out.println("排名    花名    销售量");
							fcon.flowerAmountRanking();
						}else{
							System.out.println("排名    花名    购买人数");
							fcon.flowerRanking();
						}
						}
					break;			
			case 2 ://------------------------------------------更新用户--------------------
				
					 uc.updateUser(user); 
				break;
				
			case 3://--------------------------------------------查看订单--------------------
				
				uc.selectMarketByUserid(user.getUserid());
				System.out.println("---1.查看订单  ---2.退单 ---3.返回");
				flag = selectFlag();
				if(flag == 1){
					System.out.println("输入查找的订单号：");					
					uc.findIntendByMid(selectFlag(),user.getUserid());
				}else if(flag == 2){
					System.out.println("输入订单号：");
					Marketdaoimpl md = new Marketdaoimpl();
					if(md.delectMarket(user, in.nextInt())){System.out.println("退款成功");}
					else System.out.println("输入有误或订单号不存在");;
				}
				else System.err.println("输入指令有误！");
				break;
		    case 4:	    
		        System.out.println("欢迎再次使用本系统!");
			    break;
			default :
				System.out.println("您输入的数字有误,请重新输入!");
			
			
		}
		
	}
	

}
	
	public static int selectFlag(){
		
		Scanner in = new Scanner(System.in);
		String flag = in.next();
		String regex = "[0-9]*";
		if(flag.matches(regex))	{return Integer.parseInt(flag);}
		
		return 10;
		
	}
}
