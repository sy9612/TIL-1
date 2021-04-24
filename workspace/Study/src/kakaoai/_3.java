package kakaoai;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

class Result1 {

	/*
	 * Complete the 'solution' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY start_time 2. INTEGER_ARRAY running_time
	 */

	public static int solution(List<Integer> start_time, List<Integer> running_time) {
		// Write your code here

		int result = 0;

		/**
		 * 왜 배열로 변환했는가?
		 * 두 개의 time에 대해서 그리디한 방법으로 풀기 위해서는 정렬이 필요했다.
		 * 두 개의 변수를 가지고 같이 움직여야 한다. -> class를 만들어서 List<Node> 형식을 사용하는 것을 생각했지만, 두 개의 변수만 필요하므로 간단하게 접근할 수 있는 배열로 접근했다.
		 * 이전에 비슷한 문제를 풀어봤기 때문에 좀 더 빠르게 접근하기 위해서 기억을 되살려서 배열로 접근한 것도 있다.
		 */
		int[][] time = new int[start_time.size()][2];

		for (int i = 0; i < start_time.size(); i++) {
			time[i][0] = start_time.get(i);
			time[i][1] = start_time.get(i) + running_time.get(i); // 시작시간과 -ing 시간을 더하면 끝 시간이 나온다.
		}

		
		// 배열 정렬
		// 1순위 -> 끝나는 시간, 2순위 -> 시작하는 시간
		/**
		 * Why? 최대한 많은 세션 회수를 정해야 하기 때문에
		 * -> 끝나는 시간으로 정렬을 하게 되면, 끝나는 시간에 맞춰 시작하는 시간에 맞는 타임을 구할 수 있다. -> 가장 빨리 끝나는 세션을 배열로 정렬해서 할 수 있다.
		 * -> 끝나는 시간이 같다면, 시작하는 시간을 오름차순으로 정렬한다. 가장 빠르게 시작 할 수 있는 세션을 구한다.
		 */
		Arrays.sort(time, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1]- o2[1];
			}
			
		});
		
		int end = -1;
		
		for (int i = 0; i < time.length; i++) {
			if(time[i][0] >= end) { //이전 회의 종료 시간보다 시작 시간이 더 커야한다. 겹치면 안됨
				end = time[i][1];
				result++;
			}
		}

		
		//
//		int sub = start_time.get(0);
//		int amt = running_time.get(0);
//
//		List<Integer> new_start_time = new ArrayList<>();
//		new_start_time.add(sub);
//
//		List<Integer> new_running_time = new ArrayList<>();
//		new_running_time.add(amt);
//
//		for (int i = 1; i < start_time.size(); i++) {
//			if (sub != start_time.get(i)) {
//				new_start_time.add(start_time.get(i));
//				new_running_time.add(running_time.get(i));
//			} else {
//
//				int len = new_running_time.size();
//				int tmp = Math.min(amt, running_time.get(i));
//				new_running_time.set(len - 1, tmp);
//
//			}
//
//			sub = start_time.get(i);
//			amt = running_time.get(i);
//
//			System.out.println(new_start_time);
//			System.out.println(new_running_time);
//		}
//
//// find path
//		int time_idx = new_start_time.get(0);
//
//		for (int i = 0; i < new_start_time.size(); i++) {
//			if (new_start_time.get(i) >= time_idx) {
//				result += 1;
//				time_idx += new_running_time.get(i);
//			}
//		}

		System.out.println(result);
		return result;

	}

}

public class _3 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int start_timeCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> start_time = IntStream.range(0, start_timeCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int running_timeCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> running_time = IntStream.range(0, running_timeCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int result = Result1.solution(start_time, running_time);

		bufferedReader.close();
	}
}
