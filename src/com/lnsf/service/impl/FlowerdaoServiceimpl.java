package com.lnsf.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.lnsf.DButils.DButil;
import com.lnsf.dao.impl.Flowerdaoimpl;
import com.lnsf.model.Car;
import com.lnsf.model.Flower;
import com.lnsf.service.FlowerdaoService;

public class FlowerdaoServiceimpl implements FlowerdaoService{

	Flowerdaoimpl flower = new Flowerdaoimpl();
	ArrayList<Flower> list = new ArrayList<Flower>();
	
	@Override
	public int insertInFlower(Flower f){
		
		
		return flower.insertInFlower(f);
	}
	

	@Override
	public ArrayList<String> flowerRanking() {
		
		return flower.flowerRanking();
	}

	@Override
	public ArrayList<String> flowerAmountRanking() {
		
		
		return flower.flowerAmountRanking();
	}

	@Override
	public ArrayList<Flower> findAllFlower() {
		
		return flower.findAllFlower();
	}

	@Override
	public Flower findFlowerByName(String fname) {
		
		return flower.findFlowerByName(fname);//调用dao层的按花名查找
	}
	
	
	//按名字或id查找
	public Flower findFlower(String flower){
		Flower f= new Flower();
		
		f = findFlowerByName(flower);
		if(f.getFname() != null) return f;
		
		String regex = "[0-9]*";
		if(flower.matches(regex)){
		f = findFlowerById(Integer.parseInt(flower));
		if(f.getFname() != null) return f;	
		}
		
		return f;
	}
	
	
	@Override
	public Flower findFlowerById(int fid) {//根据花id查单个
		Flower f = new Flower();
		list = flower.findAllFlower();//调用dao层查全部方法
		for (Flower flower : list) {
			if(flower.getFid() == fid) f = flower;
		}
		return f;
	}
	
		


	@Override
	public int updateFlower(Flower f) {
		
		return flower.updateFlower(f);
	}

	@Override
	public boolean deleteFlower(int fid) {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = flower.deleteFlower(fid);
		if(flag == false)
				System.out.println("该花不存在！"); 	
			if(flag == true)
				System.out.println("该花删除成功！");
		return flag;
	}
	
}
