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
		System.out.println("���ǹ���Աҳ��");
		int flag;
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out
					.println("---1.�����ʻ�  ---2.�������  ---3.�鿴ȫ������ ---4.ͳ�Ʋ��� ---5.�����û�---6.�˳�");
			flag = selectFlag();
			if (flag == 6) break;
			switch (flag) {
			// �����ʻ�
			case 1:
				while (true) {
					System.out.println("---1.�鿴���л� ---2.������/����Ų��� ---3.�޸��ʻ�---4.�¼��ʻ�---5.�鿴����---6.����");
					flag = selectFlag();
					if (flag == 6) break;
					switch (flag) {
					// 1.�鿴���л�
					case 1:
						System.out.println("�����ʻ�����");
						fcon.printAllFlower();
						break;
					// 2.����������
					case 2:
						System.out.println("������ҵ��ʻ����֣�");
						String str = in.next();
						System.out.println("��Ҫ���ҵ��ʻ�����");
						f = fcon.findOneFlower(str);
						if(f.getFname() != null){
						System.out.println("          ��Id   ����          ����         ���");
						System.out.println(f);}else System.out.println("�û������ڣ�");
						break;
					// 4.�޸��ʻ�
					case 3:
							fcon.updateFlower();
						break;
					// 5.ɾ���ʻ�
					case 4:
						System.out.println("������Ҫɾ����fid/���֣�");
						String fid = in.next();
						Flower fw = fcon.findOneFlower(fid);
						fcon.deleteFlower(fw.getFid());			
						break;
					// 6.�鿴����
					case 5:
						System.out.println("---1.�鿴���۰� ---2.�鿴���۰�---3.����");
						flag = selectFlag();
						if (flag == 1) {
							System.out.println("����    ����    ������");
							fcon.flowerAmountRanking();
						}
						else if (flag == 2) {
							System.out.println("����    ����    ��������");
							fcon.flowerRanking();
						}
						else if (flag == 3)
							break;
						else{
							System.out.println("��������");
						}
						break;

					default:
						System.out.println("���������������,����������!");
					}
				}
				break;
				// �������
			case 2:
				fcon.printAllFlower();
				while (true) {
					System.out.println("---1.���� ---2.�鿴�����б� ---3.����");
					flag = selectFlag();
					if (flag == 3)
						break;
					switch (flag) {
					case 1:

						mcon.ManagerAddInCar(listCar);// ������

						break;
					case 2:
						while (true) {
							if(listCar.isEmpty()){ System.out.println("���Ľ����б��ǿյģ�");break;}
							else{
							ucon.userSelectCar(listCar);
							System.out
									.println("---1.�Ƴ���Ʒ ---2.�޸� ---3.֧�� ---4.����");
							flag = selectFlag();
							if (flag == 4)
								break;

							switch (flag) {
							case 1:
								System.out.println("����Ҫɾ���Ļ���Id�����֣�:");
								shopping.delectForCar(in.next(), listCar);// �����Ƴ�����
								break;
							case 2:
								shopping.updateCar(listCar);
								break;
							case 3:
								mcon.flowerStock(listCar);// ��Ǯ

								break;
							default:
								System.out.println("�������ָ������,����������!");

							}
						}
						}
						break;
					 default:
						System.out.println("�������ָ������,����������!");
					}
				}

				break;
			// ������
			case 3:
				while (true) {
					System.out.println("---1.�鿴�û�����  ---2.�鿴��������  ---3.����");
					flag = selectFlag();
					if (flag == 3)
						break;

					switch (flag) {
					case 1:
						mcon.selectAllMarket();
						System.out.println("---1.�鿴����  ---2.����");
						flag = selectFlag();
						if (flag == 1) {
							System.out.println("������ҵĶ����ţ�");
							mcon.findIntendByMid(selectFlag());
						} else if (flag == 2) {

						} else
							System.out.println("��������");
						break;
					case 2:
						mcon.findAllStock();
						System.out.println("---1.�鿴����  ---2.����");
						flag = selectFlag();
						if (flag == 1) {
							System.out.println("������ҵĶ����ţ�");
							mcon.findIntendBySid(selectFlag());
						} else if (flag == 2) {

						} else
							System.err.println("����ָ������");
						break;
					default:
						System.out.println("���������������,����������!");
					}
				}
				break;
			// ----------------------------------ͳ�Ʋ���begin-------------------------------
			case 4:
				while (true) {
					System.out.println("---1.�鿴������  ---2.�鿴��֧�� ---3.��ӯ�� ---4.����");
					flag = selectFlag();
					if (flag == 4)
						break;
					switch (flag) {
					case 1:
						System.out.println("�����·ݣ�");
						int m = selectFlag();
						String month = "2019��" + m + "��";
						mcon.selectAllMarket(month);
						break;
					case 2:
						System.out.println("�����·ݣ�");
						m = selectFlag();
						month = "2019��" + m + "��";
						mcon.findAllStock(month);
						break;
					case 3:
						System.out.println("�����·ݣ�");
						m = selectFlag();
						month = "2019��" + m + "��";
						mcon.statistics(month);
						break;
					default:
						System.err.println("�����ʽ����");

					}
				}
				break;
			// --------------------------------ͳ�Ʋ���end---------------------------------
			// �����û�
			case 5:
				while (true) {
					System.out
							.println("---1.�鿴�����û�  ---2.���û��������û�  ---3.����");
					flag = selectFlag();
					if (flag == 3)
						break;
					switch (flag) {
					// 1.�鿴�����û�
					case 1:
						System.out.println("�����û�����");
						ArrayList<User> list = new ArrayList<User>();
						list = ucon.selectAllUser();
						for (User u : list) {
							System.out.println(u);
						}
						break;
					// 2.���û��������û�
					case 2:
						System.out.println("������ҵ��û����֣�");
						String username = in.next();
						System.out.println("��Ҫ���ҵ��û���Ϣ����");
						u = ucon.selectByName(username);
						System.out.println(u);
						break;
					
					default:
						System.err.println("�������ָ������,����������!");
					}
				}
				break;
			default:
				System.err.println("�������ָ������,����������!");
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
