package 기출;

import java.util.Scanner;

public class 퇴사_14501 {
	static int N;
	static int[] T;
	static int[] P;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = new int[N];
		P = new int[N];
		
		for(int i=0; i<N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		//여기까지가 입력 완료
		
		//알고리즘
		for(int i=0; i<N; i++) {
			if(i+T[i]<=N) //제일 처음 시작을 잡아주면은
				dfs(i, P[i]); //그 시작부터 dfs를 통해서 내가 가능한 모든 경우의 수를 탐색
		}
		// 0 1 2 3 4 .....
		// 모든 탐색을 하게 되서 최대값을
		System.out.println(max);
	}
	
	static int max = 0;
	private static void dfs(int idx, int sum) {
		// 탈출문
		//상담을 다 했는데, N을 넘어가게 되면은
		//상담을 못해도 총 내가 겪은 일수가 N을 넘어가게 되면은
		if(idx+ T[idx]>= N) {
			
			//max값 바꿔주는 거고
			if(max < sum)
				max = sum;
			return;
		}
		
		//idx + T[idx]
		//i는 내가 상담을 시작하는 날짜야 
		//idx == 0
		//T[0] == 3
		//idx + 3 상담을 해야되기 때문에 그 사이에 있는 날짜들에는 상담X
		for(int i=idx+T[idx]; i<N; i++) {
			if(i+T[i]<=N)
				dfs(i,sum+P[i]); //돈을 받을 수 있어
				//sum(돈) + P[i]
			else
				dfs(i,sum); //돈을 받을 수 없어
				//N일을 넘어간다
				//상담을 완료X
				//돈은 더이상 추가되지 않는다
		}
	}
}
	