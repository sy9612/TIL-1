package sw_expert;
import java.util.*;

public class 농작물수확하기_2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int map[][] = new int[N][N];
			System.out.print("#" + tc + " ");
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}

			int cc = N / 2;
			int check[][] = new int[N][N];
			int K = 0;
			int result = 0;

			for (int i = 1; i <= cc+1; i ++) {
				for (int j = 0; j < i; j++) {
					check[K][cc + j] = 1;
					check[K][cc - j] = 1;
					result += map[K][cc + j];
					if(j!=0)
						result += map[K][cc - j];
				}
				//print(check);
				K++;
			}
			
			K=N-1;
			for (int i = 1; i <= cc; i ++) {
				for (int j = 0; j < i; j++) {
					check[K][cc + j] = 1;
					check[K][cc - j] = 1;
					result += map[K][cc + j];
					if(j!=0)
						result += map[K][cc - j];
				}
				//print(check);
				K--;
			}
			
			System.out.println(result);

		}
	}

	static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}

}