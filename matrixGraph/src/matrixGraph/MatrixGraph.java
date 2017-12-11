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
			System.out.println("인접 정점 출력 오류 - 잘못된 정점 번호입니다.");
		else if (graph[v1][v2] == 1)
			System.out.println("간선 삽입 오류 - 이미 존재하는 간선입니다. ");
		else {
			graph[v1][v2] = 1;
			graph[v2][v1] = 1;
		}
	}

	public void printAdjacentVertices(int v1) {
		if (v1 < 0 || v1 >= n)
			System.out.println("인접 정점 출력 오류 - 잘못된 정점 번호입니다.");
		else {
			for (int i = 0; i < n; ++i) {
				if (graph[v1][i] == 1)
					System.out.print(i + " ");
			}
		}
	}

	//dfs 스택을 이용하여 반복문으로 구현1(순회한 상태를 리스트로 구현)
	/* public void depthFirstSearch() {
		LinkedList<Integer> searchedList = new LinkedList<Integer>(); //이미 순회한 정점 리스트
		Stack<Integer> orderList = new Stack<Integer>(); //순회 순서를 나타내는 리스트
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
	
	//dfs 스택을 이용하여 반복문으로 구현2(순회한 상태를 boolean배열로 구현)
	public void depthFirstSearch() {
		//방문한 정점 확인 Boolean 배열, false로 초기화
		Boolean visited[] = new Boolean[n];
		for(int i = 0; i < n; ++i)
			visited[i] = false;
		Stack<Integer> orderList = new Stack<Integer>();
		int vertex; //현재 방문한 정점
		
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
	
	/*//dfs 재귀호출로 구현
	public void depthFirstSearch() {
		LinkedList<Integer> searchedList = new LinkedList<Integer>(); //이미 순회한 정점 리스트
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
	
	
	//bfs Queue를 이용한 구현
	public void breadthFirstSearch() {
		LinkedList<Integer> searchedList = new LinkedList<Integer>(); //이미 순회한 정점 리스트
		Queue<Integer> orderList = new LinkedList<Integer>(); //순회 순서를 나타내는 리스트
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
