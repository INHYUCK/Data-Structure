package linkedQueue;

	import java.util.NoSuchElementException;

	public class LinkedQueue {
		
		Node front;
		Node rear;
		
		public LinkedQueue() {
			front = null;
			rear = null;
		}
		
		public boolean isEmpty() {
			return (front == null && rear == null);
		}
		
		public void enQueue(int value) {
			Node newNode = new Node(value);
			if(rear == null) {
				front = newNode;
				rear = newNode;
				return;
			}
			rear.next = newNode;
			rear = newNode;
		}
		
		public int deQueue() {
			if(isEmpty()) //ť�� ������� ���.
				throw new NoSuchElementException();
			
			int value = front.value;
			front = front.next;
			
			if(front == null) //�ϳ����� ���Ҹ� ������ ���
				rear = null;
			
			return value;
			
		}
		
		private class Node {
			int value;
			Node next;
			
			public Node(int value) {
				this.value = value;
				next = null;
			}
		}
	}

