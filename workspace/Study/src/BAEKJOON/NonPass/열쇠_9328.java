package BAEKJOON.NonPass;

import java.util.*;

public class 열쇠_9328 {
	static int H, W;
	static char[][] map;
	static HashSet<Character> key;

	static class Node {
		int i;
		int j;
		HashSet<Character> kclone;

		Node(int i, int j, HashSet<Character> kclone) {
			this.i = i;
			this.j = j;
			this.kclone = kclone;
		};
	}
	
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H+2][W+2];
			for (int i = 1; i <= H; i++) {
				String st = sc.next();
				for (int j = 1; j <= W; j++) {
					map[i][j] = st.charAt(j);
				}
			}

			String k = sc.next();
			key = new HashSet<>();

			if (!k.equals("0")) {
				for (int i = 0; i < k.length(); i++) {
					key.add(k.charAt(i));
				}
			}
			
			//열쇠 구하기
			
			//
			
			
		}
		
	}
	private static boolean IsIn(char[][] arr, int r, int c) {
		if (r < 0 || c < 0 || r >= arr.length || c >= arr[r].length)
			return false;
		else
			return true;
	}
}
