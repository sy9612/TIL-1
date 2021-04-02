package Practice.JavaFile;
import java.util.Scanner;

public class 총잡이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			int R = sc.nextInt();
			int C = sc.nextInt();
			String map[][] = new String[R][C];

			int gun[][] = new int[R * C][2];
			int gun_cnt = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = sc.next();
					if (map[i][j].equals("G")) {
						gun[gun_cnt][0] = i;
						gun[gun_cnt][1] = j;
						gun_cnt++;
					}
				}
			}

			int dr[] = { 1, -1, 0, 0 };
			int dc[] = { 0, 0, 1, -1 };

			int result = 0;

			int max = Math.max(R, C);
			for (int i = 0; i < gun_cnt; i++) {

				L: for (int j = 0; j < 4; j++) {
					int sign = 0;
					for (int k = 1; k < max+1; k++) {
						int r = gun[i][0] + (dr[j] * k);
						int c = gun[i][1] + (dc[j] * k);

						if (r >= 0 && c >= 0 && r < R && c < C) {
							if (map[r][c].equals("T") && sign == 0) {
								result++;
								sign = 1;
								map[r][c] = "A";
							} else if (!map[r][c].equals("0")) {
								break;
							}
							else if(map[r][c].equals("T") && sign == 1) {
								continue L;
							}
						}
						else
							break;
					}
				}

			}
			System.out.println(result);
		}

	}

}
