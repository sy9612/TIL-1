package BAEKJOON;

import java.util.Scanner;

public class 늑대와양_16956 {
	static class Node{
		int r;
		int c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		
		char[][] map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String st = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = st.charAt(j);
			}
		}
		
		int[] dr = {0, 0, 1, -1};
		int[] dc = {1, -1, 0, 0};
		
// 늑대 근처에 울타리 두르기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'W') {
					for (int d = 0; d < 4; d++) {
						int r = i + dr[d];
						int c = j + dc[d];
						
						if(r< 0 || c <0 || r>= R || c >= C)
							continue;

						// 늑대 근처에 양이 있으면 울타리를 세우지 못하므로 0 출력
						if(map[r][c] == 'S')
						{
							System.out.println(0);
							return;
						}
						// .이면 울타리를 둘러서 사방을 막음
						else if(map[r][c] == '.'){
							map[r][c] = 'D';
						}
						
					}
				}
			}
		}
		
		System.out.println(1);
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
