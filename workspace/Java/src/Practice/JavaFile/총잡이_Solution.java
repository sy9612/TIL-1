package Practice.JavaFile;
import java.util.Scanner;

public class 총잡이_Solution {
	static int N;
	static int M;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			 N = sc.nextInt();
			 M = sc.nextInt();
			char map[][] = new char[N][M];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					map[r][c] = sc.next().charAt(0);
				}
			}
			int cnt = 0;
			int dr[] = { 0, 0, 1, -1 };
			int dc[] = { 1, -1, 0, 0 };
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] == 'G') {
						for (int k = 0; k < 4; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];

							while (check(nr, nc)) {
								if(map[nr][nc] == 'W' || map[nr][nc] == 'G') {
									break;
								}
								else if(map[nr][nc] == 'T') {
									map[nr][nc] = 'X';
									break;
								}
								nr+=dr[k];
								nc+=dc[k];
							}
						}
					}
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] == 'X') {
						cnt++;
					}
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}

	}

	private static boolean check(int nr, int nc) {
		// TODO Auto-generated method stub
		if (nr >= 0 && nr < N && nc >= 0 && nc < M)
			return true;
		return false;
	}
}
