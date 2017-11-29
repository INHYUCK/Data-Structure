package binarySearchTree;

/*
 * BinarySearchTree ����. ���� �� ���ȣ��� ���԰� �ݺ����̿� ���� �ΰ���
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

	// p�� ��Ʈ�� �ϴ� Ʈ���� ���� ��ȸ�ϸ� Ű���� ���ڿ��� �����ϴ� �޼ҵ�(��� �˰���)
	private String inorder(Node p) {
		String result = "";
		if(p != null) {
			result += inorder(p.leftChild);
			result += p.key + " ";
			result += inorder(p.rightChild);
		}
		return result;
	}
	
	// (2) ��� ����
	public void insert(int key) { 
		root = insertKey(root, key);
	}
	
	// p�� ��Ʈ�� �ϴ� Ʈ���� key�� �����ϴ� �޼ҵ� (��� �˰���)
	private Node insertKey(Node p, int key) {
		if(p == null) {		
			Node newNode = new Node(key);
			return newNode;	
		}
		else if(key < p.key) {
			p.leftChild = insertKey(p.leftChild, key);
			return p;		// ��Ʈ �Һ�
		}
		else if(key > p.key) {
			p.rightChild = insertKey(p.rightChild, key);
			return p;		// ��Ʈ �Һ�        
		}  
		else {  // key = p.key �� ��� ���� ����
			System.out.println("Insertion fail! key duplication : " + key);
			return p;  	// ��Ʈ �Һ�
		}
	}   

	// (3) ���� ��ȸ
	public void printPostorder() {
		postorder(root);
		System.out.println();
	}

	// p�� ��Ʈ�� �ϴ� Ʈ���� ���� ��ȸ�ϸ� Ű���� ����ϴ� �޼ҵ�
	private void postorder(Node p) {
		if(p != null) {
			postorder(p.leftChild);
			postorder(p.rightChild);
			System.out.print(p.key + " ");
		}
	}
	
	// (4) �˻�
	public boolean contains(int key) {
		return containsKey(root, key);
	}
	
	// p�� ��Ʈ�� �ϴ� Ʈ���� item���� �ش��ϴ� ��带 �����ִ��� ���� ��ȯ
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
	
	// (5) �ִ� ��ȸ
	public int max() throws NoSuchElementException {
		if(root == null)
			throw new NoSuchElementException("�� Ʈ��");
		return maxKey(root);
	}
	
	// p�� ��Ʈ�� �ϴ� Ʈ���� �ִ� ��ȯ
	private int maxKey(Node p) {
		if(p.rightChild == null)
			return p.key;
		else
			return maxKey(p.rightChild);
	}
	
	// (6) �ݺ� �˰����� �̿��� ����
	public boolean add(int key) {
		return addKey(root, key);
	}
	
	// p�� ��Ʈ�� �ϴ� Ʈ���� key�� ����(���� �������� ��ȯ)
	private boolean addKey(Node p, int key) {
		if(p == null) { //��Ʈ���� ���
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
				return false; //���� ������ ���� ���Ұ� �����ϴ� ��� ���� ����
		}
		
		return true;
	}
	
	// (7) ����
	public boolean remove(int key) {
		if(root == null) //�� Ʈ���� ���
			return false;
		return removeKey(root, key, null);
	}
	
	//Ʈ������ key�� ����(���� �������� ��ȯ)
	private boolean removeKey(Node p, int key, Node parent) { //������ ��� p, ������ �� key, �������� �θ��� parent
		if(p == null) //�˻� ����
			return false;
		
		if(key < p.key)
			return removeKey(p.leftChild, key, p);
		else if(key > p.key)
			return removeKey(p.rightChild, key, p);
		
		else {
			if(parent == null) {//��Ʈ��带 �����ϴ� ��� �θ��尡 null�̱� ������ 
				parent = new Node(Integer.MAX_VALUE);
				parent.leftChild = root;
			}
			if(p.leftChild == null && p.rightChild == null) { //�ڽ��� ���� ���
				if(parent.leftChild == p) {
					if(p == root)
						root = null;
					parent.leftChild = null; 
				} else 
					parent.rightChild = null;
				
			} else if(p.leftChild != null && p.rightChild == null) { //�����ڽĸ� �ִ� ���
				if(parent.leftChild == p) {
					if(p == root) root = p.leftChild;
					else parent.leftChild = p.leftChild; 
				} else 
					parent.rightChild = p.leftChild;   
				
			} else if(p.rightChild != null && p.leftChild == null) { //�������ڽĸ� �ִ� ���
				if(parent.leftChild == p) {
					if(p == root) root = p.rightChild;
					else parent.leftChild = p.rightChild;
				} else 
					parent.rightChild = p.rightChild;
			} 
			
			else { //�ڽ��� �ΰ��� ���
				p.key = maxKey(p.leftChild);
				removeKey(p.leftChild, p.key, p);
			}
			
			return true;
		}
	}
	
	
}


