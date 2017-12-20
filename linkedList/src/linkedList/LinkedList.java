package linkedList;

public class LinkedList {
	private Node head;

	private int size;

	public LinkedList() {
		head = null;
		size = 0;
	}

	// ����Ʈ�� �� �տ� item�� ����
	public void addFirst(int item) {
		Node newNode = new Node(item);
		newNode.link = head;
		head = newNode;
		size++;
	}

	// ����Ʈ�� ũ��(����)
	public int size() {
		return size;
	}

	// ����Ʈ ���ҵ� ��� ���
	public void printList() {
		Node temp = head;
		System.out.print("[");
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.link;
			if (temp != null)
				System.out.print(", ");
		}
		System.out.println("]");
	}

	// ����Ʈ���� item�� ����� ��带 Ž��
	private Node searchNode(int item) {
		Node temp = head;
		while (temp != null) {
			if (item == temp.data)
				return temp;
			else
				temp = temp.link;
		}
		return temp;
	}

	// ù��° ���Ҹ� �����ϰ� ���Ұ��� ����
	public int removeFirst() {
		if (head == null) {
			throw new RuntimeException("Error : ����Ʈ�� �������");
		}
		int temp = head.data;
		head = head.link;
		size--;
		return temp;
	}
	
	// �������� �Ű������� �޾� �˻� ���(boolean ��)�� ����
	public boolean contains(int num) {
		Node temp = head;
		while (temp != null) {
			if (temp.data == num)
				return true;
			temp = temp.link;
		}
		return false;
	}

	public void add(int index, int item) {
		if (index < 0 || index > size)
			throw new RuntimeException("Error : �߸��� �ε��� �Է�");
		Node newNode = new Node(item);

		if (head == null) {
			head = newNode;
			size++;
			return;
		}

		Node nextNode = head; // ������ �ڸ��� ��ġ�� ���(�����Ŀ��� ������ �ٷ� ������ ��ġ��)
		Node preNode = null; // ������ ���� �������

		for (int i = 0; i < index; ++i) {
			preNode = nextNode;
			nextNode = nextNode.link;
		}

		if (preNode == null) { // ù��° ���ҿ� ����
			newNode.link = head;
			head = newNode;
			size++;
			return;
		}

		if (nextNode == null) { // ������ ���ҿ� ����
			preNode.link = newNode;
			size++;
			return;
		}

		// �߰��� ����
		newNode.link = nextNode;
		preNode.link = newNode;
		size++;
	}

	public int remove(int index) {
		if (size == 0) {
			throw new RuntimeException("Error : ����Ʈ�� �������");
		}
		if (index < 0 || index >= size) {
			throw new RuntimeException("Error : �߸��� �ε��� �Է�");
		}

		if (index == 0) {
			return removeFirst();
		}

		Node removeNode = head;
		Node preNode = null;

		for (int i = 0; i < index; ++i) {
			preNode = removeNode;
			removeNode = removeNode.link;
		}

		int temp = removeNode.data;
		preNode.link = removeNode.link;
		size--;
		return temp;

	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node temp = head;
		if (temp == null)
			return "[]";

		while (temp.link != null) {
			sb.append(temp.data + ", ");
			temp = temp.link;
		}
		sb.append(temp.data + "]");

		return sb.toString();
	}

	// ����ڷκ��� x, y�� �Է¹޾� ����Ʈ�� ù��° x �ڿ� y�� ����
	public int add1(int x, int y) {

		Node newNode = new Node(y); //������ ���
		Node xNode = this.searchNode(x); // �ش��� Ž��
		if (xNode == null) //ã�� ���� ���
			return -1;
		newNode.link = xNode.link;
		xNode.link = newNode;
		size++;
		return 0;
	}

	// ����ڷκ��� x�� �Է¹޾� ����Ʈ�� ù��° x�� ����
	public int remove1(int x) {

		if (head == null) {
			throw new RuntimeException("Error : ����Ʈ�� �������");
		}

		if (head.data == x) { //ù��° ������ ���
			this.removeFirst();
			size--;
			return 0;
		}
		
		Node removeNode = head; //������ ���
		Node preNode = null; //������ ��� ���� ���
		
		while (removeNode != null) {
			if (removeNode.data == x)
				break;
			preNode = removeNode;
			removeNode = removeNode.link;
		}

		if (removeNode == null) //x���� ã�� ���Ѱ��
			return -1;
 
		preNode.link = removeNode.link;
		size--;
		return 0;
	}

	private class Node {
		int data;
		Node link;

		Node() {
			data = 0;
			link = null;
		}

		Node(int data) {
			this.data = data;
			this.link = null;
		}

		Node(int data, Node link) {
			this.data = data;
			this.link = link;
		}
	}
}