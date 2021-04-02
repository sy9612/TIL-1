package BAEKJOON;

import java.util.Scanner;

public class 평범한배망_12865 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] product = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			product[i][0] = sc.nextInt();
			product[i][1] = sc.nextInt();
		}
		
		int max = 0;
		for(int i=0; i<(1<<N); i++) {
			//세개의 원소에 할당된 각 비트가 0인지 1인지 검사
			//0번째 비트 검사(맨 오른쪽 꺼)
			int total = 0;
			int total_p = 0;
			for(int j=0; j<N; j++) {
				if((i & (1<<j)) != 0) {
					total += product[j][0];
					total_p += product[j][1];
					System.out.print(product[j][0] + " ");
				}
			}
			System.out.println();
			
			if(total <= K) {
				max = Math.max(max, total_p);
			}
		}
		
		System.out.println(max);
		
		
	}
}
