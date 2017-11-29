package binarySearchTree;

/*
 * BinarySearchTree 구현. 삽입 시 재귀호출로 삽입과 반복문이용 삽입 두가지
 */

import java.util.NoSuchElementException;

class BinarySearchTree {
	
	Node root = null;

	private class Node {
		int key;
		Node leftChild;
		Node rightChild;
		
		public Node(int key) {
			super();
			this.key = key;
		}
	}

	@Override
	public String toString() {
		String result = inorder(root);
		return result;
	}

	// p를 루트로 하는 트리를 중위 순회하며 키값을 문자열로 리턴하는 메소드(재귀 알고리즘)
	private String inorder(Node p) {
		String result = "";
		if(p != null) {
			result += inorder(p.leftChild);
			result += p.key + " ";
			result += inorder(p.rightChild);
		}
		return result;
	}
	
	// (2) 재귀 삽입
	public void insert(int key) { 
		root = insertKey(root, key);
	}
	
	// p를 루트로 하는 트리에 key를 삽입하는 메소드 (재귀 알고리즘)
	private Node insertKey(Node p, int key) {
		if(p == null) {		
			Node newNode = new Node(key);
			return newNode;	
		}
		else if(key < p.key) {
			p.leftChild = insertKey(p.leftChild, key);
			return p;		// 루트 불변
		}
		else if(key > p.key) {
			p.rightChild = insertKey(p.rightChild, key);
			return p;		// 루트 불변        
		}  
		else {  // key = p.key 인 경우 삽입 실패
			System.out.println("Insertion fail! key duplication : " + key);
			return p;  	// 루트 불변
		}
	}   

	// (3) 후위 순회
	public void printPostorder() {
		postorder(root);
		System.out.println();
	}

	// p를 루트로 하는 트리를 후위 순회하며 키값을 출력하는 메소드
	private void postorder(Node p) {
		if(p != null) {
			postorder(p.leftChild);
			postorder(p.rightChild);
			System.out.print(p.key + " ");
		}
	}
	
	// (4) 검색
	public boolean contains(int key) {
		return containsKey(root, key);
	}
	
	// p를 루트로 하는 트리의 item값에 해당하는 노드를 갖고있는지 여부 반환
	private boolean containsKey(Node p, int key) {
		if(p != null) {
			if(key < p.key)
				return containsKey(p.leftChild, key);
			else if(key > p.key)
				return containsKey(p.rightChild, key);
			else
				return true;
		}
		return false;
	}
	
	// (5) 최댓값 조회
	public int max() throws NoSuchElementException {
		if(root == null)
			throw new NoSuchElementException("빈 트리");
		return maxKey(root);
	}
	
	// p를 루트로 하는 트리의 최댓값 반환
	private int maxKey(Node p) {
		if(p.rightChild == null)
			return p.key;
		else
			return maxKey(p.rightChild);
	}
	
	// (6) 반복 알고리즘을 이용한 삽입
	public boolean add(int key) {
		return addKey(root, key);
	}
	
	// p를 루트로 하는 트리에 key값 삽입(삽입 성공여부 반환)
	private boolean addKey(Node p, int key) {
		if(p == null) { //빈트리인 경우
			root = new Node(key);
			return true;
		}
		
		while(true) {
			if(key < p.key) {
				if(p.leftChild == null) {
					p.leftChild = new Node(key);
					break;
				}
				p = p.leftChild;
			} else if(key > p.key) {
				if(p.rightChild == null) {
					p.rightChild = new Node(key);
					break;
				}
				p = p.rightChild;
			} else
				return false; //기존 동일한 값의 원소가 존재하는 경우 삽입 실패
		}
		
		return true;
	}
	
	// (7) 삭제
	public boolean remove(int key) {
		if(root == null) //빈 트리의 경우
			return false;
		return removeKey(root, key, null);
	}
	
	//트리에서 key값 삭제(삭제 성공여부 반환)
	private boolean removeKey(Node p, int key, Node parent) { //삭제할 노드 p, 삭제할 값 key, 현재노드의 부모노드 parent
		if(p == null) //검색 실패
			return false;
		
		if(key < p.key)
			return removeKey(p.leftChild, key, p);
		else if(key > p.key)
			return removeKey(p.rightChild, key, p);
		
		else {
			if(parent == null) {//루트노드를 삭제하는 경우 부모노드가 null이기 때문에 
				parent = new Node(Integer.MAX_VALUE);
				parent.leftChild = root;
			}
			if(p.leftChild == null && p.rightChild == null) { //자식이 없는 경우
				if(parent.leftChild == p) {
					if(p == root)
						root = null;
					parent.leftChild = null; 
				} else 
					parent.rightChild = null;
				
			} else if(p.leftChild != null && p.rightChild == null) { //왼쪽자식만 있는 경우
				if(parent.leftChild == p) {
					if(p == root) root = p.leftChild;
					else parent.leftChild = p.leftChild; 
				} else 
					parent.rightChild = p.leftChild;   
				
			} else if(p.rightChild != null && p.leftChild == null) { //오른쪽자식만 있는 경우
				if(parent.leftChild == p) {
					if(p == root) root = p.rightChild;
					else parent.leftChild = p.rightChild;
				} else 
					parent.rightChild = p.rightChild;
			} 
			
			else { //자식이 두개인 경우
				p.key = maxKey(p.leftChild);
				removeKey(p.leftChild, p.key, p);
			}
			
			return true;
		}
	}
	
	
}


