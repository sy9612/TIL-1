package 이것이코딩테스트다;
import java.util.Arrays;
import java.util.Scanner;

public class 정확한순위 {
	// 플로이드와샬
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] score = new int[N+1][N+1];
		
		for (int i = 0; i < score.length; i++) {
			Arrays.fill(score[i], 987654321);
		}
		
		for (int i = 0; i < score.length; i++) {
			score[i][i] = 0;
		}
		
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			score[a][b] = 1;
		}
		
		
		for (int k = 1; k < score.length; k++) {
			for (int i = 1; i < score.length; i++) {
				for (int j = 1; j < score.length; j++) {
					
					if(i != j && score[i][j] > score[i][k] + score[k][j]) {
						score[i][j] = score[i][k] + score[k][j];
					}
					
				}
			}
		}
		int rs = 0;
		for (int i = 1; i < score.length; i++) {
			int cnt = 0;
			for (int j = 1; j < score.length; j++) {
				if(score[i][j] != 987654321 || score[j][i] != 987654321) cnt++;
			}
			
			if(cnt == N) {
				rs++;
			}
		}
		
		System.out.println(rs);
		
		
	}
}
