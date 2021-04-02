package chap09;

import java.util.Arrays;
import java.util.Comparator;

import chap09.SortTest2.Hello;

public class SortTest3 {
	static class MyCompar implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			
			return o1-o2; // 오름차순 정렬
		}
		
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {1,3,5,2,6,4};
		MyCompar com = new MyCompar();
		
		//override 바로 실행		
		Arrays.sort(arr,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
			
		});
		
		System.out.println(Arrays.toString(arr));
		
		
		
		Hello[] arr1 = new Hello[] {new Hello(1,10), new Hello(3,8), new Hello(23,48), new Hello(2,8)};
		
		Arrays.sort(arr1, new Comparator<Hello>() {

			@Override
			public int compare(Hello o1, Hello o2) {
				// TODO Auto-generated method stub
				return o1.high - o2.high;
			}
			
		});
		for(Hello hello : arr1) {
			System.out.println(hello.toString());
		}
	}
}
