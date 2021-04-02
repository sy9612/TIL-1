package 기출;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class 미세먼지안녕_17144 {
	static class Node {
		int i = 0;
		int j = 0;

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int dr[] = { 0, 0, -1, 1 };
	static int dc[] = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int T = sc.nextInt();

		LinkedList<Node> clean = new LinkedList<>();
		LinkedList<Node> mise = new LinkedList<>();

		int A[][] = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				A[i][j] = sc.nextInt();

				if (A[i][j] == -1) {
					clean.add(new Node(i, j));
				}
			}
		}

		Node up = clean.get(0);
		Node down = clean.get(1);

		for (int t = 0; t < T; t++) {
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(A[i][j] > 0)
						mise.add(new Node(i,j));
				}
			}
			
			int copy[][] = new int[R][C];
			copy[up.i][up.j] = -1;
			copy[down.i][down.j] = -1; 
			while(!mise.isEmpty()) {

				Node buf = mise.poll();
				int start = (A[buf.i][buf.j] / 5);
				int monge = 0;
				for (int d = 0; d < 4; d++) {
					int r = buf.i + dr[d];
					int c = buf.j + dc[d];

					if (r < 0 || c < 0 || r >= R || c >= C)
						continue;
					else if (A[r][c] == -1)
						continue;
					else {
						copy[r][c] += start;
						monge++;
					}
				}
				
				A[buf.i][buf.j] -= start * monge; 
			}
			for(int i=0; i<R; i++)
			{
				for(int j=0; j<C; j++) {
					A[i][j] += copy[i][j];
				}
			}
			print(A);
			// ����û����
			
			
			int s1 = A[up.i][C-1];
			int s2 = A[down.i][C-1];
			for(int j = C-1; j > up.j+1; j--) {
				A[up.i][j] = A[up.i][j-1];
				A[down.i][j] = A[down.i][j-1];
			}
			A[up.i][up.j+1] = 0;
			A[down.i][down.j+1] = 0;
			
			int s3 = A[0][C-1];
			int s4 = A[R-1][C-1];
			for(int j = 1; j < up.i; j++) {
				A[j-1][C-1] = A[j][C-1];
			}
			for(int j=R-2; j>down.i; j--) {
				A[j+1][C-1] = A[j][C-1];
			}
			A[up.i-1][C-1] = s1;
			A[down.i+1][C-1] = s2;
			
			int s5 = A[0][0];
			int s6 = A[R-1][0];
			for(int j = 0; j < C-2; j++) {
				A[0][j] = A[0][j+1];
				A[R-1][j] = A[R-1][j+1];
			}
			A[0][C-2] = s3;
			A[R-1][C-2] = s4;
			
			for(int j=up.i-1; j>0; j--) {
				A[j][up.j] = A[j-1][up.j];
			}
			for(int j=down.i+1; j<R-1; j++) {
				A[j][down.j]= A[j+1][down.j]; 
			}
			A[1][up.j]= s5; 
			A[R-2][down.j]= s6; 
		}
		int result = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(A[i][j] > 0)
					result+= A[i][j];
			}
		}
		System.out.println(result);

	}
	
	static void print(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
}
