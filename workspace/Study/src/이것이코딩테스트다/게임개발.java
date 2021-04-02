package 이것이코딩테스트다;

import java.util.Scanner;

public class 게임개발 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[sc.nextInt()][sc.nextInt()];

		// 0�� 1�� 2�� 3��
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		
		int cr = sc.nextInt();
		int cc = sc.nextInt();
		int cd = sc.nextInt();
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int cnt = 1;
		boolean[][] map_check = new boolean[map.length][map[0].length];
		map_check[cr][cc] = true;
		int ch = 0;
		while(true) {
			if(cd == 0) {
				cd = 3 ;
			}
			else {
				cd--;
			}

			if(!map_check[cr+dr[cd]][cc+dc[cd]] && map[cr+dr[cd]][cc+dc[cd]] == 0) {
				cr += dr[cd];
				cc += dc[cd];
				map_check[cr][cc] = true;
				cnt++;
				ch = 0;
			}
			else {
				if(ch == 4) {
					if( map[cr-dr[cd]][cc-dc[cd]] == 0) {
						cr -= dr[cd];
						cc -= dc[cd];
						ch = 0;
					}
					else break;
				}
				else ch++;
			}
		}
		
		System.out.println(cnt);
		
	}
}
