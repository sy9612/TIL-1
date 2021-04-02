package BAEKJOON;

import java.util.Scanner;

public class 일로만들기_1463 {
	static int check[] ;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		min = 10000000;
		check = new int[10000001];
		//make(x,0);
		
		//bottomup
		for(int i=2; i<=x; i++) {
			check[i] = check[i-1]+1;
			if(i%2 == 0 && check[i] > check[i/2]+1) {
				check[i] = check[i/2]+1;
			}
			if(i%3==0 && check[i] > check[i/3] +1)
				check[i] = check[i/3]+1;
		}
		System.out.println(check[x]);
	}

//	static void make(int x, int cnt) {
//		if(x == 1)
//		{
//			if(min > cnt)
//				min = cnt;
//			return;
//		}
//		check[x] = cnt;
//		
//		if (x % 3 == 0 && check[x%3] == 0) {
//			make(x/3,cnt+1);
//		}
//		if (x % 2 == 0&& check[x%2] == 0) {
//			make(x/2,cnt+1);	
//		}
//		
//		if(x-1>=0 && check[x-1] == 0)
//			make(x-1,cnt+1);
//	}
}
