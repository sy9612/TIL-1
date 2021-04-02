package BASIC._0409;

import java.util.regex.Pattern;

public class KMP {
	//모든 경우를 다 비교하지 않아도 부분 물자열을 찾을 수 있는 알고리즘
	//접두사와 접미사 개념 활용 -> 반복 연산을 줄임
	//지금까지 검사한 문자열의 접두사와 접미사가 일치하는지 최대길이만틈 ㄱㅂ
	
	//파이테이블: 각 테이블로 접두사 == 접미사의 최대길이가 저장된 배열
	private static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j =0;
		for(int i=1; i<pattern.length(); i++) {
			//맞는 날이 올 때까지 하나 전칸에서 공통 부분 위치로 이동
			while(j>0 & pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			//맞는 경우
			if(pattern.charAt(i) == pattern.charAt(j)) {
				//i 길이 문자열 공통 길이는 j의 위치 +1
				pi[i] = ++j;
			}
			//맞지 않는 경우
//			else {
//				
//			}
		}
		return pi;

	}
	static void kmp(String origin, String pattern){
		int[] pi = getPi(pattern);
		int j= 0;
		for(int i=0; i<origin.length(); i++) {
			//맞는 경우
			while(j>0 && origin.charAt(i) != pattern.charAt(j))
				 j = pi[j-1];
			if(origin.charAt(i) == pattern.charAt(j)) {
				if(j == pattern.length() -1) {
					System.out.println(i - pattern.length() + 2);
					j = pi[j];
				}
				//맞았지만 패턴이 끝나지 않았다면 j 증가
				else
					j++;
			}
			
		}
	}
	public static void main(String[] args) {
		String origin = "HELLOSSAFY";
		String pattern = "LOSS";
		kmp(origin, pattern);
	}
}
