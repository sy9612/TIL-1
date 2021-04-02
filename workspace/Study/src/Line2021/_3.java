package Line2021;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _3 {
	public static void main(String[] args) {
		int[] enter = { 1, 3, 2 };
		int leave[] = { 1, 2, 3 };

		solution(enter, leave);
	}

	public static int[] solution(int[] enter, int[] leave) {
		int[] answer = new int[enter.length];

		boolean[][] check = new boolean[enter.length + 1][enter.length + 1];

		LinkedList<Integer> q = new LinkedList<>();

		int j = 0;
		for (int i = 0; i < enter.length; i++) {
			q.add(enter[i]);
			for (int k = 0; k < q.size(); k++) {

				for (int qq = 0; qq < q.size(); qq++) {
					if (q.get(k) == q.get(qq))
						continue;
					check[q.get(k)][q.get(qq)] = true;
					check[q.get(qq)][q.get(k)] = true;
				}

			}
			
			while(!q.isEmpty() && q.contains(leave[j])){
			//if (q.contains(leave[j])) {

				for (int k = 0; k < q.size(); k++) {
					if (q.get(k) == leave[j]) {
						q.remove(k);
						break;
					}
				}

				j++;
			}
	

		}

		for (int i = 1; i < check.length; i++) {
			int cnt = 0;
			for (int s = 1; s < check.length; s++) {
				if (check[i][s]) {
					cnt++;
				}
			}

			answer[i - 1] = cnt;
		}

//		System.out.println(Arrays.toString(answer));

		return answer;
	}
}
