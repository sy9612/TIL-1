package sw_expert._0217;

import java.util.Scanner;

public class 단순2진암호코드_1240_Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			sc.nextInt();// 가로는 필요없음 :)
			String[] code = new String[N];
			for (int i = 0; i < N; i++)
				code[i] = sc.next();
			int rPos = 0;// 네모 안의 아무(첫줄) 행번호를 찾아 저장할 변수
			int cPos = 0;// 네모가 시작되는 열의 번호를 찾아 저장할 변수
			out: for (int i = 0; i < code.length; i++) {
				for (int j = code[i].length() - 1; j >= 0; j--) {
					if (code[i].charAt(j) == '1') {
						cPos = j - 55;
						rPos = i;
						break out;
					}
				}
			}
			int[] arr = new int[8];
			for (int i = 0; i < 8; i++, cPos += 7) {
				String c = code[rPos].substring(cPos, cPos + 7);
				switch (c) {
				case "0001101":
					arr[i] = 0;
					break;
				case "0011001":
					arr[i] = 1;
					break;
				case "0010011":
					arr[i] = 2;
					break;
				case "0111101":
					arr[i] = 3;
					break;
				case "0100011":
					arr[i] = 4;
					break;
				case "0110001":
					arr[i] = 5;
					break;
				case "0101111":
					arr[i] = 6;
					break;
				case "0111011":
					arr[i] = 7;
					break;
				case "0110111":
					arr[i] = 8;
					break;
				case "0001011":
					arr[i] = 9;
					break;
				}
			}
			int sum = (arr[0] + arr[2] + arr[4] + arr[6]) * 3 + arr[1] + arr[3] + arr[5] + arr[7];
			if (sum % 10 == 0) {
				int result = arr[0] + arr[1] + arr[2] + arr[3] + arr[4] + arr[5] + arr[6] + arr[7];
				System.out.println("#" + tc + " " + result);

			} else
				System.out.println("#" + tc + " " + 0);
		}
	}

}
