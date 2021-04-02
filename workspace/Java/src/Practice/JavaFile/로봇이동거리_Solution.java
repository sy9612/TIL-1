package Practice.JavaFile;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 로봇이동거리_Solution {
	static int T;
	static int N;
	static char[][] map;

	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("로봇이동거리input.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new char[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.next().charAt(0);
				}
			}
			int cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 'A') {
						for(int k=0; k<1;k++) {
							int nr = r+ dr[k];
							int nc = c + dc[k];
							while(check(nr,nc) && map[nr][nc] == 'S') {
								nr += dr[k];
								nc += dc[k];
								cnt++;
							}
						}
					} else if (map[r][c] == 'B') {
						for(int k=0; k<2;k++) {
							int nr = r+ dr[k];
							int nc = c + dc[k];
							while(check(nr,nc) && map[nr][nc] == 'S') {
								nr += dr[k];
								nc += dc[k];
								cnt++;
							}
						}
					} else if (map[r][c] == 'C') {
						for(int k=0; k<4;k++) {
							int nr = r+ dr[k];
							int nc = c + dc[k];
							while(check(nr,nc) && map[nr][nc] == 'S') {
								nr += dr[k];
								nc += dc[k];
								cnt++;
							}
						}
					}
				}
			}
			
//			print(map);
			System.out.println(cnt);
		}

	}

	private static boolean check(int nr, int nc) {
		// TODO Auto-generated method stub
		if(nr>=0 && nr<N && nc>= 0 && nc<N)
			return true;
		return false;
	}

	private static void print(char[][] map2) {
		// TODO Auto-generated method stub
		for(int i=0; i<map2.length; i++) {
				System.out.println(Arrays.toString(map2[i]));
		}
	}
	
	
}
