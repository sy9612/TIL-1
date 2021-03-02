package 네이버파이낸셜;

import java.util.Arrays;

public class _1 {
	public static int[] solution(String[] S) {
		int[] answer = {};
		int N = S.length; // 배열 속 문자열 개수
		int M = S[0].length(); // 문자열 길이

		// S[i]와 S[j] 뽑기
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				// S[i][idx]와 S[j][idx]가 같은지 비교
				for (int idx = 0; idx < M; idx++) {
					if (S[i].charAt(idx) == S[j].charAt(idx)) {
						// 같으면 두 배열의 인덱스 번호과 똑같은 문자의 인덱스 번호를 저장
						answer = new int[3];
						answer[0] = i;
						answer[1] = j;
						answer[2] = idx;
						return answer;
					}
				}

			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(S)));
	}

	static String[] S1 = { "abc", "bca", "dbe" };
	static String[] S = { "gr", "sd", "rg" };
}
