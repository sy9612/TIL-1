package BAEKJOON.NonPass;

import java.util.LinkedList;
import java.util.Scanner;


public class 이모티콘_14226 {
	
	static class Dot {
		int i;
		int j;
		int c;
		
		Dot(int i, int j, int c) {
			this.i = i;
			this.j = j;
			this.c = c;
		};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		
		LinkedList<Dot> q = new LinkedList<>();
		Dot a = new Dot(1,0,0);
		q.add(a);
		
		boolean check[] = new boolean[1001];
		
		//i = 길이, j = 시간
		int ctrlv = 0;
		while(!q.isEmpty()) {
			Dot b = q.poll();
			if(b.i == S) {
				System.out.println(b.j);
				return;
			}
			
			
			//클립보드에 저장
			
			q.add(new Dot(b.i,b.j+1,b.i));
			
			//화면에 붙여넣기
			if(b.c != 0 && (b.c+b.i)> 0 && (b.c+b.i) < 1001 && check[b.c + b.i] == false) {
				if(b.c+ b.i == S){
					System.out.println(b.j+1);
					return;
				}
				check[b.c+b.i] = true;
				q.add(new Dot(b.c+b.i, b.j+1, b.c));
			}
			
			//이모티콘 삭제
			if(b.i-1>=0 && b.i-1<1001 && check[b.i-1] == false) {
				if(b.i-1 == S){
					System.out.println(b.j+1);
					return;
				}
				check[b.i-1] = true;
				q.add(new Dot(b.i-1,b.j+1,b.c));
			}
		}
	}

}
