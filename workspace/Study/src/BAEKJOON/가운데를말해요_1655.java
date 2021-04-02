package BAEKJOON;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 가운데를말해요_1655 {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    
	    
	    PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> o2 - o1);
	    PriorityQueue<Integer> max = new PriorityQueue<>();
	    
	    
	    for(int i = 0; i<N; i++){
	    	int number = sc.nextInt();
	    	if(min.size() > max.size()) {
	    		max.add(number);
	    	}
	    	else {
	    		min.add(number);
	    	}
	    	
	    	if(min.size() != 0 && max.size() != 0 && min.peek() > max.peek()) {
	    		int tmp = min.poll();
	    		min.add(max.poll());
	    		max.add(tmp);
	    	}
	    	
	    	System.out.println(min.peek());
	    }
	}
}
