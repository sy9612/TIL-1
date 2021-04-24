package devmatching;

import java.util.Arrays;
import java.util.HashSet;

public class _1 {
	public static void main(String[] args) {
//		int[] lottos = { 44, 1, 0, 0, 31, 25};
//		int[] win_nums = {31, 10, 45, 1, 6, 19};
//		
//
//		int[] lottos = { 0, 0, 0, 0, 0, 0};
//		int[] win_nums = {38, 19, 20, 40, 15, 25};
		
		int[] lottos = {45, 4, 35, 20, 3, 9};
		int[] win_nums = {20, 9, 3, 45, 4, 35};
		
		
		System.out.println(Arrays.toString(solution(lottos, win_nums)));
	}

	//최고 순위와 최저 순위
	public static int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		
		// 순위 찾기
		int[] rank = {0, 6, 5, 4, 3, 2};
		
		
		// 0이 존재한 만큼 아무 숫자나 들어갈 수 있음
		// 최고 순위와 최저 순위를 계산
		
		// 해쉬 사용
		HashSet<Integer> lt = new HashSet<>();
		
		int cnt = 0;
		for (int i = 0; i < lottos.length; i++) {
			if(lottos[i] == 0) cnt++; //
			else lt.add(lottos[i]);
		}
		
		int rs = 0;
		for (int i = 0; i < win_nums.length; i++) {
			// 맞춘 로또 번호들은 빼기
			if(lt.contains(win_nums[i])) {
				rs++;
				lt.remove(win_nums[i]);
			}
		}
		
		// 최대 순위와 최소 순위 계산
		for (int r = 1; r < rank.length; r++) {
			if(answer[0] == 0 && rs+cnt == rank[r]) {
				answer[0] = r;
			}
			if(answer[1] == 0 && rs == rank[r]) {
				answer[1] = r;
			}
		}
		
		if(answer[0] == 0) answer[0] = 6;
		if(answer[1] == 0) answer[1] = 6;
		
		return answer;
	}
}
