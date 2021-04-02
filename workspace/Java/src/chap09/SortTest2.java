package chap09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortTest2 {
	static class Hello implements Comparable<Hello>{
		int low, high;
		Hello(int low, int high){
			this.low = low;
			this.high = high;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Hello [low=" + low + ", high=" + high + "]";
		}
		
		//o는 다음 비교를 의미
		@Override
		public int compareTo(Hello o) {
			if(high == o.high)
				return low-o.low;
			return high - o.high; //정렬 기준: high
		}
	}
	
	public static void main(String[] args) {
		Hello[] arr = new Hello[] {new Hello(1,10), new Hello(3,8), new Hello(23,48), new Hello(2,8)};
		
		Arrays.sort(arr);
		for(Hello hello : arr) {
			System.out.println(hello.toString());
		}
		
		System.out.println("-------------------");
		ArrayList<Hello> list = new ArrayList<>();
		list.add(new Hello(1,10));
		list.add(new Hello(3,8));
		list.add(new Hello(23,48));
		list.add(new Hello(2,8));
		
		Collections.sort(list);
		
		for(Hello hello : list) {
			System.out.println(hello.toString());
		}
		
	}
	
	
}
