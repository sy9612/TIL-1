package baekjoon._0203;

import java.util.Scanner;

public class 카드2_2164_Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		//강사님 코드
		//N보다 작은 가장 큰 2의 제곱수를 찾자
		int n = 1;
		while(n<N)
			n*=2;
		n /= 2;
		if(N == 1)
			System.out.println(1);
		else
			System.out.println((N-n) * 2);
		
		//지홍코드
//		if(N == 1 ) System.out.println(1);
//		else if(N== 2) System.out.println(2);
//		else {
//			int K = 4;
//			int result =0;
//			for(int i=3; i<=N; i++) {
//				if((i-1) %K == 0) {
//					K *= 2;
//					result = 2;
//				}
//				else
//				{
//					result += 2;
//				}
//			}
//
//			System.out.println(result);
//		}
		
	}

}
