package arrayList;

import java.util.Scanner;

public class ArrayListDriver {
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();

		Scanner scan = new Scanner(System.in);
		System.out.println("�޴� ��ȣ�� �Է��ϼ���.");
		int menu = 0;
		int index = 0;
		int item = 0;
		do {
			System.out.print("1:����Ʈ��� 2:�ǵڿ� ���� 3:�ش� �ε��� ��ȸ 4:�ش��ε��� �� ���� 5:�ش� �ε��� �� ���� 6: �ش��ε��� �� ���� 7: ����Ʈ ũ�� 9:���� --->");
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				System.out.println("����Ʈ����� �����մϴ�.");
				System.out.println(list.toString());
				break;
			case 2:
				System.out.println("�ǵڿ� ���� �����մϴ�.");
				System.out.print("������ �� �Է�:");
				item = scan.nextInt();
				list.add(item);
				break;	
			case 3:
				System.out.println("�ε����� �Է¹޾� ���� ��ȸ�մϴ�.");
				System.out.print("��ȸ�� �ε��� �Է�:");
				index = scan.nextInt();
				System.out.println("��ȸ�� �� = " + list.get(index));
				break;
			case 4:
				System.out.println("�ε����� �Է¹޾� ���� �����մϴ�.");
				System.out.print("������ �ε��� �Է�:");
				index = scan.nextInt();
				System.out.print("������ �� �Է�:");
				item = scan.nextInt();
				list.set(index, item);
				break;
			case 5:
				System.out.println("�ε����� �Է¹޾� �ش��ε����� ���� �����մϴ�.");
				System.out.print("������ �ε��� �Է�:");
				index = scan.nextInt();
				System.out.print("������ �� �Է�:");
				item = scan.nextInt();
				list.add(index, item);
				break;
			case 6:
				System.out.println("�ε����� �Է¹޾� �ش��ε����� ���� �����մϴ�.");
				System.out.print("������ �ε��� �Է�:");
				index = scan.nextInt();
				item = list.remove(index);
				System.out.println("������ �� = " + item);
				break;
			case 7:
				System.out.println("����Ʈ�� ũ�� = " + list.size());
				break;
			case 9:
				System.out.println("���α׷��� �����մϴ�.");
				break;
			default:
				System.out.println("�޴� ��ȣ ����: �޴��� �ٽ� �����ϼ���.");
			}
		} while(menu != 9);
	}
}
