package bubbleSort;
//17.12.12

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSortTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("�������� �Է�: ");
		int n = scan.nextInt();
		
		int[] array = new int[n];
		System.out.print(n + "���� ���� �Է�: ");
		for(int i = 0; i < n; ++i) {
			array[i] = scan.nextInt();
		}
		
		System.out.println("(������)����� �迭 ���� ��� ��� = " + Arrays.toString(array));
		
		bubbleSort(array);
		
		System.out.println("(������)����� �迭 ���� ��� ��� = " + Arrays.toString(array));
		
	}
	
	private static void bubbleSort(int[] array) {
		int n = array.length;
		for(int i = n - 1; i > 0; --i) {
			for(int j = 0; j < i; j++) {
				if(array[j] > array[j+1])
					swap(array, j, j+1);
			}
		}
	}
	
	private static void swap(int[] array, int a, int b) {
		int temp = array[b];
		array[b] = array[a];
		array[a] = temp;
	}

}

