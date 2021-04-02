package Practice.JavaFile;
import java.util.Scanner;

public class 점프사방 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int dr[] = {0,0,1,0,-1};
		int dc[] = {0,1,0,-1,0};
		
		for(int tc =1 ; tc <= T; tc++) {
			System.out.print("#"+tc+" ");
			int Y = sc.nextInt();
			int X = sc.nextInt();
			int N = sc.nextInt();
			int[][] map = new int[Y+1][X+1];
			
			for(int i=1; i<Y+1; i++) {
				for(int j=1; j<X+1; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int person[][] = new int[N][4];
			
			for(int i=0; i<N; i++)
			{
				person[i][0] = sc.nextInt();
				person[i][1] = sc.nextInt();
				person[i][2] = sc.nextInt();
				person[i][3] -= 0;
			}
			
			int trap_cnt = sc.nextInt();
			for(int i=0; i<trap_cnt; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();				
				map[a][b] = 0;
			}
			
			for(int i=0; i<N; i++) {
				int sign = 0;
				person[i][3] -= 1000;
				for(int j=0; j<person[i][2]; j++) {
					
					int compass = map[person[i][0]][person[i][1]]/10;
					int jump = map[person[i][0]][person[i][1]]%10;
					
					person[i][0] += dr[compass]*jump;
					person[i][1] += dc[compass]*jump;
					
					if(person[i][0] <=0 || person[i][1] <=0 || person[i][0] > Y || person[i][1] > X || map[person[i][0]][person[i][1]] == 0) {
						person[i][3] = -1000;
						sign = 1;
						break;
					}
				}
				if(sign == 0)
					person[i][3] += map[person[i][0]][person[i][1]]*100;
			}
			int result = 0;
			for(int i=0; i<N; i++) {
				result += person[i][3];
			}
			
			System.out.println(result);
			
		}
	}

}
