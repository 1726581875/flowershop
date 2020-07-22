package com.lnsf.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.lnsf.controller.FlowerController;
import com.lnsf.controller.ManagerController;
import com.lnsf.controller.ShoppingController;
import com.lnsf.controller.UserController;
import com.lnsf.model.Car;
import com.lnsf.model.Flower;
import com.lnsf.model.User;

public class ManagerView {
	static ShoppingController shopping = new ShoppingController();
	static ArrayList<Car> listCar = new ArrayList<Car>();
	static FlowerController fcon = new FlowerController();
	static UserController ucon = new UserController();
	static ManagerController mcon = new ManagerController();
	static Flower f = new Flower();
	static User u = new User();

	public static void managerView(User user) {
		System.out.println("这是管理员页面");
		int flag;
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out
					.println("---1.管理鲜花  ---2.管理进货  ---3.查看全部订单 ---4.统计财务 ---5.管理用户---6.退出");
			flag = selectFlag();
			if (flag == 6) break;
			switch (flag) {
			// 管理鲜花
			case 1:
				while (true) {
					System.out.println("---1.查看所有花 ---2.按花名/花编号查找 ---3.修改鲜花---4.下架鲜花---5.查看销量---6.返回");
					flag = selectFlag();
					if (flag == 6) break;
					switch (flag) {
					// 1.查看所有花
					case 1:
						System.out.println("所有鲜花如下");
						fcon.printAllFlower();
						break;
					// 2.按花名查找
					case 2:
						System.out.println("输入查找的鲜花名字：");
						String str = in.next();
						System.out.println("您要查找的鲜花如下");
						f = fcon.findOneFlower(str);
						if(f.getFname() != null){
						System.out.println("          花Id   名字          单价         库存");
						System.out.println(f);}else System.out.println("该花不存在！");
						break;
					// 4.修改鲜花
					case 3:
							fcon.updateFlower();
						break;
					// 5.删除鲜花
					case 4:
						System.out.println("请输入要删除的fid/名字：");
						String fid = in.next();
						Flower fw = fcon.findOneFlower(fid);
						fcon.deleteFlower(fw.getFid());			
						break;
					// 6.查看销量
					case 5:
						System.out.println("---1.查看销售榜 ---2.查看热售榜---3.返回");
						flag = selectFlag();
						if (flag == 1) {
							System.out.println("排名    花名    销售量");
							fcon.flowerAmountRanking();
						}
						else if (flag == 2) {
							System.out.println("排名    花名    购买人数");
							fcon.flowerRanking();
						}
						else if (flag == 3)
							break;
						else{
							System.out.println("输入有误！");
						}
						break;

					default:
						System.out.println("您输入的数字有误,请重新输入!");
					}
				}
				break;
				// 管理进货
			case 2:
				fcon.printAllFlower();
				while (true) {
					System.out.println("---1.进货 ---2.查看进货列表 ---3.返回");
					flag = selectFlag();
					if (flag == 3)
						break;
					switch (flag) {
					case 1:

						mcon.ManagerAddInCar(listCar);// 进货花

						break;
					case 2:
						while (true) {
							if(listCar.isEmpty()){ System.out.println("您的进货列表是空的！");break;}
							else{
							ucon.userSelectCar(listCar);
							System.out
									.println("---1.移除商品 ---2.修改 ---3.支付 ---4.返回");
							flag = selectFlag();
							if (flag == 4)
								break;

							switch (flag) {
							case 1:
								System.out.println("输入要删除的花（Id或名字）:");
								shopping.delectForCar(in.next(), listCar);// 调用移出方法
								break;
							case 2:
								shopping.updateCar(listCar);
								break;
							case 3:
								mcon.flowerStock(listCar);// 付钱

								break;
							default:
								System.out.println("您输入的指令有误,请重新输入!");

							}
						}
						}
						break;
					 default:
						System.out.println("您输入的指令有误,请重新输入!");
					}
				}

				break;
			// 管理订单
			case 3:
				while (true) {
					System.out.println("---1.查看用户订单  ---2.查看进货订单  ---3.返回");
					flag = selectFlag();
					if (flag == 3)
						break;

					switch (flag) {
					case 1:
						mcon.selectAllMarket();
						System.out.println("---1.查看订单  ---2.返回");
						flag = selectFlag();
						if (flag == 1) {
							System.out.println("输入查找的订单号：");
							mcon.findIntendByMid(selectFlag());
						} else if (flag == 2) {

						} else
							System.out.println("输入有误！");
						break;
					case 2:
						mcon.findAllStock();
						System.out.println("---1.查看订单  ---2.返回");
						flag = selectFlag();
						if (flag == 1) {
							System.out.println("输入查找的订单号：");
							mcon.findIntendBySid(selectFlag());
						} else if (flag == 2) {

						} else
							System.err.println("输入指令有误！");
						break;
					default:
						System.out.println("您输入的数字有误,请重新输入!");
					}
				}
				break;
			// ----------------------------------统计财务begin-------------------------------
			case 4:
				while (true) {
					System.out.println("---1.查看月收入  ---2.查看月支出 ---3.月盈亏 ---4.返回");
					flag = selectFlag();
					if (flag == 4)
						break;
					switch (flag) {
					case 1:
						System.out.println("输入月份：");
						int m = selectFlag();
						String month = "2019年" + m + "月";
						mcon.selectAllMarket(month);
						break;
					case 2:
						System.out.println("输入月份：");
						m = selectFlag();
						month = "2019年" + m + "月";
						mcon.findAllStock(month);
						break;
					case 3:
						System.out.println("输入月份：");
						m = selectFlag();
						month = "2019年" + m + "月";
						mcon.statistics(month);
						break;
					default:
						System.err.println("输入格式有误！");

					}
				}
				break;
			// --------------------------------统计财务end---------------------------------
			// 管理用户
			case 5:
				while (true) {
					System.out
							.println("---1.查看所有用户  ---2.按用户名查找用户  ---3.返回");
					flag = selectFlag();
					if (flag == 3)
						break;
					switch (flag) {
					// 1.查看所有用户
					case 1:
						System.out.println("所有用户如下");
						ArrayList<User> list = new ArrayList<User>();
						list = ucon.selectAllUser();
						for (User u : list) {
							System.out.println(u);
						}
						break;
					// 2.按用户名查找用户
					case 2:
						System.out.println("输入查找的用户名字：");
						String username = in.next();
						System.out.println("您要查找的用户信息如下");
						u = ucon.selectByName(username);
						System.out.println(u);
						break;
					
					default:
						System.err.println("您输入的指令有误,请重新输入!");
					}
				}
				break;
			default:
				System.err.println("您输入的指令有误,请重新输入!");
			}
		}

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
