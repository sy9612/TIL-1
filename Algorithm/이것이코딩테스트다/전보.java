import java.util.Arrays;
import java.util.Scanner;

public class 전보 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int C = sc.nextInt();
		
		int[][] arr = new int[N+1][N+1];
		int[] D = new int[N+1];
		Arrays.fill(D,  Integer.MAX_VALUE);

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			
			arr[x][y] = z;
		}
		
		boolean[] check = new boolean[N+1];
		D[C] = 0;
		for (int i = 1; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			for(int j=0; j<N+1; j++) {
				if(!check[j] && min > D[j]) {
					min = D[j];
					index = j;
				}
			}
			if(index == -1)break;
			for (int j = 1; j < N+1; j++) {
				if(!check[j] && arr[index][j] != 0 && D[index] + arr[index][j] < D[j])
					D[j] = D[index] + arr[index][j];
			}
			check[index] = true;
			
		}
		
		int cnt = 0;
		int max = 0;
		for (int i = 1; i < D.length; i++) {
			if(D[i] != Integer.MAX_VALUE) {
				cnt++;
				max = Math.max(D[i], max);
			}
		}
		
		System.out.println(cnt-1 + " " + max);
		
	}
}
