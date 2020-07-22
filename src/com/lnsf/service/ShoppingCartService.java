package com.lnsf.service;

import java.util.ArrayList;

import com.lnsf.model.Car;

public interface ShoppingCartService {

    Car selectById(Car c,ArrayList<Car> list);
	boolean addInCar(Car c,ArrayList<Car> list);
	boolean updateCar(Car c,ArrayList<Car> list);
	boolean delectForCar(String flower, ArrayList<Car> list);
		
}
