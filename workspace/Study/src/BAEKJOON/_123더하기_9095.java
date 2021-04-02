package BAEKJOON;
import java.util.*;
public class _123더하기_9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int d[] = new int[N+1];
			d[0] = 0;
			d[1] = 1;
			if(N == 1)
			{
				System.out.println(d[1]);
				continue;
			}
			d[2] = 2;
			if(N == 2) {
				System.out.println(d[2]);
				continue;
			}
			d[3] = 4;
			if(N ==3) {
				System.out.println(d[3]);
				continue;
			}
			
			for(int i=4; i<N+1; i++) {
				d[i] = d[i-1] + d[i-2] + d[i-3];
			}
			
			System.out.println(d[N]);
		}
	}
}
