package nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;


public class _3 {
	static boolean check[][];
	private static int maxsum;
	private static int minavg;
	private static int minsum;
	private static ArrayList<Integer> minmid;
	private static int result;
	private static int gae;
	private static int maxsum2;
	static class Node {
		int i;
		int j;

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		};
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char map[][] = new char[N][N];
		check = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String st = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = st.charAt(j);
			}
		}

		 maxsum =0 ;
		 maxsum2 = 0;
		 minsum = Integer.MAX_VALUE;
		 minavg = 0;
		 minmid = new ArrayList<>();
		 result = 0;
		 
		 
		 gae=0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check[i][j] == false && map[i][j] == 'L') {
					Node buf = new Node(i, j);
					bfs(map, buf);
					gae++;
				}
			}
		}
		
		
		double avg = 0;
		if(maxsum2 == 0 || gae == 0 || gae == 1) {
			minsum =0;
			int minmid1 = 0;
			avg = 0;
			maxsum = 0;
			System.out.println(0 + " " + 0 + "  0.00"+ " " + 0);
		}
		
		else {
			
			avg = (double)(minavg-maxsum)/(double)(gae-1);
			Collections.sort(minmid);
			if((gae-1)%2 == 0) {
				int a =   minmid.get((gae-1)/2);
				int b =   minmid.get((gae-1)/2+1);
				double minmid1 = 0;
				minmid1 = (a+b)/2;
				System.out.println(maxsum2 + " " + minsum + " " + String.format("%.2f",avg) + " " + minmid1);
			}
			else {
				int minmid1 = 0;
				minmid1 = minmid.get((gae-1)/2);
				System.out.println(maxsum2 + " " + minsum + " " + String.format("%.2f",avg) + " " + minmid1);

			}
		}
		

		
	}

	private static void bfs(char[][] map, Node buf) {
		// TODO Auto-generated method stub
		LinkedList<Node> q = new LinkedList<>();
		check[buf.i][buf.j] = true;
		q.add(buf);
		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };
		int cnt = 1;
		while (!q.isEmpty()) {
			Node ndot = q.poll();
			for (int i = 0; i < 4; i++) {
				int r = ndot.i + dr[i];
				int c = ndot.j + dc[i];

				if (r >= 0 && c >= 0 && r < map.length && c < map.length && check[r][c] == false && map[r][c] == 'L') {
					check[r][c] = true;
					Node n = new Node(r, c);
					q.add(n);
					cnt ++;
				}
			}
		}
		
		if(maxsum < cnt) {
			maxsum = cnt;
		}
		if(maxsum != cnt) {
			if(maxsum2 <cnt)
				maxsum2 = cnt;
		}
		
		if(minsum > cnt) {
			minsum =cnt;
		}
		minavg += cnt;
		minmid.add(cnt);
		

	}
	private static void print(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
}
