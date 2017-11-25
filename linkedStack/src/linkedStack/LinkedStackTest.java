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
			System.out.print("1:삽입 2:삭제 3:조회 4:전체삭제 5:종료--->");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				System.out.println("정수값을 하나 입력받아 스택에 push");
				System.out.print("정수값:");
				item = scan.nextInt();
				stack.push(item);
				break;
			case 2:
				System.out.println("스택을 pop하여 리턴된값 출력");
				System.out.println("pop:" + stack.pop());
				break;
			case 3:
				System.out.println("스택을 peek하여 리턴된값 출력");
				System.out.println("peek:" + stack.peek());
				break;
			case 4:
				System.out.println("스택이 텅 빌때까지 모두 pop하여 출력");
				System.out.print("pop: ");
				do {
					System.out.print(stack.pop() + " ");
				} while(stack.isEmpty() == false);
				System.out.println();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("메뉴 번호 오류: 메뉴를 다시 선택하세요.");
			}
		} while (menu != 5);
	}

}
