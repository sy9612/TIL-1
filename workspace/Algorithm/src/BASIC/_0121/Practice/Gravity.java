package BASIC._0121.Practice;

import java.util.Random;

public class Gravity {
	public static int[] build_data(int[] data) {
		Random ran = new Random();
		for(int i =0; i<data.length; i++){
			data[i] = ran.nextInt(data.length);
		}
		
		return data;
	}
	public static void main(String[] args) {
		int[] input = {7,4,2,0,0,6,0,7,0};
		int[][] board = null;
		
		board = new int[input.length][];
		
		for(int i=0; i<board.length; i++) {
			board[i] = new int[input.length];
		}
		
		int[] data = null;
		
		data = new int[input.length];
		
		data = build_data(data);
		

		int max = -1;
		int index = input.length;
		int max_input = 0;
		int[] max_cnt = new int[input.length];
		for(int i=0; i<input.length; i++) {
			max_cnt[i]++;
		}
		
		
		for(int i=input.length-1; i>=0; i--) {
			int buf = 0;
			buf = index - i;
			if(max_input <= input[i]) {
				buf = input.length - i;
				if(max_input == input[i]) {
					max_cnt[input[i]]++;
					buf = input.length - max_cnt[input[i]] - i;
				}
				index = i;
				max_input = input[i];
			}
			
			
			if(max < buf) {
				max = buf;
			}

		}
		
		System.out.println(max);
		
		
		
		//����� ���� ���� ������ ����
	}
}
