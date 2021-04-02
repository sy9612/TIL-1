package BASIC._0128;

public class 델타탐색 {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		//현재 위치에 대한 행, 열 인덱스 값
		int cr = 0;
		int cc = 1;
		//사방의 값을 출력
		
		
		for(int i=0; i<4; i++) {
			int r = cr + dr[i];
			int c = cc + dc[i];
			if(r>=0 && c >= 0 && r <map.length && c < map[r].length)
				System.out.println(map[r][c]);
		}
	}

}
