package Text;

import java.util.Scanner;

public class Text29 {

	public static void main(String[] args) {
		String[] names = new String[4];// ������
		String[] dishMegs = new String[4];// ������Ʒ��Ϣ
		int[] times = new int[4];// �Ͳ�ʱ��
		String[] addresses = new String[4];// �Ͳ͵�ַ
		int[] states = new int[4];// ����״̬ 0.��Ԥ�� 1.�����
		double[] sumPrices = new double[4];// �ܽ��

		// ��ʼ��2��������Ϣ
		names[0] = "����";
		dishMegs[0] = "������˿ 2��";
		times[0] = 12;
		addresses[0] = "���·207��";
		states[0] = 1;
		sumPrices[0] = 76.0;

		names[1] = "����";
		dishMegs[1] = "���մ��� 2��";
		times[1] = 18;
		addresses[1] = "���·207��";
		states[1] = 0;
		sumPrices[1] = 45.0;

		// �������塣һ���Ʒ��Ϣ
		String[] dishNames = { "���մ���", "������˿", "ʱ������" };
		// ��Ʒ����
		double[] prices = { 38.0, 20.0, 10.0 };
		// ������
		int[] praiseNums = new int[3];

		Scanner input = new Scanner(System.in);
		int num = -1;// ��¼�û����������
		do {
			System.out.println("*********************");
			System.out.println("1.��Ҫ����");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ǩ�ն���");
			System.out.println("4.ɾ������");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("*********************");
			System.out.println("��ѡ��");
			int choose = input.nextInt();

			boolean isAdd = false;// true:��¼�ҵ�һ��Ϊ�յ�λ�ã�false:û���ҵ�
			switch (choose) {
			case 1:
				// 1.��Ҫ����
				System.out.println("*********��Ҫ����*********");
				System.out.print("�����붩����������");
				String name = input.next();
				for (int i = 0; i < names.length; i++) {
					if (names[i] == null) {
						isAdd = true;// ��¼���ҵ�һ��Ϊ�յ�λ��
						System.out.println("���\t�˵�\t����\t������");
						for (int j = 0; j < dishNames.length; j++) {
							String price = prices[j] + "Ԫ";
							String pralse = praiseNums[j] + "��";
							System.out.println((j + 1) + "\t" + dishNames[j] + "\t" + price + "\t" + pralse);
						}
						System.out.print("��������Ҫ��Ĳ�Ʒ��ţ�");
						int dishNo = input.nextInt();
						System.out.print("����������Ҫ�ķ�����");
						int number = input.nextInt();
						String dishMeg = dishNames[dishNo - 1] + "" + number + "��";
						System.out.print("�������Ͳ�ʱ�䣨�Ͳ�ʱ����10����20��������Ͳͣ���");
						int time = input.nextInt();
						if (time < 10 || time > 20) {
							System.out.print("�Բ���������������������10-20���������");
							time = input.nextInt();
						}
						System.out.print("�������Ͳ͵�ַ��");
						String address = input.next();
						// �����ܽ��
						double sumPrice = prices[dishNo - 1] * number;
						// �Ͳͷѣ����ͷѴﵽ50Ԫʱ����5Ԫ�Ͳͷ�
						double deliCharge = sumPrice >= 50 ? 0 : 5;

						// ��ʾ������Ϣ
						System.out.println("���ͳɹ���");
						System.out.println("���Ķ��ǣ�" + dishMeg);
						System.out.println("�����ˣ�" + name);
						System.out.println("�Ͳ�ʱ�䣺" + time + "��");
						System.out.println("�Ͳ͵�ַ��" + address);
						System.out.println(
								"�ͷ�:" + sumPrice + ",�Ͳͷѣ�" + deliCharge + "Ԫ���ܼƣ�" + (sumPrice + deliCharge) + "Ԫ");

						// ��������
						names[i] = name;
						dishMegs[i] = dishMeg;
						times[i] = time;
						addresses[i] = address;
						sumPrices[i] = sumPrice + deliCharge;
						break;
					}
				}
				if (!isAdd) {
					System.out.println("�Բ������Ĳʹ�����");
				}
				break;
			case 2:
				// 2.�鿴�ʹ�
				System.out.println("*********�鿴�ʹ�*********");
				System.out.println("���\t������\t��Ʒ��Ϣ\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t�ܽ��\t����״̬");
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null) {
						String stat = (states[i] == 0) ? "��Ԥ��" : "�����";
						String time = times[i] + "��";
						String sumPrice = sumPrices[i] + "Ԫ";
						System.out.println((i + 1) + "\t" + names[i] + "\t" + dishMegs[i] + "\t" + time + "\t"
								+ addresses[i] + "\t" + "\t" + sumPrice + "\t" + stat);
					}
				}
				break;
			case 3:
				// 3.ǩ�ն���
				System.out.println("*********ǩ�ն���*********");
				System.out.println("������Ҫǩ�յĶ�����ţ�");
				int signOrderId = input.nextInt();
				boolean isFind = false;// ��¼�Ƿ��ҵ�������������true�����ҵ���false��û���ҵ�
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null && states[i] == 1 && signOrderId == i + 1) {
						System.out.println("�Բ�����ѡ��Ķ����Ѿ����ǩ�գ������ٴ�ǩ�գ�");
						isFind = true;
						break;
					} else if (names[i] != null && states[i] == 0 && signOrderId == i + 1) {
						System.out.println("����ǩ�ճɹ���");
						states[i] = 1;
						isFind = true;
						break;
					}
				}
				if (!isFind) {
					System.out.println("�Բ��𣬴˶���������");
				}
				break;
			case 4:
				// 4.ɾ������
				System.out.println("*********ɾ������*********");
				boolean isDelFind = false;
				System.out.println("������Ҫɾ���Ķ�����ţ�");
				int delld = input.nextInt();
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null && states[i] == 1 && delld == i + 1) {
						isDelFind = true;
						// ɾ����������ɾ��λ�ú��Ԫ����ǰ��һλ
						for (int j = delld - 1; j < names.length - 1; j++) {
							names[j] = names[j + 1];
							dishMegs[j] = dishMegs[j + 1];
							times[j] = times[j + 1];
							addresses[j] = addresses[j + 1];
							states[j] = states[j + 1];
							sumPrices[j] = sumPrices[j + 1];
						}
						// ���һ�����
						int endIndex = names.length - 1;
						names[endIndex] = null;
						dishMegs[endIndex] = null;
						times[endIndex] = 0;
						addresses[endIndex] = null;
						states[endIndex] = 0;
						sumPrices[endIndex] = 0;
						System.out.println("ɾ�������ɹ���");
					} else if (names[i] != null && states[i] == 0 && delld == i + 1) {
						System.out.println("��ѡ��Ķ���δǩ�գ�����ɾ����");
						isDelFind = true;
						break;
					}

				}
				if (!isDelFind) {
					System.out.println("��Ҫɾ���Ķ��������ڣ�");
				}
				break;
			case 5:
				// 5.��Ҫ����
				System.out.println("*********��Ҫ����*********");
				System.out.println("���\t����\t����\t������");
				for (int i = 0; i < dishNames.length; i++) {
					String price = prices[i] + "Ԫ";
					String praiseNum = (praiseNums[i]) > 0 ? praiseNums[i] + "��" : "";
					System.out.println((i + 1) + "\t" + dishNames[i] + "\t" + price + "\t" + praiseNum);
				}
				System.out.println("��ѡ����Ҫ���޵Ĳ�Ʒ��ţ�");
				int praiseNum = input.nextInt();
				praiseNums[praiseNum - 1]++;
				System.out.println("���޳ɹ���");
				break;
			case 6:
				// 6.�˳�ϵͳ
				System.out.println("*********�˳�ϵͳ*********");
				break;
			default:
				break;
			}
			// ���û�����Ĺ��ܱ��Ϊ1-5֮��������ʱ���˳�ѭ�����������ʾ����0����
			if (choose < 1 || choose > 5) {
				break;
			} else {
				System.out.println("����0����");
				num = input.nextInt();
			}
		} while (num == 0);
		System.out.println("ллʹ�ã���ӭ�´ι��٣�");
	}

}
