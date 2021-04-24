package devmatching;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _2 {
	public static void main(String[] args) {

		int rows = 6;
		int columns = 6;
		int queries[][] = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 }

		};
		System.out.println(Arrays.toString(solution(rows, columns, queries)));

	}
	
	// 배열을 회전할 때, 회전하는 것 중 가장 작은 값 찾기

	public static int[] solution(int rows, int columns, int[][] queries) {
	
		
		int[] answer = new int[queries.length];
		int ans = 0;
		int[][] map = new int[rows+1][columns+1];
		int cnt = 1;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				map[i][j] = cnt++;
			}
		}
		
		// 회전을 4방 탐색으로 처리
		// 회전에 알맞은 위치에 가장 작은 값 찾기
		for (int i = 0; i < queries.length; i++) {
			
			//시작과 끝의 사각형이 정해짐
			int stx = queries[i][0];
			int sty = queries[i][1];
			int min = Integer.MAX_VALUE;
			
			int endx = queries[i][2];
			int endy = queries[i][3];
		
			
			int back = map[stx][endy];
			for (int j = endy; j > sty; j--) {
				min = Math.min(min, map[stx][j]);
				map[stx][j] = map[stx][j-1];
			}
			min = Math.min(min, back);
		
			
			int back1 = map[endx][endy];
			for (int j = endx; j > stx; j--) {
				min = Math.min(min, map[j][endy]);
				map[j][endy] = map[j-1][endy];
			}
			map[stx+1][endy] = back;
			min = Math.min(min, back1);
			
			
			
			back = map[endx][sty];
			for (int j = sty; j < endy; j++) {

				min = Math.min(min, map[endx][j]);
				map[endx][j] = map[endx][j+1];
			}
			map[endx][endy-1] = back1;
			min = Math.min(min, back);

	
			
			back1 = map[stx][sty];
			for (int j = stx; j < endx; j++) {
				min = Math.min(min, map[j][sty]);
				map[j][sty] = map[j+1][sty];
			}
			map[endx-1][sty] = back;
			min = Math.min(min, back1);
//			
//			for (int i1 = 0; i1 < map.length; i1++) {
//				System.out.println(Arrays.toString(map[i1]));
//			}
//			System.out.println(back1);
			
//			System.out.println(min);
			answer[ans++] = min;
		}
		
		
		
		return answer;
	}
}
