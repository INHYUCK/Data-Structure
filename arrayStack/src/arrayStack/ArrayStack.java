package arrayStack;

public class ArrayStack {
	
	int[] stack;
	int top; //꼭데기를 가리키는 인덱스
	int capacity; //스택의 크기(배열의 크기)
	
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
		if(isFull()) { //가득 찬 경우 크기를 두배로
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
			throw new StackEmptyException("스택이 비어있습니다.");
		return stack[top--];
	}
	
	public int peek() throws StackEmptyException {
		if(isEmpty())
			throw new StackEmptyException("스택이 비어있습니다.");
		return stack[top];
	}
	
}

