package Practice.JavaFile;
import java.util.Scanner;

public class 보물지도 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			System.out.print("#"+tc+" ");
			
			int N = sc.nextInt();
			
			int map[][] = new int[N+1][N+1];
			
			//현재 위치
			int pi = sc.nextInt();
			int pj = sc.nextInt();
			//함정의 수
			int P = sc.nextInt();
			
			for(int i =0; i<P; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				map[a][b] = -1;
			}
			
			int D = sc.nextInt();
			int d[] = new int[D];
			int compass_dr[] = new int[D];
			int compass_dc[] = new int[D];
			
			for(int i=0; i<D; i++) {
				int a = sc.nextInt();
				d[i] = sc.nextInt();
				
				switch(a) {
				case 1:
					compass_dr[i] = -1;
					compass_dc[i] = 0;
					break;
				case 2:
					compass_dr[i] = -1;
					compass_dc[i] = 1;
					break;
				case 3:
					compass_dr[i] = 0;
					compass_dc[i] = 1;
					break;
				case 4:
					compass_dr[i] = 1;
					compass_dc[i] = 1;
					break;
				case 5:
					compass_dr[i] = 1;
					compass_dc[i] = 0;
					break;
				case 6:
					compass_dr[i] = 1;
					compass_dc[i] = -1;
					break;
				case 7:
					compass_dr[i] = 0;
					compass_dc[i] = -1;
					break;
				case 8:
					compass_dr[i] = -1;
					compass_dc[i] = -1;
					break;
				default:
					
				}
			}
			
			//좌표 밖 or 함정 -> 0 0 출력
			//도착한 목적지 찾기
			int sign = 0;
			for(int i=0; i<D; i++) {
				
				for(int j=0; j<d[i]; j++) {
					pi += compass_dr[i];
					pj += compass_dc[i];
					if(pi <1 || pj <1 || pi > N || pj > N|| map[pi][pj] == -1)
					{
						sign = 1;
						break;
					}
				}
				if(sign == 1) {
					System.out.println("0 0");
					break;
				}
			}
			if(sign == 0)
				System.out.println(pi + " " + pj);
		}
	}

}
