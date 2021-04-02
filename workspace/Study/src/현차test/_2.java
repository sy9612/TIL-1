package 현차test;

import java.util.Arrays;

public class _2 {
	public static void main(String[] args) {
		int N = 3;
		int[][] bus_stop  = {{1,2}, {3,3}};
		print(solution(N, bus_stop));
	}
	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
	public static int[][] solution(int N, int[][] bus_stop) {
		int[][] map = new int[N][N];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (int b = 0; b < bus_stop.length; b++) {
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					
					if(i == (bus_stop[b][0]-1) && j == (bus_stop[b][1]-1)) {
						map[i][j] = 0;
					}
					else if(map[i][j] > (Math.abs(bus_stop[b][0] - i-1) + Math.abs(bus_stop[b][1] - j-1))) {
						map[i][j] =  Math.abs(bus_stop[b][0] - i-1) + Math.abs(bus_stop[b][1] - j-1);
					}
					
				}
			}
			
		}
		
		return map;
	}
}
