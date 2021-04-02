package BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 찾기_1786 {
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
	static int cnt = 0;
	static Queue<Integer> q = new LinkedList<>();
	static void KMP(String origin, String pattern){
		int[] pi = getPi(pattern);
		int j= 0;
		for(int i=0; i<origin.length(); i++) {
			//맞는 경우
			while(j>0 && origin.charAt(i) != pattern.charAt(j))
				 j = pi[j-1];
			if(origin.charAt(i) == pattern.charAt(j)) {
				if(j == pattern.length() -1) {
					cnt++;
					q.add(i - pattern.length() + 2);
					j = pi[j];
				}
				//맞았지만 패턴이 끝나지 않았다면 j 증가
				else
					j++;
			}
			
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String T = sc.nextLine();
		String P = sc.nextLine();
		
		KMP(T,P);
		System.out.println(cnt);
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}
}
