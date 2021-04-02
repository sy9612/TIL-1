package chap09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class SortTest {

	public static void main(String[] args) {
		int[] arr = new int[] {1,3,5,2,6,4};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		ArrayList<Integer> list = new ArrayList();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(2);
		list.add(6);
		list.add(4);
		
		Collections.sort(list);
		
		for(Integer integer : list) {
			System.out.println(integer + " ");
		}
		System.out.println();
		
		HashSet<Integer> set = new HashSet();
		
		set.add(1);
		set.add(3);
		set.add(5);
		set.add(2);
		set.add(6);
		set.add(4);
		
		//set은 정렬되지 않음
		//list로 변환하여 정렬
		ArrayList list2 = new ArrayList(set);
		Collections.sort(list2);
	}

}
