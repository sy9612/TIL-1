package kakaotest;

import java.util.LinkedList;
import java.util.Queue;

public class _4 {
	public static void main(String[] args) {
		int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
		int answer = solution(board);
		System.out.println(answer);
	}
	static class Node {
		int i;
		int j;
		int m;
		int p;

		Node(int i, int j, int m) {
			this.i = i;
			this.j = j;
			this.m = m;
		};
	}//p가 0일 때 직선, 1 일때 꺾임
	private static void  DFS(int[][] board, Node buf, boolean[][] v) {
		

        int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };
		
		if(buf.i == board.length-1 && buf.j == board[0].length-1) {
			 answer = Math.min(answer, buf.m);
			return;
		}
		
		for (int d = 0; d < dr.length; d++) {
			int r = buf.i + dr[d];
			int c = buf.j + dc[d];
			
			if(IsIn(board, r, c) && !v[r][c]) {
				v[r][c] = true;
				DFS(board, new Node(r,c,buf.m+100), v);
				DFS(board, new Node(r,c,buf.m+500), v);
				v[r][c] = false;
			}

		}
	}
	static int answer = Integer.MAX_VALUE;
	public static int solution(int[][] board) {
        
        Queue<Node> q = new LinkedList<>();
		boolean[][] v = new boolean[board.length][board[0].length];
        
		DFS(board, new Node(0,0,0), v);
//		q.add(new Node(0,0,0));
//		v[0][0] = true;
//		
//		while(!q.isEmpty()) {
//			Node buf = q.poll();
//			
//			if(buf.i == board.length && buf.j == board[0].length) {
//				answer = Math.min(answer, buf.m);
//				v[buf.i][buf.j] = false;
//				continue;
//			}
//			
//			for (int d = 0; d < dr.length; d++) {
//				int r = buf.i + dr[d];
//				int c = buf.j + dc[d];
//				
//				if(r == board.length && c == board[0].length) {
//					q.add(new Node(r,c,buf.m+100));
//				}
//				if(IsIn(board, r, c) && !v[r][c]) {
//					q.add(new Node(r,c,buf.m+ 100));
//					q.add(new Node(r,c,buf.m + 500));
//				}
//
//			}
//		}
//        
        return answer;
    }
	
	private static boolean IsIn(int[][] arr, int r, int c) {
		if (r < 0 || c < 0 || r >= arr.length || c >= arr[r].length || arr[r][c] == '1')
			return false;
		else
			return true;
	}
}
