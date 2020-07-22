package com.lnsf.service;

import java.util.ArrayList;

import com.lnsf.model.Car;
import com.lnsf.model.Flower;

public interface FlowerdaoService {

	ArrayList<String> flowerRanking();//最受欢迎的花排名
	ArrayList<String> flowerAmountRanking();//销售排名
	 ArrayList<Flower> findAllFlower();//查找全部花信息
	Flower findFlowerByName(String fname);//根据名字找花
	Flower findFlowerById(int fid);//根据id找花
	int insertInFlower(Flower f);//增加新花
	int updateFlower(Flower f);
	boolean deleteFlower(int fid);
}
