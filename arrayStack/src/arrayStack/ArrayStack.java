package arrayStack;

public class ArrayStack {
	
	int[] stack;
	int top; //�����⸦ ����Ű�� �ε���
	int capacity; //������ ũ��(�迭�� ũ��)
	
	public ArrayStack() {
		stack = new int[10];
		top = -1;
		capacity = 10;
	}
	
	public boolean isFull() {
		return top == capacity - 1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void push(int item) {
		if(isFull()) { //���� �� ��� ũ�⸦ �ι��
			int[] temp = new int[capacity * 2];
			for(int i = 0; i < capacity; ++i)
				temp[i] = stack[i];
			stack = temp;
			capacity *= 2;
		}
		stack[++top] = item;
	}
	
	public int pop() throws StackEmptyException {
		if(isEmpty())
			throw new StackEmptyException("������ ����ֽ��ϴ�.");
		return stack[top--];
	}
	
	public int peek() throws StackEmptyException {
		if(isEmpty())
			throw new StackEmptyException("������ ����ֽ��ϴ�.");
		return stack[top];
	}
	
}

