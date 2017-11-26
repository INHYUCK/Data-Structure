package circularQueue;

import java.util.NoSuchElementException;

public class CircularQueue {
	
	int[] array;
	int size;
	int front, rear;
	
	public CircularQueue(int size) {
		this.size = size;
		array = new int[size];
		front = 0;
		rear = 0;
	}
	
	public boolean isEmpty() {
		return front == rear;
	}
	
	public boolean isFull() {
		return (rear + 1)%size == front;
	}
	
	public void enQueue(int value) {
		if(isFull()) { 
			System.out.println("배열이 가득차서 저장할 수 없습니다.");
			return;
		}
		rear = (rear+1)%size;
		array[rear] = value;
	}
	
	public int deQueue() {
		if(isEmpty()) throw new NoSuchElementException();
		front = (front + 1)%size;
		return array[front];
	}
	
	
}

