package BAEKJOON;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스_2606 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = map[b][a] = 1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		
		boolean[] check = new boolean[N+1];
		check[1] = true;
		int result = 0;
		while(!q.isEmpty()) {
			int buf = q.poll();
			
			for (int i = 1; i < N+1; i++) {
				if(map[buf][i] == 1 && !check[i]) {
					result++;
					q.add(i);
					check[i] = true;
				}
			}
		}
		
		System.out.println(result);
	}
}
