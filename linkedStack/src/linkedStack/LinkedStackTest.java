package linkedStack;

import java.util.Scanner;
public class LinkedStackTest {

	public static void main(String[] args) throws StackEmptyException {
		// TODO Auto-generated method stub
		
		LinkedStack stack = new LinkedStack();
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		int item;
		
		do {
			System.out.print("1:���� 2:���� 3:��ȸ 4:��ü���� 5:����--->");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				System.out.println("�������� �ϳ� �Է¹޾� ���ÿ� push");
				System.out.print("������:");
				item = scan.nextInt();
				stack.push(item);
				break;
			case 2:
				System.out.println("������ pop�Ͽ� ���ϵȰ� ���");
				System.out.println("pop:" + stack.pop());
				break;
			case 3:
				System.out.println("������ peek�Ͽ� ���ϵȰ� ���");
				System.out.println("peek:" + stack.peek());
				break;
			case 4:
				System.out.println("������ �� �������� ��� pop�Ͽ� ���");
				System.out.print("pop: ");
				do {
					System.out.print(stack.pop() + " ");
				} while(stack.isEmpty() == false);
				System.out.println();
				break;
			case 5:
				System.out.println("���α׷��� �����մϴ�.");
				break;
			default:
				System.out.println("�޴� ��ȣ ����: �޴��� �ٽ� �����ϼ���.");
			}
		} while (menu != 5);
	}

}
