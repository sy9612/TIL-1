package 이것이코딩테스트다;

import java.util.Scanner;

//좌표 문제
//dx dy 설정
public class 왕실의나이트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String st = sc.next();
		
		
		int x = st.charAt(0) - 'a';
		int y = st.charAt(1) - 1;
		
		int cnt = 0;
		
		int[][] step = {
				{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
		};
		
		
		if( (x+2) < 8 && (y+1) < 8)
			cnt++;
		
		if( (x+2) < 8 && (y-1) >= 0)
			cnt++;
		
		if( (x-2) < 8 && (y + 1) < 8)
			cnt++;
		
		if( (x-2) >=0 && (y - 1) >= 0)
			cnt++;
		
		if( (x-2) >=0 && (y + 1) < 8)
			cnt++;
		
		if( (x+1) < 8 && (y + 2) < 8)
			cnt++;
		
		if( (x+1) < 8 && (y - 2) >=0)
			cnt++;
		
		if( (x-1) >=0 && (y + 2) < 8)
			cnt++;
		
		if( (x-1) >=0 && (y - 2) >= 0)
			cnt++;
	
		System.out.println(cnt);
	}
}
