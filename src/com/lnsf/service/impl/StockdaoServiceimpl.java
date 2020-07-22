package com.lnsf.service.impl;

import java.util.ArrayList;

import com.lnsf.dao.impl.StockIndentdaoimpl;
import com.lnsf.dao.impl.Stockdaoimpl;
import com.lnsf.model.Car;
import com.lnsf.model.Stock;
import com.lnsf.model.StockIndent;
import com.lnsf.service.StockdaoService;

public class StockdaoServiceimpl implements StockdaoService {
	
	 Stockdaoimpl sto = new Stockdaoimpl();

	 @Override
	public ArrayList<Stock> findAllStock(String month) {
		 
		 int countAll = 0;
		 ArrayList<Stock> list = new ArrayList<Stock>();
		list = sto.findAllStock();
		 for (int i = list.size() - 1;i >=0 ;i--) {
			String str = list.get(i).getSdate();
			int endStr = list.get(i).getSdate().indexOf("月");
			str = str.substring(0, endStr+1);
			if(!str.equals(month)){
				list.remove(list.get(i));
			}else{
				countAll = countAll+list.get(i).getSprice();
			}
			
		}
		 System.out.println(month+"进货总支出："+countAll+"元");
		return list;
	}
	 
	 @Override
	public ArrayList<Stock> findAllStock() {
		
		return sto.findAllStock();
	}
	 
	@Override
	public boolean flowerStock(ArrayList<Car> list) {
		
		return sto.flowerStock(list);
	}
	
	@Override
	public ArrayList<Car> findIntendBySid(int sid) {

		StockIndentdaoimpl std = new StockIndentdaoimpl();
		ArrayList<Car> indentList = new ArrayList<Car>();
		
		if(sto.selectStockBySid(sid).isEmpty()){
			System.out.println("该订单号不存在!");
		}else{	
			indentList = std.findIndentBySid(sid);
		}
		
		return indentList;
		
	}
	
	
	
}
