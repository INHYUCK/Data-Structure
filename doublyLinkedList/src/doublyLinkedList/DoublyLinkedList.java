package doublyLinkedList;

public class DoublyLinkedList {

	private Node head; // ����Ʈ�� ù��° ��带 ����ų ����
	private int count; // ����Ʈ�� ���� ���� ��Ÿ���� ����

	public DoublyLinkedList() {
		head = null;
		count = 0;
	}

	// ����Ʈ ���̸� ����
	public int size() {
		return count;
	}

	// ����Ʈ�� �� �տ� item�� ����
	public void addFirst(int item) {

		// (1) �����Ͱ� item�� ���ο� ��� ����
		Node newNode = new Node(item);

		// (2) ���ο� ��带 ����Ʈ�� �� �տ� ����
		if (head == null)
			head = newNode;
		else {
			newNode.rlink = head;
			head.llink = newNode;
			head = newNode;
		}
		// (3) ���� �� 1 ����
		count++;
	}

	// ����Ʈ�� ����⿬���� ����� �̷�������� Ȯ��
	public void printLink() {
		if (head == null) {
			System.out.println("���鸮��Ʈ��");
		} else {
			// ����Ʈ�� ���������� ���
			Node temp = head;
			System.out.print("����Ʈ ����=" + count + " ������ ��ũ: ");
			while (temp.rlink != null) {
				System.out.print(temp.data + "->");
				temp = temp.rlink;
			}
			System.out.print(temp.data);

			// ����Ʈ�� ���������� ���
			System.out.print(" ������ ��ũ: ");
			while (temp.llink != null) {
				System.out.print(temp.data + "->");
				temp = temp.llink;
			}
			System.out.println(temp.data);
		}
	}
	
	//����Ʈ �Ǿ� ���Ҹ� �����ϰ� ��ȯ
	public int removeFirst() {
		if(head == null) {
			throw new RuntimeException("Error: �󸮽�Ʈ");
		}
		
		int temp = head.data;
		head = head.rlink;
		if(head != null) //head == null�ΰ�� llink�� null������ �������� �ʿ䰡 ����.
			head.llink = null;
		count--;
		
		return temp;
	}
	
	//����ڷκ��� �������� �Է¹޾�, ����Ʈ���� ����(������ ���� ����, �������̸� ���� �տ� ���� �� ����)
	public void remove(int item) {
		if(head == null) {
			throw new RuntimeException("Error: �󸮽�Ʈ");
		}
		if(head.data == item) { //ù��° ���Ҹ� �����ϴ� ���
			removeFirst();
			count--;
			return;	
			 
		}
		
		Node removeNode = head; //������ ���
		Node preNode = null; //������ ����� ���� ���
		
		while(removeNode != null) { //�����ҳ��� ������� ã��
			if(removeNode.data == item)
				break;
			preNode = removeNode;
			removeNode = removeNode.rlink;
		}
		
		if(removeNode == null) { //��ȸ�� ���ߴµ��� ��ã�� ���
			System.out.println("���Ұ� ����Ʈ�� �������� �ʽ��ϴ�.");
		   	return;
		}
		
		preNode.rlink = removeNode.rlink;
		if(removeNode.rlink != null) //�����Ϸ��� ���Ұ� ������ ���Ұ� �ƴ� ���
			removeNode.rlink.llink = preNode;
		
		count--;
	}
	
	//����Ʈ ���
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

	// ���߿��Ḯ��Ʈ ��� ����
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

