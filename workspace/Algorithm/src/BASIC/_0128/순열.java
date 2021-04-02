package BASIC._0128;

import java.util.Arrays;

public class 순열 {
	static int[] arr = {2,4,6};
	static int[] result = new int[arr.length];
	static boolean[] visited = new boolean[arr.length];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		perm(0);
	}
	
	static void perm(int idx) {
		if(idx == arr.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			//i번째가 아직 고르지 않은 것이라면
			if(!visited[i]) {
				//i번쨰를 고른 것으로 체크
				visited[i] = true;
				//i번째를 현재 순서인 idx에 담고 다음 순서로 이동
				result[idx] = arr[i];
				perm(idx+1);
				//다시 순서로 돌아오면 false로 바꾸고 다음 검사
				visited[i] = false;
			}
		}
	}
}
