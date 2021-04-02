package BAEKJOON.NonPass;
import java.util.*;
public class _0과1_8111 {
	static int N;
	static int number;
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			number = 1;
			visited = new boolean[20001];
			Queue<Integer> q = new LinkedList<>();
			
			q.add(number);
			//모르겟다!
		
			while(!q.isEmpty()) {
				int num = q.poll();
				if((num*10)%N == 0)
				{
					System.out.println(num*10);
					break;
				}
				if((num*10+1)%N == 0) {
					System.out.println(num*10+1);
					break;
				}
				
				q.add((num*10+1)%N);
				
			}
		}
	}
}
