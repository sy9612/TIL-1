package Practice.JavaFile;
import java.util.Scanner;

public class 빌딩 {

	public static void main(String[] args) {
		int T;
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			String building[][] = new String[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					building[i][j] = sc.next();
				}
			}
			
			
			int max = 0;
			
			//상하좌우대각선
			int[] dr = {0,0,1,-1,1,-1,1,-1};
			int[] dc = {1,-1,0,0,1,-1,-1,1};
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int sign = 0;
					for(int k=0; k<8; k++) {
						int r = i + dr[k];
						int c = j + dc[k];
						
						if(r>=0 && c>=0 && r<N && c<N&& building[r][c].equals("G")) {
							if(max<2)
								max = 2;
							sign = 1;
							break;
						}
					}
					if(sign == 0) {
						int cnt =0;
						for(int s = 0; s <N; s++) {
							if(s != i && building[s][j].equals("B"))
								cnt++;
							if(s != j && building[i][s].equals("B"))
								cnt++;
						}
						if((cnt+1) > max)
							max = cnt+1;
					}
				}
			}
			
			
			System.out.println("#"+tc+" "+max);
		}

	}

}
