package com.lnsf.view;

import java.util.Scanner;

import com.lnsf.controller.UserController;
import com.lnsf.model.User;

public class MainView {

	           static UserController app = new UserController();
	           static User user = new User();
		public static void main(String[] args){
			int a = 0;
			Scanner in = new Scanner(System.in);
			System.out.println(" ");
			System.out.println("✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀v✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀");
			System.out.println(" _ _ _ _   __           _ _ _ _ _   __           __   _ _ _ _ _   _ _ _ _ _ _      _ _ _ _ _ _    __        __   _ _ _ _ _   _ _ _ _ _ _      ");
			System.out.println("|       | |  |         |  _ _ _  | |  |         |  | |         | |   _ _ _   |    |  _ _ _ _  |  |  |      |  | |  _ _ _  | |   _ _ _   |     ");
			System.out.println("|  — — —  |  |         | |     | | |  |   _ _   |  | |    _ _ _| |  |      | |    | |       |_|  |  |      |  | | |     | | |  |      | |     ");
			System.out.println("|  |      |  |         | |     | | |  |  |   |  |  | |   |       |  |      | |    | |            |  |      |  | | |     | | |  |      | |     ");
			System.out.println("|  |      |  |         | |     | | |  |  |   |  |  | |   |       |  |_ _ _ | |    | |            |  |      |  | | |     | | |  |_ _ _ | |     ");
			System.out.println("|  |_ _   |  |         | |     | | |  |  |   |  |  | |   |_ _ _  |   _ _ _ _ |    | |_ _ _ _ _   |  |_ _ _ |  | | |     | | |   _ _ _ _ |     ");
			System.out.println("|   _ _|  |  |         | |     | | |  |  |   |  |  | |    _ _ _| |  |_ _ _ _ _    |_ _ _ _ _  |  |   _ _ _    | | |     | | |  |              ");
			System.out.println("|  |      |  |         | |     | | |  |  |   |  |  | |   |       |   _ _ _ _  |             | |  |  |      |  | | |     | | |  |              ");
			System.out.println("|  |      |  |         | |     | | |  |  |   |  |  | |   |_ _ _  |  |       | |    _        | |  |  |      |  | | |     | | |  |              ");
			System.out.println("|  |      |  |_ _ _ _  | |_ _ _| | |  |__|   |__|  | |         | |  |       | |   | |_ _ _ _| |  |  |      |  | | |_ _ _| | |  |              ");
			System.out.println("|__|      |_ _ _ _ _ | |_ _ _ _ _| |_ _ _ _ _ _ _ _| |_ _ _ _ _| |__|       |_|   |_ _ _ _ _ _|  |__|      |__| |_ _ _ _ _| |__|              ");
			System.out.println(" ");
			System.out.println("✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀v✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀✿❀");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("--------------------------------------------------------------欢迎使用花店管理系统--------------------------------------------------------------");
//			System.out.println("❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁欢迎使用花店管理系统❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁❁");
			
			System.out.println("请选择您将要进行的操作：");
			while(true) {

			System.out.println("---1.登录   ---2.注册 ---3.退出系统");
			a = selectFlag();
			if(a == 3) {
				System.out.println();
				break;
			}
			switch(a){
				case 1 :
					int userSuper;
					User u = new User();
					System.out.println("请输入用户名和密码（格式：username password）");
					String username = in.next();
					String password = in.next();
					userSuper = app.login(username, password);
					u = app.selectByName(username);
					if(userSuper == 1){
						ManagerView.managerView(u);//权限是1，调用管理者视图
					}else if(userSuper == 2){
						UserView.userView(u);//权限是2，调用用户视图
					}
					
					break;
					
				case 2 :
					System.out.println("请输入用户名、密码、地址：");
					user.setUsername(in.next());
					user.setPassword(in.next());
					user.setAddress(in.next());
					int flag = app.register(user);
					if(flag == 1)System.out.println("注册成功，请去登录！");
									
					break;
					
				case 3 :
					System.out.println("欢迎再次使用本系统!");
					break;
					
				default :
					System.out.println("您输入的数字有误,请重新输入!");
				}
			}
		    	in.close();
		}
		
		
		
		public static int selectFlag(){
			
			Scanner in = new Scanner(System.in);
			String flag = in.next();
			String regex = "[0-9]*";
			if(flag.matches(regex))	{return Integer.parseInt(flag);}
			
			return 10;
			
		}
		
		
			
		

}
