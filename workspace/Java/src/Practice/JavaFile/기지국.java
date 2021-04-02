package Practice.JavaFile;
import java.util.Scanner;

public class 기지국 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			String arr[][] = new String[N][N];
			int save[][] = new int[N * N][2];
			int save_cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.next();
					if (arr[i][j].charAt(0) == 'B') {
						save[save_cnt][0] = i;
						save[save_cnt][1] = j;
						save_cnt++;
					}
				}
			}

			int dr[] = { 1, -1, 0, 0 };
			int dc[] = { 0, 0, 1, -1 };

			for (int i = 0; i < save_cnt; i++) {
				for (int j = 0; j < 4; j++) {
					int r = save[i][0] + dr[j];
					int c = save[i][1] + dc[j];

					if (r >= 0 && c >= 0 && r < N && c < N) {
						arr[r][c] = "Y";

					}
				}
			}
			int result = 0;
			for (int i1 = 0; i1 < N; i1++) {
				for (int j = 0; j < N; j++) {
					if (arr[i1][j].charAt(0) == 'X')
						result++;
				}
			}

			System.out.println("#" + tc + " " + result);

		}
	}

}
