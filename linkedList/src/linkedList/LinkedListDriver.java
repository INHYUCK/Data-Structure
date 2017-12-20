package linkedList;

import java.util.Scanner;

public class LinkedListDriver {
	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		
		Scanner scan = new Scanner(System.in);

		System.out.println("메뉴 번호를 입력하세요.");
		int menu = 0;
		int item = 0;
		int index = 0;
		int x = 0, y = 0;
		int removeNum = 0;

		do {
			System.out.print("1:리스트출력 2:맨앞삽입 3:맨앞삭제 4:검색 5:인덱스삽입 6:인덱스삭제 7:x뒤에y삽입 8:x삭제 9:종료 --->");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				System.out.println("리스트출력을 수행합니다.");
				System.out.println(list);
				break;
			case 2:
				System.out.println("맨앞삽입을 수행합니다.");
				System.out.print("삽입할 정수 입력:");
				item = scan.nextInt();
				list.addFirst(item);
				break;
			case 3:
				System.out.println("맨앞삭제를 수행합니다.");
				System.out.println("삭제한 원소 = " + list.removeFirst());
				break;
			case 4:
				System.out.println("검색을 수행합니다.");
				System.out.print("검색할 정수 입력:");
				item = scan.nextInt();
				if (list.contains(item))
					System.out.println("검색 성공");
				else
					System.out.println("검색 실패");
				break;
			case 5:
				System.out.println("인덱스삽입을 수행합니다.");
				System.out.print("인덱스 입력:");
				index = scan.nextInt();
				System.out.print("삽입할 정수 입력:");
				item = scan.nextInt();
				list.add(index, item);
				break;
			case 6:
				System.out.println("인덱스삭제를 수행합니다.");
				System.out.print("인덱스 입력:");
				index = scan.nextInt();
				System.out.println("삭제한 원소 = " + list.remove(index));
				break;
			case 7 :
				System.out.println("x, y를 입력받아 리스트의 첫번째 x 뒤에 y를 삽입합니다.(x가 없으면 삽입하지 않음)");
				System.out.print("x : ");
				x = scan.nextInt();
				System.out.print("y : ");
				y = scan.nextInt();
				if(list.add1(x, y) == -1)
					System.out.println("x값을 찾을 수 없습니다.");
				break;
			case 8 :
				System.out.println("x를 입력받아 리스트의 첫번째 x를 삭제합니다.(x가 없으면 삭제하지 않음)");
				System.out.print("x : ");
				x = scan.nextInt();
				removeNum = list.remove1(x);
				if(removeNum == -1)
					System.out.println("x가 존재하지 않습니다.");
				else if(removeNum == 0)
					System.out.println("삭제 완료");
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("메뉴 번호 오류: 메뉴를 다시 선택하세요.");
			}
		} while (menu != 9);
	}
}