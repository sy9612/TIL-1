package NBP;

import java.util.HashMap;

public class _2 {
	public static void main(String[] args) {
		int[] arr = {2, 1, 3, 1, 4, 2, 1, 3};
		solution(arr);
	}

	public static int solution(int[] arr) {
		int answer = Integer.MAX_VALUE;
		
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			
			if(hs.containsKey(arr[i])) {
				if(answer > i - hs.get(arr[i])) {
					answer = i - hs.get(arr[i]);
				}
				else {
					hs.remove(arr[i]);
					hs.put(arr[i], i);
				}
			}
			else
				hs.put(arr[i], i);
		}
		
		if(answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
		
		return answer;
	}
}
