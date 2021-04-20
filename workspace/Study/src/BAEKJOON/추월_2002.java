package BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 추월_2002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		LinkedList<String> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			q.add(sc.next());
		}
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			String out = sc.next();
			
			if(q.isEmpty()) {
				break;
			}
			
			if(q.peek().equals(out)) {
				q.poll();
			}else {
				for (int j = 0; j < q.size(); j++) {
					if(q.get(j).equals(out)) {
						q.remove(j);
						result++;
						break;
					}
				}
			}
		}
		System.out.println(result);
		
	}
}
