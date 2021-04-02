package 연습장;

import java.util.Scanner;

public class Algo1_광주_3반_김지홍 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tt= sc.nextInt();
		for (int tc = 1; tc <= Tt; tc++) {
			System.out.print("#" + tc + " ");
			int D = sc.nextInt(); //시급
			int T = sc.nextInt(); //일한시간
			int M = D * T; //받아야 될 돈
			
			
			//10센트 단위로 끊어지지 않으면 -1 출력
			if(M%10 == 0)
				M = M/10; //나누기
			else
			{
				System.out.println(-1); // -1 출력
				continue;
			}
			
			int c[][] = new int[M+1][4];
			
			for(int i=0; i<c.length; i++) {
				c[i][0] = i; // 10센트짜리 필요한 개수
				c[i][1] = i; // 10센트 개수
			}
			
			// 10센트, $1 모두 고려
			for (int i = 10; i < c.length; i++) {
				if(c[i][0] > c[i-10][0]+1) {
					c[i][0] = c[i-10][0] + 1; //100센트 -> $1
					
					c[i][1] = c[i-10][1]; //10센트 개수
					c[i][2] = c[i-10][2] + 1; //$1 개수
				}
			}
			
			// 10센트, $1, $4 모두 고려
			for (int i = 40; i < c.length; i++) {
				int buf = Math.min(c[i-4][0]+1, c[i-40][0]+1); //최소값 검색
				if(c[i][0] > buf) { //최소값 저장
					c[i][0] = buf; 
					if(buf == c[i-4][0]+1) { //$1 -> $4가 될 경우
						c[i][1] = c[i-4][1]; //10센트 개수
						c[i][2] = c[i-4][2]; //$1 개수
						c[i][3] = c[i-4][3] + 1; //$4 개수
					}
					else if(buf == c[i-40][0]+1) { //10센트 -> $4가 될 경우
						c[i][1] = c[i-40][1]; //10센트 개수
						c[i][2] = c[i-40][2]; //$1 개수
						c[i][3] = c[i-40][3] + 1; //$4 개수
					}
				}
			}
			
			System.out.println(c[M][3] +" " + c[M][2] + " " + c[M][1]); //결과
		}
		
	}
}
