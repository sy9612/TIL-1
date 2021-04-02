package sw_expert;
import java.util.Arrays;
import java.util.Scanner;

public class 오셀로게임_4615 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			int N = sc.nextInt();
			int M = sc.nextInt();

			int map[][] = new int[N][N];

			map[N / 2][N / 2] = 2;
			map[N / 2 - 1][N / 2 - 1] = 2;
			map[N / 2][N / 2 - 1] = 1;
			map[N / 2 - 1][N / 2] = 1;

			int[] dr = { 0, 0, 1, -1, 1, 1, -1, -1 };
			int[] dc = { 1, -1, 0, 0, 1, -1, 1, -1 };

			for (int i = 0; i < M; i++) {
				int y = sc.nextInt() - 1;
				int x = sc.nextInt() - 1;
				int dol = sc.nextInt();

//				System.out.println("x: " + x + " y: " + y);
				map[x][y] = dol;

				for (int j = 0; j < 8; j++) {
					int r = x;
					int c = y;
					boolean sign = false;
					
					while (true) {
						r = r + dr[j];
						c = c + dc[j];

						if (r >= 0 && c >= 0 && r < N && c < N) {
							if (map[r][c] == dol) {
								sign = true;
								break;
							}
							else if(map[r][c] == 0)
							{
								break;
							}
						} else
							break;
					}
					
					if (sign == true) {
						r = x;
						c = y;
						while (true) {
							r = r + dr[j];
							c = c + dc[j];
							if (map[r][c] != dol && map[r][c] != 0) {
								map[r][c] = dol;
							} 
							else if(map[r][c] == dol) {
								break;
							}
						}
					}
				}
		//		print(map);

			}
			
			int black = 0;
			int white = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 1)
						black++;
					else if(map[i][j] == 2)
						white++;
				}
			}
			
			System.out.println(black + " " + white);
		}

	}

	static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}

}
