package linkedList;

public class LinkedList {
	private Node head;

	private int size;

	public LinkedList() {
		head = null;
		size = 0;
	}

	// 리스트의 맨 앞에 item을 삽입
	public void addFirst(int item) {
		Node newNode = new Node(item);
		newNode.link = head;
		head = newNode;
		size++;
	}

	// 리스트의 크기(길이)
	public int size() {
		return size;
	}

	// 리스트 원소들 모두 출력
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

	// 리스트에서 item이 저장된 노드를 탐색
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

	// 첫번째 원소를 삭제하고 원소값을 리턴
	public int removeFirst() {
		if (head == null) {
			throw new RuntimeException("Error : 리스트가 비어있음");
		}
		int temp = head.data;
		head = head.link;
		size--;
		return temp;
	}
	
	// 정수값을 매개변수로 받아 검색 결과(boolean 값)를 리턴
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
			throw new RuntimeException("Error : 잘못된 인덱스 입력");
		Node newNode = new Node(item);

		if (head == null) {
			head = newNode;
			size++;
			return;
		}

		Node nextNode = head; // 삽입할 자리에 위치한 노드(삽입후에는 새원소 바로 다음에 위치함)
		Node preNode = null; // 삽입할 값의 이전노드

		for (int i = 0; i < index; ++i) {
			preNode = nextNode;
			nextNode = nextNode.link;
		}

		if (preNode == null) { // 첫번째 원소에 삽입
			newNode.link = head;
			head = newNode;
			size++;
			return;
		}

		if (nextNode == null) { // 마지막 원소에 삽입
			preNode.link = newNode;
			size++;
			return;
		}

		// 중간에 삽입
		newNode.link = nextNode;
		preNode.link = newNode;
		size++;
	}

	public int remove(int index) {
		if (size == 0) {
			throw new RuntimeException("Error : 리스트가 비어있음");
		}
		if (index < 0 || index >= size) {
			throw new RuntimeException("Error : 잘못된 인덱스 입력");
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

	// 사용자로부터 x, y를 입력받아 리스트의 첫번째 x 뒤에 y를 삽입
	public int add1(int x, int y) {

		Node newNode = new Node(y); //삽입할 노드
		Node xNode = this.searchNode(x); // 해당노드 탐색
		if (xNode == null) //찾지 못한 경우
			return -1;
		newNode.link = xNode.link;
		xNode.link = newNode;
		size++;
		return 0;
	}

	// 사용자로부터 x를 입력받아 리스트의 첫번째 x를 삭제
	public int remove1(int x) {

		if (head == null) {
			throw new RuntimeException("Error : 리스트가 비어있음");
		}

		if (head.data == x) { //첫번째 원소인 경우
			this.removeFirst();
			size--;
			return 0;
		}
		
		Node removeNode = head; //삭제할 노드
		Node preNode = null; //삭제할 노드 이전 노드
		
		while (removeNode != null) {
			if (removeNode.data == x)
				break;
			preNode = removeNode;
			removeNode = removeNode.link;
		}

		if (removeNode == null) //x값을 찾지 못한경우
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