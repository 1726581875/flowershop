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
	

	//��ѯĳ�µ����붩��
	public ArrayList<Market> selectAllMarket(String month){
		
		 int countAll = 0;
		 ArrayList<Market> list = new ArrayList<Market>();
		list = market.selectAllMarket();
		 for (int i = list.size() - 1;i >=0 ;i--) {
			String str = list.get(i).getMdate();
			int endStr = list.get(i).getMdate().indexOf("��");
			str = str.substring(0, endStr+1);
			if(!str.equals(month)){
				list.remove(list.get(i));
			}else{
				countAll = countAll+list.get(i).getMprice();
			}
			
		}
		 System.out.println(month+"���������룺"+countAll+"Ԫ");
		 
		return list;
		
		
	}
	
	
	//ͳ����������
	public void statistics(String month){
		
		Flowerdaoimpl flower = new Flowerdaoimpl();
        //ͳ������
		 int countAllIn = 0;
		 ArrayList<Market> list = new ArrayList<Market>();
		list = market.selectAllMarket();
		 for (int i = list.size() - 1;i >=0 ;i--) {
			String str = list.get(i).getMdate();
			int endStr = list.get(i).getMdate().indexOf("��");
			str = str.substring(0, endStr+1);
			if(!str.equals(month)){
				list.remove(list.get(i));
			}else{
				countAllIn = countAllIn + list.get(i).getMprice();
			}
		 }
			
		//ͳ��֧��
			 Stockdaoimpl sto = new Stockdaoimpl();
			 int countAllOut = 0;
			 ArrayList<Stock> listStock = new ArrayList<Stock>();
			listStock = sto.findAllStock();
			 for (int i = listStock.size() - 1;i >= 0 ;i--) {
				   String str = listStock.get(i).getSdate();
				int end = listStock.get(i).getSdate().indexOf("��");
				str = str.substring(0, end + 1);
				if(!str.equals(month)){
					listStock.remove(listStock.get(i));
				}else{
					countAllOut = countAllOut + listStock.get(i).getSprice();
				}
			 }
		     
//			//�ҳ��������
     ArrayList<Car> listMax = flower.findFlowerIdentMax(month);
     ArrayList<Car> listMax2 = flower.findFlowerAmountMax(month);
     System.out.println("��������������������������������������������������������������������������������������������������������������");
     System.out.println();
	  if(!listMax.isEmpty())
     System.out.println(month+"��������Ļ���"+listMax.get(0).getFname()+"��һ������"+listMax.get(0).getAmount()+"��");
		if(!listMax2.isEmpty())
 System.out.println(month+"���˹���Ļ���"+listMax2.get(0).getFname()+"��һ����"+listMax2.get(0).getAmount()+"�˹���");
	  System.out.println(month+"һ��֧����"+countAllOut);
			 System.out.println(month+"һ�����룺"+countAllIn);
			 int countAll = countAllIn - countAllOut;
		 System.out.println(month+"ӯ����"+countAll);
		 System.out.println();
	     System.out.println("��������������������������������������������������������������������������������������������������������������"); 
	}
	
	@Override
	public boolean payCar(User u, ArrayList<Car> list) {
		
		return market.payCar(u, list);
	}
	
	
public ArrayList<Market> selectMarketByUserid(int userid){
		
		return market.selectMarketByUserid(userid);
	}
	

}
