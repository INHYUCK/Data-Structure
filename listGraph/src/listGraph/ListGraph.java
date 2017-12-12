package listGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ListGraph {
	
	private Node[] list;
	private int n; //vertex ����
	
	public ListGraph(int n) {
		list = new Node[n];
		this.n = n;
	}
	
	public void addEdge(int v1, int v2) {
		if(v1 < 0 || v1 >= n || v2 < 0 || v2 >= n)
			System.out.println("���� ���� ��� ���� - �߸��� ���� ��ȣ�Դϴ�.");
		else if(searchNode(list, v1, v2))
			System.out.println("���� ���� ���� - �̹� �����ϴ� �����Դϴ�. ");
		else {
			list = addFristNode(list, v1, v2);
			list = addFristNode(list, v2, v1);
		}
	}
	
	public void printAdjacentVertices(int v1) {
		Node temp = list[v1];
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.link;
		}
	}
	
	public Node[] addLastNode(Node[] list, int vertex, int data) {
		Node newNode = new Node(data);
		if(list[vertex] == null)
			list[vertex] = newNode;
		else {
			Node temp = list[vertex];
			while(temp.link != null)
				temp = temp.link;
			temp.link = newNode;
		}
		
		return list;
	}
	
	public Node[] addFristNode(Node[] list, int vertex, int data) {
		Node newNode = new Node(data);
		newNode.link = list[vertex];
		list[vertex] = newNode;
		
		return list;
	}
	
	public boolean searchNode(Node[] list, int vertex, int data) {
		Node temp = list[vertex];
		while(temp != null) {
			if(temp.data == data)
				return true;
			temp = temp.link;
		}
		return false;
	}
	
	//dfs ���ȣ��� ����
	public void depthFirstSearch() {
		LinkedList<Integer> searchedList = new LinkedList<Integer>(); //�̹� ��ȸ�� ���� ����Ʈ
		
		for(int i = 0; i < n; ++i) {
			depthFirstSearch(searchedList, i);
		}
	}
	private void depthFirstSearch(LinkedList<Integer> searchedList, int vertex) {
		if(searchedList.contains(vertex))
			return;
		System.out.print(vertex + " ");
		searchedList.add(vertex);
		Node temp = list[vertex];
		while(temp != null) {
			depthFirstSearch(searchedList, temp.data);
			temp = temp.link;
		}
		
	}
	
	//bfs Queue�� �̿��� ����
	public void breadthFirstSearch() {
		LinkedList<Integer> searchedList = new LinkedList<Integer>(); //�̹� ��ȸ�� ���� ����Ʈ
		Queue<Integer> orderList = new LinkedList<Integer>(); //��ȸ ������ ��Ÿ���� ����Ʈ
		int vertex;
		Node temp;
		
		for(int i = 0; i < n; ++i) {
			if(!searchedList.contains(i)) {
				orderList.offer(i);
				while(!orderList.isEmpty()) {
					vertex = orderList.poll();
					System.out.print(vertex + " ");
					searchedList.add(vertex);
					temp = list[vertex];
					while(temp != null) {
						if(!searchedList.contains(temp.data) && !orderList.contains(temp.data)) {
							orderList.offer(temp.data);
						}
						temp = temp.link;
					}
				}
			}	
		}
	}
	
	
	
	private class Node {
		int data;
		Node link;
		
		public Node(int n) {
			this.data = n;
			link = null;
		}
		
	}
	
}
