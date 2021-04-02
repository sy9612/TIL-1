package sw_expert.Solution;
import java.util.*;
import java.io.*;
public class 오나의여신님_Solution {
	// 출력을 모아서
	static StringBuilder sb = new StringBuilder();
	// 사방 탐색
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	
	
	static char[][] map;
	static Queue<Point> devil, player;
	static int T, N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//제출 시 주석처리
		br = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			/////////////////////////////////////////////////////
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			
			devil = new LinkedList<>();
			player = new LinkedList<>();
			map = new char[N][M];
			for(int i=0; i<N; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j=0; j<M; j++) {
					if(map[i][j] == '*') {
						devil.offer(new Point(i,j,0));
						
					}else if(map[i][j] == 'S') {
						player.offer(new Point(i, j, 0));
					}
				}
			}
			
			// 끝나는 시점: 수연 소멸  or 수연 여신 도달
			
			while(true) {
				// 1. player가 없다면 -> game over
				if(player.size() == 0) {
					sb.append("GAME OVER");
					break;
				}
				// 2. devil이 1초 동작 -> ., S를 만나면 오염
				bfsDevil();
				// 3. player가 동작 -> .으로 이동, D를 만나면 종료
				int result = bfsPlayer();
				
				if(result != -1) {
					sb.append(result);
					break;
				}
			}
			
			for(char[] row: map) {
				System.out.println(Arrays.toString(row));
			}
			/////////////////////////////////////////////////////
			sb.append("\n");
		}
	}
	
	private static int bfsPlayer() {
	int size = player.size();
		
		while(size-- > 0) {
			Point front = player.poll();
			
			// 자식 탐색 - 사방 탐색
			for(int d =0; d<4; d++) {
				int nr = front.row + dr[d];
				int nc = front.col + dc[d];
				
				if(isIn(nr,nc)) { // 범위 안에 있을 때
					if(map[nr][nc] == 'D')
						return front.depth +1;
					else if(map[nr][nc] == '.'){
						map[nr][nc] = 'S';
						
						player.offer(new Point(nr, nc, front.depth+1));
					}
				}
			}
		}
		return -1;
	}

	private static void bfsDevil() {
		int size = devil.size();
		
		while(size-- > 0) {
			Point front = devil.poll();
			
			// 자식 탐색 - 사방 탐색
			for(int d =0; d<4; d++) {
				int nr = front.row + dr[d];
				int nc = front.col + dc[d];
				
				if(isIn(nr,nc)) {
					if(map[nr][nc] == '.' || map[nr][nc] == 'S') {
						// 지도의 상태를 변경한 것이 방문 처리
						map[nr][nc] = '*';
						// 큐에 새로 들어가긴 하지만 빠지지는 않는다.
						devil.offer(new Point(nr, nc, front.depth+1));
					}
				}
			}
		}
		
	}
	private static boolean isIn(int r, int c) {
		return 0<=r && 0<=c && r< N & c<M;
	}
	static class Point {
		int row, col, depth; // 행, 렬 ,깊이

		public Point(int r, int c, int d) {
			super();
			this.row = r;
			this.col = c;
			this.depth = d;
		}
	}
	static String src = "2\r\n" + 
			"5 3\r\n" + 
			"D*S\r\n" + 
			".X.\r\n" + 
			".X.\r\n" + 
			".X.\r\n" + 
			"...\r\n" + 
			"5 3\r\n" + 
			"D*S\r\n" + 
			"...\r\n" + 
			".X.\r\n" + 
			".X.\r\n" + 
			"...";
}
