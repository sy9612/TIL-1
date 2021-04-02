package BASIC._0210;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	//레벨이 3이면 2^4-1개 필요
	char[] tree;
	int root = 1;

	public BinaryTree(int maxLevel) {
		tree = new char[1<<(maxLevel+1)];
	}
	
	public void setData(char data, int node) {
		tree[node] = data;		
	}
	public  void setLeft(char data, int parent) {
		tree[parent*2] = data;
	}
	public  void setRight(char data, int parent) {
		tree[parent * 2+1] = data;
	}
	public char getLeft(int node) {
		return tree[node/2];
	}
	public char getRight(int node) {
		return tree[node/2+1];
	}
	
	public void preorder(int node) {
		if(node <tree.length && tree[node] != '\0') {
			System.out.println(tree[node]);
			preorder(node * 2);
			preorder(node * 2 + 1);
		}
	}
	public void postorder(int node) {
		if(node <tree.length && tree[node] != '\0') {
			postorder(node * 2);
			postorder(node * 2 + 1);
			System.out.println(tree[node]);
		}
	}
	public void inorder(int node) {
		if(node <tree.length && tree[node] != '\0') {
			inorder(node * 2);
			System.out.println(tree[node]);
			inorder(node * 2 + 1);
		}
	}
	
	public void levelorder(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			//왼쪽 노드가 유효하다면
			if(n*2<tree.length && tree[n*2] != '\0')
				queue.add(n*2);
			if(n*2+1<tree.length && tree[n*2+1] != '\0')
				queue.add(n*2+1);
			System.out.println(tree[n]);
		}
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(3);
		tree.setData('A',1);
		tree.setLeft('B', 1);
		tree.setRight('C', 1);

		tree.setLeft('D', 2);
		tree.setRight('E', 2);
		
		tree.setLeft('F', 3);
		tree.setRight('G', 3);
		
		tree.levelorder(1);
	}

}
