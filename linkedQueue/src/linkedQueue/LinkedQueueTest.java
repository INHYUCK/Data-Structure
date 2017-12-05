package linkedQueue;


import java.util.Scanner;

public class LinkedQueueTest {

	public static void main(String[] args) {
		LinkedQueue myQueue = new LinkedQueue();
		
		Scanner scan = new Scanner(System.in);
		int menu;
		int num;
		
		do {
			System.out.println("\n�޴����� 1:���� 2:���� 3:��ü���� 4:����");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:
				System.out.print("���� �� ������: ");
				num = scan.nextInt();
				myQueue.enQueue(num);
				break;
				
			case 2:
				System.out.print("������ ����: " + myQueue.deQueue());
				break;
				
			case 3:
				while(!myQueue.isEmpty())
					System.out.print(myQueue.deQueue() + " ");
				break;
			
			case 4:
				System.out.println("����");
				break;
				
			}
			
		} while(menu != 4);
		

	}

}
