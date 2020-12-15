
import java.util.Arrays;
import java.util.Scanner;

public class 큰수의법칙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int k = sc.nextInt();
		
		
		int[] number = new int[N];
		
		for (int i = 0; i < N; i++) {
			number[i] = sc.nextInt();
		}
		
		Arrays.sort(number);
			
//		int now = N-1;
//		int result = 0;
//		for (int i = 0; i < M; i++) {
//			if(i != 0 && i % k == 0) {
//				if(now == N-1) {
//					now--;
//				}
//			}
//			result += number[now];
//			if(now != N-1) {
//				now++;
//			}
//		}
		
		int result = 0;
		int count = M/(k+1);
		count *= k;
		count += M % (k+1);
		
		result += count * number[N-1];
		result += (M-count) * number[N-2];
		
		
		System.out.println(result);
	}
}
