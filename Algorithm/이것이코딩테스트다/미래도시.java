import java.util.Arrays;
import java.util.Scanner;

public class 미래도시 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] map = new int[N + 1][N + 1];
		
		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], 987654321);
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
			map[b][a] = 1;
		} 
		
		int X = sc.nextInt();
		int K = sc.nextInt();
		
		for (int k = 1; k < N+1; k++) {
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					if(map[i][j] > map[i][k]+map[k][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		
		if(map[1][K] == 987654321 || map[K][X] == 987654321)
			System.out.println(-1);
		else
			System.out.println(map[1][K] + map[K][X]);
	}
}
