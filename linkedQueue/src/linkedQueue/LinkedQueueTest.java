package linkedQueue;


import java.util.Scanner;

public class LinkedQueueTest {

	public static void main(String[] args) {
		LinkedQueue myQueue = new LinkedQueue();
		
		Scanner scan = new Scanner(System.in);
		int menu;
		int num;
		
		do {
			System.out.println("\n메뉴선택 1:삽입 2:삭제 3:전체삭제 4:종료");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:
				System.out.print("삽입 할 정수값: ");
				num = scan.nextInt();
				myQueue.enQueue(num);
				break;
				
			case 2:
				System.out.print("삭제된 원소: " + myQueue.deQueue());
				break;
				
			case 3:
				while(!myQueue.isEmpty())
					System.out.print(myQueue.deQueue() + " ");
				break;
			
			case 4:
				System.out.println("종료");
				break;
				
			}
			
		} while(menu != 4);
		

	}

}
