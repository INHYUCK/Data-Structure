package arrayList;

public class ArrayList {

	private int nums[]; // ������ �迭 ����
	private int capacity; // ���� �뷮
	private int size; // �迭�� ����� ���� ����

	public ArrayList() {
		this.nums = new int[10]; // ũ�Ⱑ 10�� ���� �迭�� �����Ͽ� �迭 �Ӽ��� �ʱ�ȭ
		this.capacity = 10; // ���� �뷮�� 10���� �ʱ�ȭ
		this.size = 0; // ����� ���� ������ 0���� �ʱ�ȭ
	}

	public void add(int num) {
		if (size == capacity) { // �迭�� �����ִ°�� => �뷮 �ι�� ����

			int[] temp = new int[size]; // �������� �ӽ����� �迭
			for (int i = 0; i < size; ++i) {
				temp[i] = nums[i];
			}
			capacity = capacity * 2;
			nums = new int[capacity]; // �ι�뷮�� ���迭 ��������
			for (int i = 0; i < size; ++i) {
				nums[i] = temp[i]; // ���� ���� ����
			}

			System.out.println("�뷮 ���� " + capacity / 2 + "-->" + capacity);

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
			throw new RuntimeException("\nError : �ùٸ��� ���� �ε���");
		return nums[index];
	}

	public void set(int index, int num) {
		if (index >= size || index < 0)
			throw new RuntimeException("\nError : �ùٸ��� ���� �ε���");

		nums[index] = num;
	}

	public int size() {
		return size;
	}

	public void add(int index, int num) {
		if (index > size || index < 0)
			throw new RuntimeException("\nError : �ùٸ��� ���� �ε���");

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

			System.out.println("�뷮 ���� " + capacity / 2 + "-->" + capacity);
		}

		for (int i = size - 1; i >= index; --i) {
			nums[i + 1] = nums[i];
		}

		nums[index] = num;
		size++;
	}

	public int remove(int index) {
		if (index >= size || index < 0)
			throw new RuntimeException("\nError : �ùٸ��� ���� �ε���");

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
