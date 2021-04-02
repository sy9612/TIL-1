package BASIC._0128;

import java.util.Arrays;

public class 조합 {
	static int[] arr = {2,4,6};
	static int[] sel = new int[2];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combination(0,0);
	}
	static void combination(int idx, int s_idx) {
		//원하는 만큼 골랐으므로, 결과 뽑고 리턴
		if(s_idx == sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		//원하는 만큼 뽑지 못했지만, 더 이상 뽑을게 없으므로 리턴
		if(idx == arr.length)
			return;
		sel[s_idx] = arr[idx];
		//다음 것을 고르기 위해 s_idx 증가
		combination(idx+1, s_idx+1);
		//이번 고른 걸 무효시키기 위해 s_idx를 그대로
		combination(idx+1, s_idx);
	}
}
