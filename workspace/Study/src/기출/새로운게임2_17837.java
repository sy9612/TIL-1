package 기출;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class 새로운게임2_17837 {
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };

	static class Node {
		int i;
		int j;
		int d;

		Node(int i, int j, int d) {
			this.i = i;
			this.j = j;
			this.d = d;
		};
	}

	static int N, K;
	static int[][] map;
	static String[][] map2;
	static Node[] horse;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		horse = new Node[K + 1];
		map2 = new String[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				map2[i][j] = "";
			}
		}

		for (int i = 1; i <= K; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			horse[i] = new Node(a, b, c);
			map2[a][b] += "" + i;
		}

		int result = 0;
		while (true) {
			if(result > 1000) {
				result = -1;
				break;
			}
			if (check())
				break;
			for (int i = 1; i <= K; i++) {

				int m = 0;
				int r = horse[i].i + dr[horse[i].d];
				int c = horse[i].j + dc[horse[i].d];

				if (IsIn(map, r, c)) {
					m = 2;
				} else {
					m = map[r][c];
				}

				StringBuilder buf = new StringBuilder();
				StringBuilder buf2 = new StringBuilder();
				boolean sign = false;
				switch (m) {
				case 0:
					for (int j = 0; j < map2[horse[i].i][horse[i].j].length(); j++) {
						if (map2[horse[i].i][horse[i].j].charAt(j)-'0' == i) {
							sign = true;
						}
						if (sign) {
							buf.append(map2[horse[i].i][horse[i].j].charAt(j));

						} else
							buf2.append(map2[horse[i].i][horse[i].j].charAt(j));
					}
					if (buf.toString().equals("")) {
						map2[r][c] += ""+map2[horse[i].i][horse[i].j];
						map2[horse[i].i][horse[i].j] = "";
					} else {
						map2[r][c] += buf.toString();
						map2[horse[i].i][horse[i].j] = buf2.toString();
					}
					break;
				case 1:
					for (int j = 0; j < map2[horse[i].i][horse[i].j].length(); j++) {
						if (map2[horse[i].i][horse[i].j].charAt(j)-'0' == i) {
							sign = true;
						}
						if (sign) {
							buf.append(map2[horse[i].i][horse[i].j].charAt(j));

						} else
							buf2.append(map2[horse[i].i][horse[i].j].charAt(j));
					}
					if (buf.toString().equals("")) {
						map2[r][c] += ""+map2[horse[i].i][horse[i].j];
						map2[horse[i].i][horse[i].j] = "";
					} else {
						map2[r][c] += buf.toString();
						map2[horse[i].i][horse[i].j] = buf2.toString();
					}

					StringBuilder bb = new StringBuilder();
					for (int j = map2[r][c].length() - 1; j >= 0; j--) {
						bb.append(map2[r][c].charAt(j));
					}

					map2[r][c] = bb.toString();
				
					break;
				case 2:

					switch (horse[i].d) {
					case 1:
						horse[i].d = 2;
						break;
					case 2:
						horse[i].d = 1;
						break;
					case 3:
						horse[i].d = 4;
						break;
					case 4:
						horse[i].d = 3;
						break;
					}
					
					int r1 = horse[i].i + dr[horse[i].d];
					int c1 = horse[i].j + dc[horse[i].d];
					
					if (!IsIn(map, r1, c1) && map[r1][c1] != 2) {
						for (int j = 0; j < map2[horse[i].i][horse[i].j].length(); j++) {
							if (map2[horse[i].i][horse[i].j].charAt(j)-'0' == i) {
								sign = true;
							}
							if (sign) {
								buf.append(map2[horse[i].i][horse[i].j].charAt(j));

							} else
								buf2.append(map2[horse[i].i][horse[i].j].charAt(j));
						}
						if (buf.toString().equals("")) {
							map2[r1][c1] += ""+map2[horse[i].i][horse[i].j];
							map2[horse[i].i][horse[i].j] = "";
						} else {
							map2[r1][c1] += buf.toString();
							map2[horse[i].i][horse[i].j] = buf2.toString();
						}
					}
					break;
				}

				for (int z = 0; z <= N; z++) {
					for (int x = 0; x <= N; x++) {
						if (map2[z][x].length() > 0) {

							for (int f = 0; f < map2[z][x].length(); f++) {
								int tt = map2[z][x].charAt(f) - '0';
								horse[tt].i = z;
								horse[tt].j = x;
							}

						}
					}
				}

			}
			result++;
		}
		System.out.println(result);
	}

	private static void print(String[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}

	private static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map2[i][j].length() >= 4) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean IsIn(int[][] arr, int r, int c) {
		if (r <= 0 || c <= 0 || r >= arr.length || c >= arr[r].length)
			return true;
		else
			return false;
	}
}
