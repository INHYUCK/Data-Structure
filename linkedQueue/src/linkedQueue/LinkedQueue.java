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
			if(isEmpty()) //큐가 비어있을 경우.
				throw new NoSuchElementException();
			
			int value = front.value;
			front = front.next;
			
			if(front == null) //하나남은 원소를 삭제한 경우
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

