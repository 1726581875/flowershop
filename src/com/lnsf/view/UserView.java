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
			System.out.println("---1.��  ---2.������Ϣ  ---3.��ʷ���� ---4.�˳�");
			flag = selectFlag();
			if(flag == 4) break;;
			
			switch(flag){
			case 1 :
				System.out.println("---1.ѡ���� ---2.������ ---3.����");
				flag = selectFlag();
				if(flag == 1){    
					fcon.printAllFlower();
					while(true){
					System.out.println("---1.���� ---2.�鿴���ﳵ ---3.�鿴���л� ---4.����");
					flag = selectFlag();
					if(flag == 4) break;
					switch(flag){
					case 1 :					
							
						uc.userInsertCar(listCar);//ѡ�������ﳵ
		
					break;
					case 2 :
						while(true){
							if(listCar.isEmpty()){ System.out.println("���Ĺ��ﳵ�ǿյ�");break;}
							else{
						uc.userSelectCar(listCar);
						System.out.println("---1.�Ƴ���Ʒ ---2.�޸� ---3.֧�� ---4.����");
						flag = selectFlag();
						if(flag == 4) break;
						
						switch(flag){
						case 1:
							System.out.println("����Ҫɾ���Ļ���Id�����֣�:");
							shopping.delectForCar(in.next(), listCar);//�����Ƴ�����
							break;
						case 2:
							shopping.updateCar(listCar);						
							break;
						case 3:
							MarketController mk = new MarketController();
							mk.payCar(user, listCar);
							
							break;
						default:
							System.out.println("���������������,����������!");
						
						            }
					     	}
						}
						break;
					case 3:
						fcon.printAllFlower();
						break;
					  default:
						System.out.println("���������������,����������!");
						}
					}
					}
			else if(flag == 2){
						System.out.println("���뻨����Id��");
						Flower f =fcon.findOneFlower(in.next());
						if(f.getFname() != null){
						System.out.println("          ��Id   ����          ����         ���");
						System.out.println(f);}else System.out.println("�û������ڣ�");
					}
						else if(flag == 3){//������
						System.out.println("---1.�鿴���۰� ---2.�鿴���۰�");
						flag = selectFlag();
						if(flag==1){
							System.out.println("����    ����    ������");
							fcon.flowerAmountRanking();
						}else{
							System.out.println("����    ����    ��������");
							fcon.flowerRanking();
						}
						}
					break;			
			case 2 ://------------------------------------------�����û�--------------------
				
					 uc.updateUser(user); 
				break;
				
			case 3://--------------------------------------------�鿴����--------------------
				
				uc.selectMarketByUserid(user.getUserid());
				System.out.println("---1.�鿴����  ---2.�˵� ---3.����");
				flag = selectFlag();
				if(flag == 1){
					System.out.println("������ҵĶ����ţ�");					
					uc.findIntendByMid(selectFlag(),user.getUserid());
				}else if(flag == 2){
					System.out.println("���붩���ţ�");
					Marketdaoimpl md = new Marketdaoimpl();
					if(md.delectMarket(user, in.nextInt())){System.out.println("�˿�ɹ�");}
					else System.out.println("��������򶩵��Ų�����");;
				}
				else System.err.println("����ָ������");
				break;
		    case 4:	    
		        System.out.println("��ӭ�ٴ�ʹ�ñ�ϵͳ!");
			    break;
			default :
				System.out.println("���������������,����������!");
			
			
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
