package BAEKJOON;

import java.util.Scanner;

public class 사나운_개_2991 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		
		int P[] = new int[3];
		
		for(int i=0; i<3; i++)
			P[i] = sc.nextInt();
		
		
		for(int i=0; i<3; i++) {
			int result = 0;
			
			int buf = P[i]%(A+B);
			int buf2 = P[i]%(C+D);
		
			if(buf <= A && buf != 0)
				result++;
			if(buf2 <= C && buf2 != 0)
				result++;
			
			System.out.println(result);
			
		}
	}

}
