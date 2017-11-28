package doublyLinkedList;

public class DoublyLinkedList {

	private Node head; // 리스트의 첫번째 노드를 가리킬 변수
	private int count; // 리스트의 원소 수를 나타내는 변수

	public DoublyLinkedList() {
		head = null;
		count = 0;
	}

	// 리스트 길이를 리턴
	public int size() {
		return count;
	}

	// 리스트의 맨 앞에 item을 삽입
	public void addFirst(int item) {

		// (1) 데이터가 item인 새로운 노드 생성
		Node newNode = new Node(item);

		// (2) 새로운 노드를 리스트의 맨 앞에 삽입
		if (head == null)
			head = newNode;
		else {
			newNode.rlink = head;
			head.llink = newNode;
			head = newNode;
		}
		// (3) 원소 수 1 증가
		count++;
	}

	// 리스트가 양방향연결이 제대로 이루어졌는지 확인
	public void printLink() {
		if (head == null) {
			System.out.println("공백리스트임");
		} else {
			// 리스트를 순방향으로 출력
			Node temp = head;
			System.out.print("리스트 길이=" + count + " 순방향 링크: ");
			while (temp.rlink != null) {
				System.out.print(temp.data + "->");
				temp = temp.rlink;
			}
			System.out.print(temp.data);

			// 리스트를 역방향으로 출력
			System.out.print(" 역방향 링크: ");
			while (temp.llink != null) {
				System.out.print(temp.data + "->");
				temp = temp.llink;
			}
			System.out.println(temp.data);
		}
	}
	
	//리스트 맨앞 원소를 삭제하고 반환
	public int removeFirst() {
		if(head == null) {
			throw new RuntimeException("Error: 빈리스트");
		}
		
		int temp = head.data;
		head = head.rlink;
		if(head != null) //head == null인경우 llink를 null값으로 변경해줄 필요가 없다.
			head.llink = null;
		count--;
		
		return temp;
	}
	
	//사용자로부터 정수값을 입력받아, 리스트에서 삭제(없으면 삭제 실패, 여러개이면 가장 앞에 나온 것 삭제)
	public void remove(int item) {
		if(head == null) {
			throw new RuntimeException("Error: 빈리스트");
		}
		if(head.data == item) { //첫번째 원소를 삭제하는 경우
			removeFirst();
			count--;
			return;	
			 
		}
		
		Node removeNode = head; //삭제할 노드
		Node preNode = null; //삭제할 노드의 이전 노드
		
		while(removeNode != null) { //삭제할노드와 이전노드 찾기
			if(removeNode.data == item)
				break;
			preNode = removeNode;
			removeNode = removeNode.rlink;
		}
		
		if(removeNode == null) { //순회를 다했는데도 못찾는 경우
			System.out.println("원소가 리스트에 존재하지 않습니다.");
		   	return;
		}
		
		preNode.rlink = removeNode.rlink;
		if(removeNode.rlink != null) //삭제하려는 원소가 마지막 원소가 아닌 경우
			removeNode.rlink.llink = preNode;
		
		count--;
	}
	
	//리스트 출력
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node temp = head;
		if(temp == null) {
			sb.append("]");
			return sb.toString();
		}
				
		while(temp.rlink != null) {
			sb.append(temp.data + ", ");
			temp = temp.rlink;
		}
		sb.append(temp.data + "]");
		return sb.toString();
	}

	// 이중연결리스트 노드 구조
	private class Node {
		int data;
		Node llink;
		Node rlink;

		Node() {
			this(0, null, null);
		}

		Node(int data) {
			this(data, null, null);
		}

		Node(int data, Node llink, Node rlink) {
			this.data = data;
			this.llink = llink;
			this.rlink = rlink;
		}
	}
}

