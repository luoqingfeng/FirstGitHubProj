package Text;

import java.util.Scanner;

public class Text29 {

	public static void main(String[] args) {
		String[] names = new String[4];// 订餐人
		String[] dishMegs = new String[4];// 所定餐品信息
		int[] times = new int[4];// 送餐时间
		String[] addresses = new String[4];// 送餐地址
		int[] states = new int[4];// 订单状态 0.已预订 1.已完成
		double[] sumPrices = new double[4];// 总金额

		// 初始化2条订单信息
		names[0] = "张晴";
		dishMegs[0] = "鱼香肉丝 2份";
		times[0] = 12;
		addresses[0] = "天成路207号";
		states[0] = 1;
		sumPrices[0] = 76.0;

		names[1] = "张晴";
		dishMegs[1] = "红烧带鱼 2份";
		times[1] = 18;
		addresses[1] = "天成路207号";
		states[1] = 0;
		sumPrices[1] = 45.0;

		// 数组主体。一组餐品信息
		String[] dishNames = { "红烧带鱼", "鱼香肉丝", "时令鲜蔬" };
		// 菜品单价
		double[] prices = { 38.0, 20.0, 10.0 };
		// 点赞数
		int[] praiseNums = new int[3];

		Scanner input = new Scanner(System.in);
		int num = -1;// 记录用户输入的数字
		do {
			System.out.println("*********************");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("*********************");
			System.out.println("请选择：");
			int choose = input.nextInt();

			boolean isAdd = false;// true:记录找到一个为空的位置，false:没有找到
			switch (choose) {
			case 1:
				// 1.我要订餐
				System.out.println("*********我要订餐*********");
				System.out.print("请输入订餐人姓名：");
				String name = input.next();
				for (int i = 0; i < names.length; i++) {
					if (names[i] == null) {
						isAdd = true;// 记录已找到一个为空的位置
						System.out.println("序号\t菜单\t单价\t点赞数");
						for (int j = 0; j < dishNames.length; j++) {
							String price = prices[j] + "元";
							String pralse = praiseNums[j] + "赞";
							System.out.println((j + 1) + "\t" + dishNames[j] + "\t" + price + "\t" + pralse);
						}
						System.out.print("请输入您要点的菜品编号：");
						int dishNo = input.nextInt();
						System.out.print("请输入您需要的份数：");
						int number = input.nextInt();
						String dishMeg = dishNames[dishNo - 1] + "" + number + "份";
						System.out.print("请输入送餐时间（送餐时间是10点至20点间整点送餐）：");
						int time = input.nextInt();
						if (time < 10 || time > 20) {
							System.out.print("对不起，您的输入有误，请输入10-20间的整数：");
							time = input.nextInt();
						}
						System.out.print("请输入送餐地址：");
						String address = input.next();
						// 计算总金额
						double sumPrice = prices[dishNo - 1] * number;
						// 送餐费，当餐费达到50元时，免5元送餐费
						double deliCharge = sumPrice >= 50 ? 0 : 5;

						// 显示订单信息
						System.out.println("订餐成功！");
						System.out.println("您的订是：" + dishMeg);
						System.out.println("订餐人：" + name);
						System.out.println("送餐时间：" + time + "点");
						System.out.println("送餐地址：" + address);
						System.out.println(
								"餐费:" + sumPrice + ",送餐费：" + deliCharge + "元，总计：" + (sumPrice + deliCharge) + "元");

						// 保存数据
						names[i] = name;
						dishMegs[i] = dishMeg;
						times[i] = time;
						addresses[i] = address;
						sumPrices[i] = sumPrice + deliCharge;
						break;
					}
				}
				if (!isAdd) {
					System.out.println("对不起。您的餐袋已满");
				}
				break;
			case 2:
				// 2.查看餐袋
				System.out.println("*********查看餐袋*********");
				System.out.println("序号\t订餐人\t餐品信息\t送餐时间\t送餐地址\t\t总金额\t订单状态");
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null) {
						String stat = (states[i] == 0) ? "已预订" : "已完成";
						String time = times[i] + "点";
						String sumPrice = sumPrices[i] + "元";
						System.out.println((i + 1) + "\t" + names[i] + "\t" + dishMegs[i] + "\t" + time + "\t"
								+ addresses[i] + "\t" + "\t" + sumPrice + "\t" + stat);
					}
				}
				break;
			case 3:
				// 3.签收订单
				System.out.println("*********签收订单*********");
				System.out.println("请输入要签收的订单序号：");
				int signOrderId = input.nextInt();
				boolean isFind = false;// 记录是否找到了这条订单。true：已找到，false：没有找到
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null && states[i] == 1 && signOrderId == i + 1) {
						System.out.println("对不起，您选择的订单已经完成签收，不能再次签收！");
						isFind = true;
						break;
					} else if (names[i] != null && states[i] == 0 && signOrderId == i + 1) {
						System.out.println("订单签收成功！");
						states[i] = 1;
						isFind = true;
						break;
					}
				}
				if (!isFind) {
					System.out.println("对不起，此订单不存在");
				}
				break;
			case 4:
				// 4.删除订单
				System.out.println("*********删除订单*********");
				boolean isDelFind = false;
				System.out.println("请输入要删除的订单序号：");
				int delld = input.nextInt();
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null && states[i] == 1 && delld == i + 1) {
						isDelFind = true;
						// 删除操作，把删除位置后的元素向前移一位
						for (int j = delld - 1; j < names.length - 1; j++) {
							names[j] = names[j + 1];
							dishMegs[j] = dishMegs[j + 1];
							times[j] = times[j + 1];
							addresses[j] = addresses[j + 1];
							states[j] = states[j + 1];
							sumPrices[j] = sumPrices[j + 1];
						}
						// 最后一行清空
						int endIndex = names.length - 1;
						names[endIndex] = null;
						dishMegs[endIndex] = null;
						times[endIndex] = 0;
						addresses[endIndex] = null;
						states[endIndex] = 0;
						sumPrices[endIndex] = 0;
						System.out.println("删除订单成功！");
					} else if (names[i] != null && states[i] == 0 && delld == i + 1) {
						System.out.println("您选择的订单未签收，不能删除！");
						isDelFind = true;
						break;
					}

				}
				if (!isDelFind) {
					System.out.println("您要删除的订单不存在！");
				}
				break;
			case 5:
				// 5.我要点赞
				System.out.println("*********我要点赞*********");
				System.out.println("序号\t菜名\t单价\t点赞数");
				for (int i = 0; i < dishNames.length; i++) {
					String price = prices[i] + "元";
					String praiseNum = (praiseNums[i]) > 0 ? praiseNums[i] + "赞" : "";
					System.out.println((i + 1) + "\t" + dishNames[i] + "\t" + price + "\t" + praiseNum);
				}
				System.out.println("请选择您要点赞的菜品序号：");
				int praiseNum = input.nextInt();
				praiseNums[praiseNum - 1]++;
				System.out.println("点赞成功！");
				break;
			case 6:
				// 6.退出系统
				System.out.println("*********退出系统*********");
				break;
			default:
				break;
			}
			// 当用户输入的功能编号为1-5之外是数字时，退出循环，否则会提示输入0返回
			if (choose < 1 || choose > 5) {
				break;
			} else {
				System.out.println("输入0返回");
				num = input.nextInt();
			}
		} while (num == 0);
		System.out.println("谢谢使用，欢迎下次光临！");
	}

}
