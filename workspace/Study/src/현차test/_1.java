package 현차test;

import java.util.LinkedList;


public class _1 {
	static int maps[][] = { 
			{ 0, 0, 1, 0, 0 }, 
			{ 0, 1, 1, 0, 1 },
			{ 0, 0, 1, 0, 1 },
			{ 1, 1, 1, 0, 1 } };
	static int maps2[][] = { { 1, 0, 1, 1 }, { 0, 0, 1, 1 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 } };

	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static int maps_len[][];

	public static void main(String[] args) {
		solution(maps);
	}

	static boolean check[][];

	static class Node {
		int i;
		int j;

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		};
	}

	public static int solution(int[][] maps) {
		check = new boolean[maps.length][maps[0].length];
		int maps_len[][] = new int[maps.length][maps.length];
		int result = 0;
		
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length; j++) {
				if (check[i][j] == false && maps[i][j] == 1) {
					Node buf = new Node(i, j);
					int a[] = bfs(maps, buf);
					int a1 = a[2]-a[0];
					if(a1 == 0)
						a1 = 1;
					int a2 = a[3]-a[1];
					if(a2 == 0)
						a2 = 1;
					
					int b = Math.abs(a1)*2 + Math.abs(a2)*2;
					result += b;
				}
			}
		}
		System.out.println(result);
		for (int i = 0; i < maps_len.length; i++) {
			for (int j = 0; j < maps_len.length; j++) {
				System.out.print(maps_len[i][j] + " ");
			}
			System.out.println();
		}

		return result;
	}

	private static int[] bfs(int[][] map, Node buf) {
		// TODO Auto-generated method stub
		int rr = 0;
		int rrr = Integer.MAX_VALUE;
		int cc = 0;
		int ccc = Integer.MAX_VALUE;
		LinkedList<Node> q = new LinkedList<>();
		check[buf.i][buf.j] = true;
		q.add(buf);
		while (!q.isEmpty()) {
			Node ndot = q.poll();
			if(rrr>ndot.i) rrr = ndot.i;
			if(ccc>ndot.j) ccc = ndot.j;
			if(rr<ndot.i)rr = ndot.i;
			if(cc<ndot.j)cc = ndot.j; 
			
			for (int i = 0; i < 4; i++) {
				int r = ndot.i + dr[i];
 				int c = ndot.j + dc[i];

				if (IsIn(map,r,c) && check[r][c] == false && map[r][c] == 1) {
					check[r][c] = true;
					Node n = new Node(r, c);
					q.add(n);
				}
			}
		}

		int result[] = {rr,cc, rrr, ccc};
		return result;
	}
	
	private static boolean IsIn(int[][] arr, int r, int c) {
		if (r < 0 || c < 0 || r >= arr.length || c >= arr[r].length)
			return false;
		else
			return true;
	}
}
