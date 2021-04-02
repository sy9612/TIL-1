package BAEKJOON.NonPass;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 일곱난쟁이_2309 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sort[] = new int[9];
		for(int i=0; i<9; i++) {
			sort[i] = sc.nextInt();
		}
		
		int realy[] = new int[2];
		check = new boolean[9];
		comb(realy, sort, 0, 0);
	}
	static boolean check[];
	static int r = 0;
	private static void comb(int[] realy, int[] sort, int idx, int v) {
		if(r == 1)
			return;
		if(idx == realy.length) {
			int result = 0;
			PriorityQueue<Integer> q = new PriorityQueue<>();
			for(int i =0; i<9; i++) {
				if(realy[0] != i && realy[1] != i)
				{
					result+= sort[i];
					q.add(sort[i]);
				}
			}
			
			if(result<=100)
			{
				for(int i=0; i<7; i++) {
					System.out.println(q.poll());
				}
				r = 1;
			}
			
			//System.out.println(Arrays.toString(realy));
			return;
		}
		if(v == sort.length)
			return;
		realy[idx] = v;
		comb(realy, sort,idx+1,v+1);
		comb(realy,sort,idx,v+1);
	}

}
