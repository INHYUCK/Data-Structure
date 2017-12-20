package linkedList;

import java.util.Scanner;

public class LinkedListDriver {
	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		
		Scanner scan = new Scanner(System.in);

		System.out.println("�޴� ��ȣ�� �Է��ϼ���.");
		int menu = 0;
		int item = 0;
		int index = 0;
		int x = 0, y = 0;
		int removeNum = 0;

		do {
			System.out.print("1:����Ʈ��� 2:�Ǿջ��� 3:�Ǿջ��� 4:�˻� 5:�ε������� 6:�ε������� 7:x�ڿ�y���� 8:x���� 9:���� --->");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				System.out.println("����Ʈ����� �����մϴ�.");
				System.out.println(list);
				break;
			case 2:
				System.out.println("�Ǿջ����� �����մϴ�.");
				System.out.print("������ ���� �Է�:");
				item = scan.nextInt();
				list.addFirst(item);
				break;
			case 3:
				System.out.println("�Ǿջ����� �����մϴ�.");
				System.out.println("������ ���� = " + list.removeFirst());
				break;
			case 4:
				System.out.println("�˻��� �����մϴ�.");
				System.out.print("�˻��� ���� �Է�:");
				item = scan.nextInt();
				if (list.contains(item))
					System.out.println("�˻� ����");
				else
					System.out.println("�˻� ����");
				break;
			case 5:
				System.out.println("�ε��������� �����մϴ�.");
				System.out.print("�ε��� �Է�:");
				index = scan.nextInt();
				System.out.print("������ ���� �Է�:");
				item = scan.nextInt();
				list.add(index, item);
				break;
			case 6:
				System.out.println("�ε��������� �����մϴ�.");
				System.out.print("�ε��� �Է�:");
				index = scan.nextInt();
				System.out.println("������ ���� = " + list.remove(index));
				break;
			case 7 :
				System.out.println("x, y�� �Է¹޾� ����Ʈ�� ù��° x �ڿ� y�� �����մϴ�.(x�� ������ �������� ����)");
				System.out.print("x : ");
				x = scan.nextInt();
				System.out.print("y : ");
				y = scan.nextInt();
				if(list.add1(x, y) == -1)
					System.out.println("x���� ã�� �� �����ϴ�.");
				break;
			case 8 :
				System.out.println("x�� �Է¹޾� ����Ʈ�� ù��° x�� �����մϴ�.(x�� ������ �������� ����)");
				System.out.print("x : ");
				x = scan.nextInt();
				removeNum = list.remove1(x);
				if(removeNum == -1)
					System.out.println("x�� �������� �ʽ��ϴ�.");
				else if(removeNum == 0)
					System.out.println("���� �Ϸ�");
				break;
			case 9:
				System.out.println("���α׷��� �����մϴ�.");
				break;
			default:
				System.out.println("�޴� ��ȣ ����: �޴��� �ٽ� �����ϼ���.");
			}
		} while (menu != 9);
	}
}