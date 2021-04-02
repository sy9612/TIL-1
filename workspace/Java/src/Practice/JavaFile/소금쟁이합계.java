package Practice.JavaFile;
import java.util.Scanner;

public class 소금쟁이합계 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			int N = sc.nextInt();
			int map[][] = new int[N][N];
			int strider = sc.nextInt();
			
			int result = strider;

			int strider_jump[][] = new int[strider][3];

			int[] dr = { 0, -1, 1, 0, 0 };
			int[] dc = { 0, 0, 0, -1, 1 };
			
			for (int i = 0; i < strider; i++) {
				strider_jump[i][0] = sc.nextInt();
				strider_jump[i][1] = sc.nextInt();

				if(map[strider_jump[i][0]][strider_jump[i][1]] == 1)
				{
					result--;
					continue;
				}
				map[strider_jump[i][0]][strider_jump[i][1]] = 1;

				strider_jump[i][2] = sc.nextInt();
			

				for(int j=3; j>0; j--) {
					map[strider_jump[i][0]][strider_jump[i][1]] = 0;
					strider_jump[i][0] += dr[strider_jump[i][2]]*j;
					strider_jump[i][1] += dc[strider_jump[i][2]]*j;
					
					if(strider_jump[i][0]<0 || strider_jump[i][1] < 0 || strider_jump[i][0] >= N || strider_jump[i][1] >=N || map[strider_jump[i][0]][strider_jump[i][1]] == 1) {
						result--;
						break;
					}
					else
						map[strider_jump[i][0]][strider_jump[i][1]] = 1;
				}
			}
			System.out.println(result);
		}

	}
}
