package arrayList;

import java.util.Scanner;

public class ArrayListDriver {
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();

		Scanner scan = new Scanner(System.in);
		System.out.println("메뉴 번호를 입력하세요.");
		int menu = 0;
		int index = 0;
		int item = 0;
		do {
			System.out.print("1:리스트출력 2:맨뒤에 삽입 3:해당 인덱스 조회 4:해당인덱스 값 변경 5:해당 인덱스 값 삽입 6: 해당인덱스 값 삭제 7: 리스트 크기 9:종료 --->");
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				System.out.println("리스트출력을 수행합니다.");
				System.out.println(list.toString());
				break;
			case 2:
				System.out.println("맨뒤에 값을 삽입합니다.");
				System.out.print("삽입할 값 입력:");
				item = scan.nextInt();
				list.add(item);
				break;	
			case 3:
				System.out.println("인덱스를 입력받아 값을 조회합니다.");
				System.out.print("조회할 인덱스 입력:");
				index = scan.nextInt();
				System.out.println("조회된 값 = " + list.get(index));
				break;
			case 4:
				System.out.println("인덱스를 입력받아 값을 변경합니다.");
				System.out.print("변경할 인덱스 입력:");
				index = scan.nextInt();
				System.out.print("변경할 값 입력:");
				item = scan.nextInt();
				list.set(index, item);
				break;
			case 5:
				System.out.println("인덱스를 입력받아 해당인덱스에 값을 삽입합니다.");
				System.out.print("삽입할 인덱스 입력:");
				index = scan.nextInt();
				System.out.print("삽입할 값 입력:");
				item = scan.nextInt();
				list.add(index, item);
				break;
			case 6:
				System.out.println("인덱스를 입력받아 해당인덱스에 값을 삭제합니다.");
				System.out.print("삭제할 인덱스 입력:");
				index = scan.nextInt();
				item = list.remove(index);
				System.out.println("삭제한 값 = " + item);
				break;
			case 7:
				System.out.println("리스트의 크기 = " + list.size());
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("메뉴 번호 오류: 메뉴를 다시 선택하세요.");
			}
		} while(menu != 9);
	}
}
