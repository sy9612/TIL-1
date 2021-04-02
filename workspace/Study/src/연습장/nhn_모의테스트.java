package 연습장;

import java.util.Arrays;
import java.util.Scanner;

public class nhn_모의테스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long W = sc.nextInt();

		String map[][] = new String[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.next();
			}
		}

		if (N % 2 != 0) {
			int start = 1;
			int cnt = N / 2 - 1;
			for (int i = 3; i <= N; i += 2) {
 				int a = i * i;
				int num = a - start;
				int absW = (int) (Math.abs(W) % num);

				if (absW == 0)
					continue;
				for (int w = 0; w < absW; w++) {
					int r = 0;
					int c = 0;
					int or = 0;
					String temp = map[cnt][cnt];
					for (int j = 0; j < num; j++) {
						
						print(map);
						
						if (W < 0) {
							if (or == 0) {
								r++;
								String t = map[cnt + r][cnt + c];
								map[cnt + r][cnt + c] = temp;
								temp = t;
								if (r == i-1) {
									or = 1;
									continue;
								}
							} else if (or == 1) {
								c++;
								
								String t = map[cnt + r][cnt + c];
								map[cnt + r][cnt + c] = temp;
								temp = t;
								
								if (c == i-1) {
									or = 2;
									continue;
								}
								
							} else if (or == 2) {
								r--;
								
								String t = map[cnt + r][cnt + c];
								map[cnt + r][cnt + c] = temp;
								temp = t;
								
								if (r == 0) {
									or = 3;
									continue;
								}
							} else {
								c--;
								if (c % i == 0) {
									break;
								}
								String t = map[cnt + r][cnt + c];
								map[cnt + r][cnt + c] = temp;
								temp = t;
							}
						} else {

						}
					}
					map[cnt][cnt] = temp;
					print(map);
				} //바꾸기 완료
				
			}
		} else {

		}
	}
	private static void print(String[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
}
