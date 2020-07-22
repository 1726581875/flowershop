package com.lnsf.dao;

import java.util.ArrayList;

import com.lnsf.model.Car;
import com.lnsf.model.Flower;

public interface Iflowerdao {
   
	abstract ArrayList<Flower> findAllFlower();//����ȫ������Ϣ
	abstract Flower findFlowerByName(String fname);//���������һ�
	abstract int insertInFlower(Flower f);//�����»�
	abstract int updateFlower(Flower f);//���»���Ϣ
	boolean deleteFlower(int _fid);//�¼ܻ�
	ArrayList<String> flowerRanking();//���ܻ�ӭ�Ļ�����
	ArrayList<String> flowerAmountRanking();//��������
	ArrayList<Car> findFlowerIdentMax(String month);//ĳ���������
	ArrayList<Car> findFlowerAmountMax(String month);
}
