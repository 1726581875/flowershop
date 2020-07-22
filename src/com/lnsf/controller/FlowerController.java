package com.lnsf.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.lnsf.model.Flower;
import com.lnsf.service.impl.FlowerdaoServiceimpl;

public class FlowerController {
    
	FlowerdaoServiceimpl flower = new FlowerdaoServiceimpl();
	
	public void printAllFlower(){
		
		
		ArrayList<Flower> list = flower.findAllFlower();
		System.out.println("         花编号       花名     单价      库存余量");
		for (Flower flower : list) {
			System.out.println(flower);
		}
	}
		
		public Flower findOneFlower(String str){
			
			return flower.findFlower(str);		
		}
		
		public void  flowerRanking(){
			ArrayList<String> ranking = new ArrayList<String>();
			ranking = flower.flowerRanking();
			for (String string : ranking) {
				System.out.println(string);
			}
			
		}
		public void  flowerAmountRanking(){
				
			ArrayList<String> ranking = new ArrayList<String>();
			ranking = flower.flowerAmountRanking();
			for (String string : ranking) {
				System.out.println(string);
			}
				
}
		
		
		public void insertInFlower() {
			Flower f = new Flower();
			flower.insertInFlower(f);			
		}	
		
		public void updateFlower(){
			Scanner in = new Scanner(System.in);
			Flower f = new Flower();
			System.out.println("---1.修改花名 ---2.修改单价  ---3.修改库存");
			int flag =  selectFlag();
			switch(flag){
			case 1:
				System.out.println("输入fid：");
				String fid = in.next();
				f = flower.findFlower(fid);
				System.out.println("输入修改后的名字：");
				f.setFname(in.next());
				if(flower.updateFlower(f) == 1) System.out.println("更新成功！");
				else System.out.println("更新失败！");
				break;
			case 2:
				System.out.println("输入fid：");
				 fid = in.next();
				f = flower.findFlower(fid);
				System.out.println("输入修改后的单价：");
				f.setFprice(in.nextInt());
				if(flower.updateFlower(f) == 1) System.out.println("更新成功！");
				else System.out.println("更新失败！");
				break;
			case 3:
				System.out.println("输入fid：");
				 fid = in.next();
				f = flower.findFlower(fid);
				System.out.println("输入修改后的库存：");
				f.setFamount(in.nextInt());
				if(flower.updateFlower(f) == 1) System.out.println("更新成功！");
				else System.out.println("更新失败！");
				break;
			default:
				System.err.println("输入指令有误！");
			}
			
			
		}
	
		public void deleteFlower(int fid){		
			flower.deleteFlower(fid);
		}
	
		public static int selectFlag() {
	        int a = 0;
			Scanner in = new Scanner(System.in);
			String flag = in.next();
			String regex = "[0-9]*";
			if (flag.matches(regex)) {
				return Integer.parseInt(flag);
			}

			return a;

		}
		
}
