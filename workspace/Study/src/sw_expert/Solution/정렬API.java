package sw_expert.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 정렬 API
 * @author JH
 *
 */
public class 정렬API {
	public static void main(String[] args) {
		int[] a = {3,1,5,4,2};
		Arrays.sort(a); //배열의 원소를 정렬, DualPrivotQuicksort
		
		Integer[] b = {3,1,5,4,2};
		Arrays.sort(b);
		
		Arrays.sort(b, Comparator.reverseOrder());
		
		List<Integer> l = new ArrayList <>();
		l.add(3);
		l.add(5);
		l.add(1);
		Collections.sort(l); //리스트 객체만 정렬
		l.sort(null);
	}
}
