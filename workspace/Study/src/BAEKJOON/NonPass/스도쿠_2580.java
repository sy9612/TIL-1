package BAEKJOON.NonPass;

import java.util.*;
public class 스도쿠_2580 {
	static class Node{
		int i;
		int j;
		Node(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sdoku[][] = new int[9][9];
		boolean number[][][] = new boolean[9][9][10];
		
		LinkedList<Node> zero = new LinkedList<>();
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sdoku[i][j] = sc.nextInt();
				
				if(sdoku[i][j] == 0) {
					zero.add(new Node(i,j));
				}
			}
		}
		
		while(!zero.isEmpty()) {
			boolean sign = false;
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					if(sdoku[i][j] == 0)
						sign = true;
				}
			}
			if(sign == false)
				break;
			
			Node buf = zero.poll();
			
			for(int i=0; i<9; i++) {
				number[buf.i][buf.j][ sdoku[buf.i][i] ] = true; 
				number[buf.i][buf.j][ sdoku[i][buf.j] ] = true;
			}
			//몫
			int quoi = buf.i/3;
			int quoj = buf.j/3;
			String quo = "" + quoi + quoj;
			
			switch(quo) {
			case "00":
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						number[buf.i][buf.j][ sdoku[i][j] ] = true;
					}
				}
				break;
			case "01":
				for(int i=3; i<6; i++) {
					for(int j=0; j<3; j++) {
						number[buf.i][buf.j][ sdoku[i][j] ] = true;
					}
				}
				break;
			case "02":
				for(int i=6; i<9; i++) {
					for(int j=0; j<3; j++) {
						number[buf.i][buf.j][ sdoku[i][j] ] = true;
					}
				}
				break;
			case "10":
				for(int i=0; i<3; i++) {
					for(int j=3; j<6; j++) {
						number[buf.i][buf.j][ sdoku[i][j] ] = true;
					}
				}
				break;
			case "11":
				for(int i=3; i<6; i++) {
					for(int j=3; j<6; j++) {
						number[buf.i][buf.j][ sdoku[i][j] ] = true;
					}
				}
				break;
			case "12":
				for(int i=6; i<9; i++) {
					for(int j=3; j<6; j++) {
						number[buf.i][buf.j][ sdoku[i][j] ] = true;
					}
				}
				break;
			case "20":
				for(int i=0; i<3; i++) {
					for(int j=6; j<9; j++) {
						number[buf.i][buf.j][ sdoku[i][j] ] = true;
					}
				}
				break;
			case "21":
				for(int i=3; i<6; i++) {
					for(int j=6; j<9; j++) {
						number[buf.i][buf.j][ sdoku[i][j] ] = true;
					}
				}
				break;
			case "22":
				for(int i=6; i<9; i++) {
					for(int j=6; j<9; j++) {
						number[buf.i][buf.j][ sdoku[i][j] ] = true;
					}
				}
				break;
			}
			
			for(int i=1; i<10; i++) {
				if(!number[buf.i][buf.j][i]) {
					sdoku[buf.i][buf.j]= i;
					number[buf.i][buf.j][i] = true;
				}
			}
			print(sdoku);
		}
		System.out.println("-------------");
		print(sdoku);
	}
	
	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
}
