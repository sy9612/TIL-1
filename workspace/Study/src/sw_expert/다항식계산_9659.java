package sw_expert;

import java.util.Scanner;

public class 다항식계산_9659 {
	static class Node {
		int ti;
		int ai;
		int bi;
		

		Node(int ti, int ai, int bi) {
			this.ti = ti;
			this.ai = ai;
			this.bi = bi;
		};
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			int N = sc.nextInt();
			Node[] arr = new Node[N+1];
			for(int i=2; i<=N; i++) {
				arr[i] = new Node(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
			
			int M = sc.nextInt();
			
			for(int i=0; i<M; i++) {
				long ans[] = new long[N+1];
				ans[0] = 1;
				ans[1] = sc.nextInt();
				
				for(int j=2; j<=N; j++) {
					if(arr[j].ti == 1) {
						ans[j] = ans[arr[j].ai] + ans[arr[j].bi];
					}
					else if(arr[j].ti == 2) {
						ans[j] = arr[j].ai * ans[arr[j].bi];
					}
					else if(arr[j].ti == 3) {
						ans[j] = ans[arr[j].ai] * ans[arr[j].bi];
					}
					ans[j] %= 998244353;
				}
				
				System.out.print(ans[N] + " ");
			}
			System.out.println();
		}
		
	}
}
