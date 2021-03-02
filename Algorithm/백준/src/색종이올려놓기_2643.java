import java.util.Scanner;

public class 색종이올려놓기_2643 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] paper = new int[N][2];
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a<b) {
				paper[i][0] = a;
				paper[i][1] = b;
			}
			
		}
		
		
	}
}
