package BAEKJOON;

import java.util.LinkedList;
import java.util.Scanner;

public class 타노스_20310 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		LinkedList<Character> ll = new LinkedList<>();

		int zero = 0;
		int one = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0')
				zero++;
			else
				one++;
			
			ll.add(s.charAt(i));
			
		}

		zero /= 2;
		one /= 2;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1' && one != 0) {
				one--;
				for (int j = 0; j < ll.size(); j++) {
					if(ll.get(j) == '1') {
						ll.remove(j);
						break;
					}
				}
			} 
			
			if (s.charAt(s.length() - i - 1) == '0' && zero != 0) {
				zero--;
				for (int j = ll.size()-1; j >=0; j--) {
					if(ll.get(j) == '0') {
						ll.remove(j);
						break;
					}
				}
			}
		}

		for (int i = 0; i < ll.size(); i++) {
			System.out.print(ll.get(i));
		}
	}
}
