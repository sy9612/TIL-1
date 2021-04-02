package BAEKJOON.NonPass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 줄세우기_2252 {
	static int N, M;
	static int[][] student;
	static List<Integer> result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		student = new int[N][N];
		result = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			student[A-1][B-1] = 1;
		}
		
		//bfs?
		//1 3 세우고
		//2 3 세우고
		//1 2 3, 2 1 3 다 가능 ㅇ
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(0);
		
		
	}
}
