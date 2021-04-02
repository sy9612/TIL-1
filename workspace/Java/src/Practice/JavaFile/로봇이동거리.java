package Practice.JavaFile;
import java.util.Scanner;

public class 로봇이동거리 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc <= T; tc++) {
			int N = sc.nextInt();
			String map[][] = new String[N][N];
			
			int robot[][] = new int[N][2];
			int robot_size = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.next();
					if(map[i][j].equals("A") || map[i][j].equals("B") || map[i][j].equals("C")) {
						robot[robot_size][0] = i;
						robot[robot_size][1] = j;
						robot_size++;
						
					}
				}
			}
			
			int result = 0;
			for(int i=0; i<robot_size; i++) {
				switch(map[robot[i][0]][robot[i][1]]) {
				case "A":
					for(int j=robot[i][1]+1; j<N; j++) {
						if(!map[robot[i][0]][j].equals("S"))
							break;
						result++;
					}
					break;
				case "B":
					for(int j=robot[i][1]+1; j<N; j++) {
						if(!map[robot[i][0]][j].equals("S"))
							break;
						result++;
					}
					for(int j=robot[i][1]-1; j>=0; j--) {
						if(!map[robot[i][0]][j].equals("S"))
							break;
						result++;
					}
					break;
				case "C":
					for(int j=robot[i][0]+1; j<N; j++) {
						if(!map[j][robot[i][1]].equals("S"))
							break;
						result++;
					}
					for(int j=robot[i][0]-1; j>=0; j--) {
						if(!map[j][robot[i][1]].equals("S"))
							break;
						result++;
					}
					for(int j=robot[i][1]+1; j<N; j++) {
						if(!map[robot[i][0]][j].equals("S"))
							break;
						result++;
					}
					for(int j=robot[i][1]-1; j>=0; j--) {
						if(!map[robot[i][0]][j].equals("S"))
							break;
						result++;
					}
					break;
				}
			}
			
			System.out.println("#" + tc + " " + result);
			
		}
	}

}
