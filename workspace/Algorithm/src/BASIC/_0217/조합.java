package BASIC._0217;
import java.util.Arrays;

public class 조합 {
	static int[] arr = {1,2,3};
	static int[] sel = new int[2];
	public static void main(String[] args) {
//		System.out.println(combCount(5, 2));
		comb(0,0);
	}
	static void comb(int idx, int s_idx) {
		if( s_idx == 2 	) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if( idx == arr.length )
			return;
		sel[s_idx] = arr[idx];
		comb(idx + 1, s_idx + 1);
		comb(idx + 1, s_idx);
	}
	static int combCount(int n, int r) {
		if( r == n )
			return 1;
		if( r == 0 )
			return 1;
		else
			return combCount(n-1, r-1) + combCount(n-1, r); 
	}
}
