package com.lnsf.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.lnsf.model.Flower;
import com.lnsf.service.impl.FlowerdaoServiceimpl;

public class FlowerController {
    
	FlowerdaoServiceimpl flower = new FlowerdaoServiceimpl();
	
	public void printAllFlower(){
		
		
		ArrayList<Flower> list = flower.findAllFlower();
		System.out.println("         �����       ����     ����      �������");
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
			System.out.println("---1.�޸Ļ��� ---2.�޸ĵ���  ---3.�޸Ŀ��");
			int flag =  selectFlag();
			switch(flag){
			case 1:
				System.out.println("����fid��");
				String fid = in.next();
				f = flower.findFlower(fid);
				System.out.println("�����޸ĺ�����֣�");
				f.setFname(in.next());
				if(flower.updateFlower(f) == 1) System.out.println("���³ɹ���");
				else System.out.println("����ʧ�ܣ�");
				break;
			case 2:
				System.out.println("����fid��");
				 fid = in.next();
				f = flower.findFlower(fid);
				System.out.println("�����޸ĺ�ĵ��ۣ�");
				f.setFprice(in.nextInt());
				if(flower.updateFlower(f) == 1) System.out.println("���³ɹ���");
				else System.out.println("����ʧ�ܣ�");
				break;
			case 3:
				System.out.println("����fid��");
				 fid = in.next();
				f = flower.findFlower(fid);
				System.out.println("�����޸ĺ�Ŀ�棺");
				f.setFamount(in.nextInt());
				if(flower.updateFlower(f) == 1) System.out.println("���³ɹ���");
				else System.out.println("����ʧ�ܣ�");
				break;
			default:
				System.err.println("����ָ������");
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
