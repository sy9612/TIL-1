package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class 키순서_2458 {
	public static void main(String[] args) {
		flo_wh();
	}

	//플로이드 와샬 이용
	private static void flo_wh() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N+1][M+1];
		int INF = 999_999; //더하기로 인해 음수가 되면 안되기 때문에 MAX_VALUE대신 사용
		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], INF);
		}
		
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 1;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		//완탐
		int[] cnts = new int[N+1];
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length; j++) {
				if(map[i][j] != INF) {
					cnts[i]++;
					cnts[j]++;
				}
			}
		}
		int ans = 0;
		
		for (int i = 1; i < cnts.length; i++) {
			if(cnts[i] == N-1) {//나를 뺀 인원수와 같을 때
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
