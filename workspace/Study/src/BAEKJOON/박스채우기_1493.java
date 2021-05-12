package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class 박스채우기_1493 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int len = sc.nextInt();
		int wid = sc.nextInt();
		int hei = sc.nextInt();
		
		int B = len * wid * hei;
		
		int N = sc.nextInt();
		
		int[][] box = new int[N][2];
		
		for (int i = 0; i < box.length; i++) {
			box[i][0] = sc.nextInt();
			box[i][1] = sc.nextInt();
		}
		
		Arrays.sort(box, (o1, o2) -> {
			if(o1[0] == o2[0]) {
				return o2[1] - o1[1];
			}
			else return o2[0] - o1[0];
		});
		
		long result = 0;
		boolean ok = false;
		for (int i = 0; i < box.length; i++) {
			long b = (long) Math.pow(2, box[i][0]);
			long cube = b * b * b;
			for (int j = 0; j < box[i][1]; j++) {
				if(B - cube < 0 || (b > len && b > wid && b >hei )) break;
				B -= cube;
				if(len !=0)
					len -= b;
				if(wid != 0)
				wid -= b;
				if(hei != 0)
				hei -= b;
				
				result++;
			}
			if(B == 0) {
				ok = true;
				break;
			}
		}
		
		if(ok) System.out.println(result);

		else System.out.println(-1);
		
		
		
		
		
	}
}
