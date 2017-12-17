package insertionSort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("�л��� �Է�: ");
		int n = scan.nextInt();
		
		Student[] students = new Student[n];
		for(int i = 0; i < n; ++i) {
			students[i] = new Student();
			System.out.print(i + 1 + "��° �л� �Է�\n");
			System.out.print("�й�: ");
			students[i].studentNum = scan.nextInt();
			System.out.print("����: ");
			students[i].age = scan.nextInt();
		}
		
		System.out.println("������ ����� �л��迭 ���� ��� ���");
		for(int i = 0; i < n; ++i) {
			System.out.println(students[i].toString());
		}
		
		insertionSort(students, n); //���� ����
		
		System.out.println("\n������ ����� �л��迭 ���� ��� ���");
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












