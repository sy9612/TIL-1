package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class 회사에있는사람_7785 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> hs = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			String st[] = br.readLine().split(" ");
			if(st[1].equals("enter")) hs.add(st[0]);
			else hs.remove(st[0]);
		}
		
		String[] rs = hs.toArray(new String[hs.size()]);
		
		Arrays.sort(rs);
		for (int i = 0; i < rs.length; i++) {
			System.out.println(rs[rs.length-i-1]);
		}
	}
}
