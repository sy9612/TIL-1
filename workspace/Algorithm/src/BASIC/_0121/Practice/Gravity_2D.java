package BASIC._0121.Practice;

import java.util.Arrays;

public class Gravity_2D {
	public static void main(String[] args) {
		int[] input = {7,4,2,0,0,6,0,7,0};
		int[][] board = null;

		board = new int[input.length][];

		//1�� print
		for (int i = 0; i < board.length; i++) {
			board[i] = new int[input.length];
		}
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<input[i]; j++) {
				board[board.length-1-j][i] = 1;
			}
		}
		
		System.out.println("#1");
		for(int i=0; i<board.length; i++)
			System.out.println(Arrays.toString(board[i]));
		
		//2�� print
		int[][] new_board = null;

		new_board = new int[input.length][];

		for (int i = 0; i < board.length; i++) {
			new_board[i] = new int[input.length];
		}
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				if(board[i][j] == 1) {
					new_board[j][board.length-1-i] = 1;
				}
			}
		}
		
		System.out.println("#2");
		for(int i=0; i<board.length; i++)
			System.out.println(Arrays.toString(new_board[i]));
		
		//3�� print
		int max = 0;
		for(int i=0; i<new_board.length; i++) {
			int cnt = 0;
			for(int j=new_board.length-1; j>=0; j--) {
				if(new_board[j][i] == 0) {
					cnt++;
				}
				new_board[j][i] = 0;
				//System.out.println(j+","  + i+": " + cnt);
			}
			for(int j=board.length-1; j>=cnt; j--) {
				new_board[j][i] = 1;
			}
			if(max < cnt && cnt != 9)
				max = cnt;
		}
		

		System.out.println("#3");
		for(int i=0; i<board.length; i++)
			System.out.println(Arrays.toString(new_board[i]));
		
		System.out.println("Result: " + max);
	}
}