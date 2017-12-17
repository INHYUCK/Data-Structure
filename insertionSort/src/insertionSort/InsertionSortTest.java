package insertionSort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("학생수 입력: ");
		int n = scan.nextInt();
		
		Student[] students = new Student[n];
		for(int i = 0; i < n; ++i) {
			students[i] = new Student();
			System.out.print(i + 1 + "번째 학생 입력\n");
			System.out.print("학번: ");
			students[i].studentNum = scan.nextInt();
			System.out.print("나이: ");
			students[i].age = scan.nextInt();
		}
		
		System.out.println("정렬전 저장된 학생배열 원소 모두 출력");
		for(int i = 0; i < n; ++i) {
			System.out.println(students[i].toString());
		}
		
		insertionSort(students, n); //삽입 정렬
		
		System.out.println("\n정렬후 저장된 학생배열 원소 모두 출력");
		for(int i = 0; i < n; ++i) {
			System.out.println(students[i].toString());
		}
		
	}

	private static void insertionSort(Student[] students, int num) {
		Student temp = null;
		int i, j;
		
		for(i = 1; i < num; ++i) {
			temp = students[i];
			
			for(j = i; (j > 0 && students[j-1].age > temp.age); --j) {
				students[j] = students[j-1];
			}
			students[j] = temp;
		}
		
	}

}












