package linkedStack;

public class LinkedStack {
	
	Node top; //������ ��带 ����ų ��������
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void push(int item) {
		Node newNode = new Node(item, top);
		top = newNode;
	}
	
	public int pop() throws StackEmptyException{
		if(isEmpty())
			throw new StackEmptyException("������ �������.");

		int temp = top.data;
		top = top.link;
		
		return temp;
	}
	
	public int peek() throws StackEmptyException{
		if(isEmpty())
			throw new StackEmptyException("������ �������.");
		
		return top.data;
	}
	
	private class Node {
		int data;
		Node link;
		
		public Node() {
		}
		public Node(int data) {
			this.data = data;
		}
		public Node(int data, Node link) {
			this.data = data;
			this.link = link;
		}
	}
}


