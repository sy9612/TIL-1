package chap02;

import java.util.Arrays;
import java.util.Scanner;

public class Example01 {
	// 10*10 이차원 배열이 있습니다.
	// r과 c의 값을 입력받아서 입력받은 위치의 상하좌우에 1을 입력하고 출력하는 프로그램을 작성하세요
	
 	public static void main(String[] args) {
 		int[][] arr = new int[10][10];
 		Scanner sc = new Scanner(System.in);

 		System.out.println("r, c의 값을 입력하세요");
 		int r = sc.nextInt();
 		int c = sc.nextInt();
 		
/* 		if(r<9)
 			arr[r+1][c+0] = 1;
 		if(r>0)
 			arr[r-1][c+0] = 1;
 		if(c<9)
 			arr[r+0][c+1] = 1;
 		if(c>0)
 			arr[r+0][c-1] = 1;
 */		
 		
 		//반복문
 		int[] dr = {0,0,1,-1};
 		int[] dc = {1,-1,0,0};
 		
 		for (int i = 0; i < dr.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr>=0 && nr<10 && nc>=0 && nc<10)
				arr[nr][nc] = 1;
		}
 		
 		for (int i = 0; i < 10; i++) {
 			System.out.println(Arrays.toString(arr[i]));
		}
	}

}
