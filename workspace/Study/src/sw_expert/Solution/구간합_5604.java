package sw_expert.Solution;

import java.util.Scanner;

public class 구간합_5604 {
	static int T;
	static long A ,B;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			A = sc.nextLong();
			B = sc.nextLong();
			
			long[] ans = new long[10];
			long point = 1;
			
			while(A<=B) {
				//각 자리의 합을 구해야 함
				while(B%10 != 9 && A <= B) {
					cal(B, ans, point);
					B--;
				}
				if(B<A) {break;}
				while(A%10 != 0 && A <= B) {
					cal(A,ans,point);
					A++;
				}
			}
			A/=10;
			B/=10;
			
			for(int i=0; i<10; i++) {
				ans[i] += (B-A+1)*point;
			}
			point *= 10;
			long sum = 0;
			for(int i=0; i<10; i++) {
				sum+= (ans[i]*i);
			}
		}
		
	}
	private static void cal(long x, long[] ans, long point) {
		// TODO Auto-generated method stub
		while(x>0) {
			String s= String.valueOf(x);
			int xx = s.charAt(s.length()-1) - '0';
			ans[xx] += point;
			x /= 10;
		}
	}
}
