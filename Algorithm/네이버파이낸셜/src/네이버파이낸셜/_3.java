package 네이버파이낸셜;

import java.util.Arrays;

public class _3 {
	public static class Solution {
		public static int solution(int[] A) {
			int answer = 0;

			// 정렬
			Arrays.sort(A);

			// 오름차순정렬이라 음수부터 시작. 양수가 되면 더이상 K와 -K를 찾을 수 없으므로 탈출
			int idx = -1;
			for (int i = 0; A[i] < 0; i++) {
				// 숫자 K와 -K가 존재하는지 확인
				idx = Arrays.binarySearch(A, A[i] * -1);
				if (idx > -1) { // 존재하면 숫자 K 반환(제일 처음 찾는 수가 제일 큰 수)
					return A[i] * -1;
				}
			}

			return answer;
		}

		public static void main(String[] args) {
			System.out.println(solution(A));
			System.out.println(solution(A1));
			System.out.println(solution(A2));
		}

		static int[] A = { 3, 2, -2, 5, -3 };
		static int[] A1 = { 1, 1, 2, -1, 2, -1 };
		static int[] A2 = { 1, 2, 3, -4 };
	}

}
