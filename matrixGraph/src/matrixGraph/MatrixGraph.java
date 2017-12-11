package matrixGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MatrixGraph {

	private int[][] graph;
	private int n;

	public MatrixGraph(int n) {
		graph = new int[n][n];
		this.n = n;
	}

	public void addEdge(int v1, int v2) {
		if (v1 < 0 || v1 >= n || v2 < 0 || v2 >= n)
			System.out.println("���� ���� ��� ���� - �߸��� ���� ��ȣ�Դϴ�.");
		else if (graph[v1][v2] == 1)
			System.out.println("���� ���� ���� - �̹� �����ϴ� �����Դϴ�. ");
		else {
			graph[v1][v2] = 1;
			graph[v2][v1] = 1;
		}
	}

	public void printAdjacentVertices(int v1) {
		if (v1 < 0 || v1 >= n)
			System.out.println("���� ���� ��� ���� - �߸��� ���� ��ȣ�Դϴ�.");
		else {
			for (int i = 0; i < n; ++i) {
				if (graph[v1][i] == 1)
					System.out.print(i + " ");
			}
		}
	}

	//dfs ������ �̿��Ͽ� �ݺ������� ����1(��ȸ�� ���¸� ����Ʈ�� ����)
	/* public void depthFirstSearch() {
		LinkedList<Integer> searchedList = new LinkedList<Integer>(); //�̹� ��ȸ�� ���� ����Ʈ
		Stack<Integer> orderList = new Stack<Integer>(); //��ȸ ������ ��Ÿ���� ����Ʈ
		int vertex;
		
		for(int i = 0; i < n; ++i) {
			if(!searchedList.contains(i)) {
				orderList.push(i);
				while(!orderList.isEmpty()) {
					vertex = orderList.pop();
					System.out.print(vertex + " ");
					searchedList.add(vertex);
					
					for(int j = n-1; j >= 0; --j) {
						if(graph[vertex][j] == 1 && !searchedList.contains(j)) {
							if(orderList.contains(j))
								orderList.remove(Integer.valueOf(j));
							orderList.push(j);
						}
					}
					
					//System.out.println("\nsearchedList:" + searchedList.toString());
					//System.out.println("orderList:" + orderList.toString());
				}
			}	
		}
		
	}*/
	
	//dfs ������ �̿��Ͽ� �ݺ������� ����2(��ȸ�� ���¸� boolean�迭�� ����)
	public void depthFirstSearch() {
		//�湮�� ���� Ȯ�� Boolean �迭, false�� �ʱ�ȭ
		Boolean visited[] = new Boolean[n];
		for(int i = 0; i < n; ++i)
			visited[i] = false;
		Stack<Integer> orderList = new Stack<Integer>();
		int vertex; //���� �湮�� ����
		
		for(int j = 0; j < n; ++j) {
			if(visited[j] == false) {
				orderList.push(j);
				while(!orderList.isEmpty()) {
					vertex = orderList.pop();
					System.out.print(vertex + " ");
					visited[vertex] = true;
					for(int k = n-1; k >= 0; --k) {
						if(graph[vertex][k] == 1 && visited[k] == false) {
							if(orderList.contains(k))
								orderList.remove(Integer.valueOf(k));
							orderList.push(k);
						}
					}	
				}
			}
		}
		
		
		
		
	}
	
	/*//dfs ���ȣ��� ����
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
		for(int j = 0; j < n; ++j) {
			if(graph[vertex][j] == 1)
				depthFirstSearch(searchedList, j);
		}
	}*/
	
	
	//bfs Queue�� �̿��� ����
	public void breadthFirstSearch() {
		LinkedList<Integer> searchedList = new LinkedList<Integer>(); //�̹� ��ȸ�� ���� ����Ʈ
		Queue<Integer> orderList = new LinkedList<Integer>(); //��ȸ ������ ��Ÿ���� ����Ʈ
		int vertex;
		
		for(int i = 0; i < n; ++i) {
			if(!searchedList.contains(i)) {
				orderList.offer(i);
				while(!orderList.isEmpty()) {
					vertex = orderList.poll();
					System.out.print(vertex + " ");
					searchedList.add(vertex);
					for(int j = 0; j < n; ++j) {
						if(graph[vertex][j] == 1 && !searchedList.contains(j) && !orderList.contains(j)) {
							orderList.offer(j);
						}
					}
				}
			}	
		}
	}

}
