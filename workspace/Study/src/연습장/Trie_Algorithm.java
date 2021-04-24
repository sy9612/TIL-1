package 연습장;

import java.util.HashMap;

public class Trie_Algorithm {
	static class Node{
		HashMap<Character, Node> childNode;
		
		Node(){
			childNode = new HashMap<>();
		}
	}
	
	static class Trie{
		Node root = new Node();
		
		// 삽입
		void insert(String st) {
			Node cur = this.root;
			
			for (int i = 0; i < st.length(); i++) {
				if(cur.childNode.containsKey(st.charAt(i))) {
					cur = cur.childNode.get(st.charAt(i));
				}else {
				}
			}
		}
		
	}
}
