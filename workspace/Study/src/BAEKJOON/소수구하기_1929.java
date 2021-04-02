package BAEKJOON;

import java.util.Scanner;

public class 소수구하기_1929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean check[] = new boolean[N+1];
		
		check[0] = true; check[1] = true;
		for(int i=2; i<=N; i++) {
			if(check[i] == true)
				continue;
			else {
				for(int j=i*2; j<=N; j+=i) {
					if( j%i== 0)
						check[j] = true;
				}
			}
		}
		
		for(int i=M; i<check.length; i++) {
			if(check[i] == false)
				System.out.println(i);
		}
	}

}
