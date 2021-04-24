package kakao_2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class _2 {
	public static void main(String[] args) {
		
		int needs[][] = {
//				{1, 0, 0},
//				{1, 1, 0},
//				{1, 1, 0},
//				{1, 0, 1},
//				{1, 1, 0},
//				{0, 1, 1},
//				{1, 1, 1},
				{0, 0, 0},
				{1, 0, 0, 1},
				{1, 0, 0 , 0, 0, 0, 0, 0, 0, 1}
		};
		int r = 2;
		
		System.out.println(solution(needs, r));

	}
	public static int solution(int[][] needs, int r) {
        int answer = 0;
        result = new int[r];
        
        for (int i = 0; i < needs.length; i++) {
        	c = Math.max(c, needs[i].length);
		}
        
        max = 0;
        
        
        comb(needs, 0, 0);
        
        answer = max;
        
        return answer;
    }
	
	static int[] result;
	static int max;
	static int c;
	
	
	private static void comb(int[][] needs, int idx, int sidx) {
		// TODO Auto-generated method stub
		if(sidx == result.length) {
			int cnt = 0;
			for (int i = 0; i < needs.length; i++) {
				boolean ok = true;
				for (int j = 0; j < needs[i].length; j++) {
					int num = j;
					if(needs[i][j] == 1 && !IntStream.of(result).anyMatch(x -> x == num)) {
						ok = false;
						break;
					}
				}
				
				if(ok) cnt++;
			}
			
			max = Math.max(max, cnt);
			
			return;
		}
		if(idx == c)
			return;
		
		result[sidx] = idx;
		
		comb(needs, idx+1,sidx+1);
		comb(needs, idx+1, sidx);
	}
}
