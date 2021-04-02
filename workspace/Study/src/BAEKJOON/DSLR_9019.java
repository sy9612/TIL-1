package BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSLR_9019 {
	static int B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int a = sc.nextInt();
			B = sc.nextInt();
			dp = new StringBuilder[10001];
			StringBuilder A = new StringBuilder();
			
			for(int i=0; i<4 ;i++) {
				int c = a%10;
				a/=10;
				A.insert(0, c);
			}
		
			bfs(A, new StringBuilder());
		}
	}

	static StringBuilder dp[];
	private static void bfs(StringBuilder A, StringBuilder com) {
		Queue<StringBuilder> q = new LinkedList<>();
		
		q.add(A);
		int a = Integer.parseInt(A.toString());
		dp[a] = com;
			
		while(!q.isEmpty()) {
			StringBuilder buf = q.poll();
			int number = Integer.parseInt(buf.toString());
			if(number == B) {
				System.out.println(dp[number].toString());
				return;
			}
			
			//D = *2
			int in = number * 2 % 10000;
			if(dp[in] == null) {
				dp[in] = new StringBuilder(dp[number]);
				dp[in].append("D");
				StringBuilder C = new StringBuilder();
				for(int i=0; i<4 ;i++) {
					int c = in%10;
					in/=10;
					C.insert(0, c);
				}
				q.add(C);
			}
			
			
			//S = -1
			if(number == 0) {
				in = 9999;
			}
			else in = number -1;
			
			if(dp[in] == null) {
				dp[in] = new StringBuilder(dp[number]);
				dp[in].append("S");
				StringBuilder C = new StringBuilder();
				for(int i=0; i<4 ;i++) {
					int c = in%10;
					in/=10;
					C.insert(0, c);
				}
				q.add(C);
			}
			
			StringBuilder left = new StringBuilder();
			//L = 왼쪽회전
			for(int i=1; i<4; i++) {
				left.append(buf.charAt(i));
			}
			left.append(buf.charAt(0));
			
			in = Integer.parseInt(left.toString());
			
			if(dp[in] == null) {
				dp[in] = new StringBuilder(dp[number]);
				dp[in].append("L");
				StringBuilder C = new StringBuilder();
				for(int i=0; i<4 ;i++) {
					int c = in%10;
					in/=10;
					C.insert(0, c);
				}
				q.add(C);
			}
			
			StringBuilder right = new StringBuilder();
			//R = 오른쪽회전
			right.append(buf.charAt(3));
			for(int i=0; i<3; i++) {
				right.append(buf.charAt(i));
			}
			in = Integer.parseInt(right.toString());
			
			if(dp[in] == null) {
				dp[in] = new StringBuilder(dp[number]);
				dp[in].append("R");
				StringBuilder C = new StringBuilder();
				for(int i=0; i<4 ;i++) {
					int c = in%10;
					in/=10;
					C.insert(0, c);
				}
				q.add(C);
			}
		}
	}
}