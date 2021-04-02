package BAEKJOON;

import java.util.LinkedList;
import java.util.Scanner;

class dot4 {
	int i;
	int j;

	dot4(int i, int j) {
		this.i = i;
		this.j = j;
	};
}

public class 토마토_7576 {
	static LinkedList<dot4> q = new LinkedList<>();
	static int M;
	static int N;
	static boolean check[][];
	static int map[][];
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		map = new int[N][M];
		check = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				
				if(map[i][j] == 1) {
					dot4 b = new dot4(i, j);
					q.add(b);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && check[i][j] == false) {
					dot4 buf = new dot4(i, j);
					bfs(buf);

				} else if (map[i][j] == -1 && check[i][j] == false) {
					check[i][j] = true;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				else if(map[i][j] > result)
					result = map[i][j];
			}
		}

		System.out.println(result-1);
	}

	private static void bfs(dot4 buf) {
		check[buf.i][buf.j] = true;
		int dr[] = { 1, -1, 0, 0 };
		int dc[] = { 0, 0, 1, -1 };

		q.add(buf);
		
		while (!q.isEmpty()) {
			int sign = 0;
			dot4 bb = q.poll();
			for (int i = 0; i < 4; i++) {
				int r = bb.i + dr[i];
				int c = bb.j + dc[i];

				if (r >= 0 && c >= 0 && r < N && c < M && map[r][c] == 0 && check[r][c] == false) {
					map[r][c] = map[bb.i][bb.j]+1;
					dot4 b = new dot4(r, c);
					sign++;
					q.add(b);
				}
			}

		}
		

		return;
	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
