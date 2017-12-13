package bubbleSort;
//17.12.12

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSortTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("정수개수 입력: ");
		int n = scan.nextInt();
		
		int[] array = new int[n];
		System.out.print(n + "개의 정수 입력: ");
		for(int i = 0; i < n; ++i) {
			array[i] = scan.nextInt();
		}
		
		System.out.println("(정렬전)저장된 배열 원소 모두 출력 = " + Arrays.toString(array));
		
		bubbleSort(array);
		
		System.out.println("(정렬후)저장된 배열 원소 모두 출력 = " + Arrays.toString(array));
		
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

