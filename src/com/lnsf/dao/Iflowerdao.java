package com.lnsf.dao;

import java.util.ArrayList;

import com.lnsf.model.Car;
import com.lnsf.model.Flower;

public interface Iflowerdao {
   
	abstract ArrayList<Flower> findAllFlower();//查找全部花信息
	abstract Flower findFlowerByName(String fname);//根据名字找花
	abstract int insertInFlower(Flower f);//增加新花
	abstract int updateFlower(Flower f);//更新花信息
	boolean deleteFlower(int _fid);//下架花
	ArrayList<String> flowerRanking();//最受欢迎的花排名
	ArrayList<String> flowerAmountRanking();//销售排名
	ArrayList<Car> findFlowerIdentMax(String month);//某月最大销量
	ArrayList<Car> findFlowerAmountMax(String month);
}
