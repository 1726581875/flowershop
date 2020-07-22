package com.lnsf.dao;

import java.util.ArrayList;

import com.lnsf.model.Car;
import com.lnsf.model.Indent;

public interface Iindentdao {
	
	
	abstract ArrayList<Indent> selectAllIndent();
	abstract boolean updateIndent(int iid,int mamount,int fid);
	abstract boolean deleteIndent(int fid);
	abstract int addIndent(Indent in);
    ArrayList<Car> findIntendByMid(int mid);
    

}
