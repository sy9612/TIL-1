package sw_expert.Solution;

import java.util.Arrays;
import java.util.Scanner;

public class 벽돌깨기_Solution {
	static int N;
	static int C;
	static int R;
	static int[][] map;
	static int brickCnt = 0;
	static int[] perm;
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			N = sc.nextInt();
			C = sc.nextInt();
			R = sc.nextInt();

			map = new int[R][C];
			perm = new int[N];
			brickCnt = 0;

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] != 0)
						brickCnt++;
				}
			}
			answer = brickCnt;
			
			// 구슬을 하나씩 떨어뜨림
			// 좌표가 달라져야함 -> 중복 순열로 좌표 선택
			// 벽돌의 개수, map 전달
			
			dropMarble(N, brickCnt, map);
			
		}
	}
	private static int[][] cloneMap(int[][] map2){
		int[][] temp = new int[R][C];
		for(int r = 0; r<R; r++) {
			temp[r] = map2[r].clone(); //deep copy: 내용 복사
			
		}
		return temp;
	}
	static class Brick{
		int row, col, pow;
		public Brick(int row, int col, int pow) {
			this.row = row;
			this.col = col;
			this.pow = pow;
		}
		@Override
		public String toString() {
			return "Brick [row=" + row + ", col=" + col + ", pow=" + pow + "]";
		}
		
		
	}
	private static void dropMarble(int r, int brickCnt2, int[][] map) {
		if(r==0)
		{
			answer = Math.min(answer, brickCnt);
			return;
		}
		
		for(int c=0; c<C; c++) {
			// 1. map 복제
			int [][] cloned = cloneMap(map);
			// 2. 해당 컬럼의 맨 처음 벽돌 가져오기
			Brick first = getFirstBrick(c, cloned);
			// 2-1. null --> continue
			if(first == null)
				continue;
			// 3. 구슬을 떨어뜨려서 벽돌을 깬다. --> 깨진 벽돌의 개수
			int broken = crash( first, cloned);
			// 3-1. 이미 벽돌이 다 깨졌다면?? 답: 0, 종료
			if(broken >= brickCnt) {
				answer = 0;
				return;
			}
			// 4. 화면정리
			cleanMap(cloned);
			
			// 5. 다음 발사
			dropMarble(r-1,brickCnt - broken,cloned);
		}
	}
	private static void cleanMap(int[][] map) {
		for(int c= 0; c<C; c++) {
			for(int r= R-1, nr = R-1; r>=0; r--) {
				if(map[r][c] != 0) {
					int temp = map[r][c];
					map[r][c] = 0;
					map[nr--][c] = temp;
				}
			}
		}
	}
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	private static int crash(Brick first, int[][] map) {
		int broken = 0;
		// 맞은 벽돌 삭제
		map[first.row][first.col] = 0;
		broken++;
		
		// 주변 벽돌에 영향
		for(int p =1; p<first.pow; p++) {
			//사방 탐색
			for(int d=0; d<4; d++) {
				int nr = first.row + dr[0] * d;
				int nc = first.col + dc[0] * d;
				
				if(IsIn(map,nr,nc) && map[nr][nc] != 0) {
					broken += crash(new Brick(nr, nc, map[nr][nc]), map);
				}
			}
		}
		
		return broken;
	}
	private static Brick getFirstBrick(int c, int[][] map) {
		for(int r=0; r<R; r++) {
			if(map[r][c] != 0) {
				return new Brick(r, c, map[r][c]);
			}
		}
		return null;
	}
	private static boolean IsIn(int[][] arr, int r, int c) {
		if (r < 0 || c < 0 || r >= arr.length || c >= arr[r].length)
			return false;
		else
			return true;
	}
}
