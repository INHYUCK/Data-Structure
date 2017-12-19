package arrayList;

public class ArrayList {

	private int nums[]; // 정수형 배열 변수
	private int capacity; // 저장 용량
	private int size; // 배열에 저장된 정수 갯수

	public ArrayList() {
		this.nums = new int[10]; // 크기가 10인 정수 배열을 생성하여 배열 속성을 초기화
		this.capacity = 10; // 저장 용량을 10으로 초기화
		this.size = 0; // 저장된 정수 갯수를 0으로 초기화
	}

	public void add(int num) {
		if (size == capacity) { // 배열이 꽉차있는경우 => 용량 두배로 증가

			int[] temp = new int[size]; // 기존원소 임시저장 배열
			for (int i = 0; i < size; ++i) {
				temp[i] = nums[i];
			}
			capacity = capacity * 2;
			nums = new int[capacity]; // 두배용량의 새배열 참조전달
			for (int i = 0; i < size; ++i) {
				nums[i] = temp[i]; // 기존 원소 복사
			}

			System.out.println("용량 증가 " + capacity / 2 + "-->" + capacity);

		}

		nums[size++] = num;
	}

	public void print() {
		System.out.print("[");

		for (int i = 0; i < size; ++i) {
			System.out.print(nums[i]);
			if (i + 1 != size)
				System.out.print(", ");
		}

		System.out.println("]");
	}

	public int get(int index) {
		if (index >= size || index < 0)
			throw new RuntimeException("\nError : 올바르지 않은 인덱스");
		return nums[index];
	}

	public void set(int index, int num) {
		if (index >= size || index < 0)
			throw new RuntimeException("\nError : 올바르지 않은 인덱스");

		nums[index] = num;
	}

	public int size() {
		return size;
	}

	public void add(int index, int num) {
		if (index > size || index < 0)
			throw new RuntimeException("\nError : 올바르지 않은 인덱스");

		if (size == capacity) {

			int[] temp = new int[size];
			for (int i = 0; i < size; ++i) {
				temp[i] = nums[i];
			}
			capacity = capacity * 2;
			nums = new int[capacity];
			for (int i = 0; i < size; ++i) {
				nums[i] = temp[i];
			}

			System.out.println("용량 증가 " + capacity / 2 + "-->" + capacity);
		}

		for (int i = size - 1; i >= index; --i) {
			nums[i + 1] = nums[i];
		}

		nums[index] = num;
		size++;
	}

	public int remove(int index) {
		if (index >= size || index < 0)
			throw new RuntimeException("\nError : 올바르지 않은 인덱스");

		int removeNum = nums[index];

		for (int i = index + 1; i < size; ++i) {
			nums[i - 1] = nums[i];
		}

		size--;

		return removeNum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size - 1; ++i) {
			sb.append(nums[i] + ", ");
		}
		if(size != 0)
			sb.append(nums[size - 1] + "]");
		else
			sb.append("]");
		return sb.toString();
	}

}
