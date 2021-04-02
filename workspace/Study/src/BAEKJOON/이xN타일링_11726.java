package BAEKJOON;

import java.util.Scanner;

public class 이xN타일링_11726 {
	static int[] d;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		d = new int[N + 1];
		if(N == 1)
		{
			System.out.println(1);
			return;
		}
		
		d[0] = 0;
		d[1] = 1;
		
		d[2] = 2;
		
		for(int i=3; i<N+1; i++) {
			d[i] = (d[i-2] + d[i-1])%10007;
		}
		
		System.out.println(d[N]);
	}

}
