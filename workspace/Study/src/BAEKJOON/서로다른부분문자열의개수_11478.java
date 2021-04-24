package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 서로다른부분문자열의개수_11478 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		HashSet<String> hs = new HashSet<>();
		int cnt = 0;
		
		
		//hash에 문자열 넣으면 O(n)
		//해당 복잡도는 n^3
		for (int i = 0; i < S.length(); i++) {
			for (int j = i+1; j < S.length()+1; j++) {
				String sub = S.substring(i,j);
				if(!hs.contains(sub)) {
					cnt++;
					hs.add(sub);
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}
