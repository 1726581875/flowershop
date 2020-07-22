package com.lnsf.service;

import java.util.ArrayList;

import com.lnsf.model.Car;
import com.lnsf.model.Flower;

public interface FlowerdaoService {

	ArrayList<String> flowerRanking();//���ܻ�ӭ�Ļ�����
	ArrayList<String> flowerAmountRanking();//��������
	 ArrayList<Flower> findAllFlower();//����ȫ������Ϣ
	Flower findFlowerByName(String fname);//���������һ�
	Flower findFlowerById(int fid);//����id�һ�
	int insertInFlower(Flower f);//�����»�
	int updateFlower(Flower f);
	boolean deleteFlower(int fid);
}
