package BAEKJOON;

import java.util.Scanner;

public class 롤케이크_3985 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();
		boolean cake_L[] = new boolean[L+1];
		int max = 0;
		int rmax = 0;
		int cmax= 0;
		int result = 0;
		
		for(int i=1; i<=N; i++) {
			int P; int K;
			P = sc.nextInt();
			K = sc.nextInt();
			
			if(max < (K-P)) {
				max = K-P;
				rmax = i;
			}

			int cake = 0;
			for(int j=P; j<=K; j++) {
				if(cake_L[j] == false) {
					cake++;
					cake_L[j] = true;
				}
			}
			
			if(cmax<cake) {
				cmax = cake;
				result = i;
			}
		}
		
		System.out.println(rmax);
		System.out.println(result);
		
		
	}

}
