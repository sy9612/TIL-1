package BASIC._0128;

import java.util.Arrays;

public class 델타연습문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map = {
				{5,1,0,3},
				{3,2,7,6},
				{0,1,2,3},
				{4,2,1,7}
		};
		
		int[][] result_map = new int[map.length][map.length];
		
		int dc[] = {0,0,1,-1};
		int dr[] = {1,-1,0,0};
		
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				int sum = 0;
				for(int d =0; d<4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					if(nr>=0 && nc>=0 && nr < map.length && nc < map.length) {
						sum += Math.abs(map[nr][nc] - map[i][j]);
					}
				}
				result_map[i][j] = sum;
				
			}
		}
		
		for(int i=0; i<map.length; i++) {
			System.out.println(Arrays.toString(result_map[i]));
		}
	}
}
