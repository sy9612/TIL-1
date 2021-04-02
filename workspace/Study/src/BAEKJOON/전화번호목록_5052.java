package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class 전화번호목록_5052 {
	static class Trie {

		static class Node {
			// 개수
			int cnt;
			HashMap<Character, Node> childTrie;

			/*
			 * 초기화 알파벳인경우 26자리
			 */
			Node() {
				childTrie = new HashMap<>();
				cnt = 0;
			}
		}

		Node root = new Node();
		
		/*
		 * 삽입
		 */
		void insert(String numbers) {

			Node cur = this.root;
			for (int i = 0; i < numbers.length(); i++) {
				//numbers의 i번째 값이 존재하지 않을 때, 새로운 Node 생성 (Lambda)
				cur = cur.childTrie.computeIfAbsent(numbers.charAt(i), c -> new Node());
			}
			cur.cnt++;
		}
		
		boolean search(String number) {
			Node cur = this.root;
			for (int i = 0; i < number.length(); i++) {
				if(cur.cnt != 0) return false;
				cur = cur.childTrie.get(number.charAt(i));
			}
			
			return true;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		TC:
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			Trie phonebook = new Trie();
			String[] numbers = new String[N];
			for (int i = 0; i < N; i++) {
				String number = br.readLine();
				numbers[i] = number;
				phonebook.insert(number);
			}
			
			for (int i = 0; i < N; i++) {
				if(!phonebook.search(numbers[i])) {
					System.out.println("NO");
					continue TC;
				}
			}
			
			System.out.println("YES");

		}
	}
}
