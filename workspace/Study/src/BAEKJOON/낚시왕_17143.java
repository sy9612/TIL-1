package BAEKJOON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class 낚시왕_17143 {
	static class Node {
		int r;
		int c;
		int s;
		int d;
		int z;

		Node(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int M = sc.nextInt();

		HashMap<Integer, Node> hs = new HashMap<>();

		int[][] map = new int[R + 1][C + 1];

		for (int i = 1; i < M + 1; i++) {
			int r = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			hs.put(i, new Node(r, c, sc.nextInt(), sc.nextInt(), sc.nextInt()));

			map[r][c] = i;
		}

		int result = 0;
		for (int ps = 1; ps < C; ps++) {
			
			print(map);
			for (int i = 1; i < map.length; i++) {
				if (map[i][ps] != 0) {
					result += hs.get(map[i][ps]).z;
					map[i][ps] = 0;
					break;
				}
			}

			// s 속력
			// d 1위 2아래 3오른쪽 4왼쪽
			// z 크기
			int[] dr = { 0, -1, 1, 0, 0 };
			int[] dc = { 0, 0, 0, 1, -1 };
			for (int i = 1; i <= M; i++) {
				Node b = hs.get(i);

				if (b!= null&& map[b.r][b.c] != 0) {

					for (int j = 0; j < b.s; j++) {

						Node buf = hs.get(i);
						int r = buf.r + dr[buf.d];
						int c = buf.c + dc[buf.d];

						if (IsIn(map, r, c)) {
							hs.replace(i, new Node(r, c, buf.s, buf.d, buf.z));

						} else {
							switch (buf.d) {
							case 1:
								hs.replace(i, new Node(buf.r, buf.c, buf.s, 2, buf.z));
								break;
							case 2:
								hs.replace(i, new Node(buf.r, buf.c, buf.s, 1, buf.z));
								break;
							case 3:
								hs.replace(i, new Node(buf.r, buf.c, buf.s, 4, buf.z));
								break;
							case 4:
								hs.replace(i, new Node(buf.r, buf.c, buf.s, 3, buf.z));
								break;
							}
							j--;

						}
					}
				}
			}
			
			
			LinkedList<Integer> key = new LinkedList<>();
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] != 0) {
						Node buf = hs.get(map[i][j]);
						if (map[buf.r][buf.c] == 0) {
							map[buf.r][buf.c] = map[i][j];
							map[i][j] = 0;
						}
						else {
							if(map[buf.r][buf.c] < map[i][j]) {
								Node a = hs.get(map[i][j]);
								Node b = hs.get(map[buf.r][buf.c]);
								
								if(a.z < b.z) {
									map[buf.r][buf.c] = map[i][j]; 
								}
								map[i][j] = 0;
							}
							else {
								key.add(map[i][j]);
							}
						}
					}
				}
			}
			
			while(!key.isEmpty()) {
				int k = key.poll();
				Node buf = hs.get(k);
				if(map[buf.r][buf.c] == 0 ) {
					map[buf.r][buf.c] = k;
				}
				else {
					Node a = hs.get(map[buf.r][buf.c]);
					if(buf.z > a.z) {
						map[buf.r][buf.c] = k;
					}
					else {
						key.add(k);
					}
				}
			}

		}
	}

	private static boolean IsIn(int[][] arr, int r, int c) {
		if (r < 1 || c < 1 || r >= arr.length || c >= arr[r].length)
			return false;
		else
			return true;
	}
	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
}
