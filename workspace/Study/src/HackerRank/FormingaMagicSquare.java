package HackerRank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FormingaMagicSquare {
	// Complete the formingMagicSquare function below.
	static int formingMagicSquare(int[][] s) {
		int result = 0;
		boolean[] check = new boolean[10];
		PriorityQueue<Integer> ll = new PriorityQueue<>();
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[0].length; j++) {
				if(!check[s[i][j]])
					check[s[i][j]] = true;
				else {
					ll.add(s[i][j]);
				}
			}
		}
		
		
		for (int i = 1; i < check.length; i++) {
			if(!check[i]) {
				result += Math.abs(ll.poll() - i);
			}
		}
		
		
		System.out.println(result);
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		int[][] s = new int[3][3];
		for (int i = 0; i < 3; i++) {
			String[] sRowItems = scanner.nextLine().split(" ");

			for (int j = 0; j < 3; j++) {
				int sItem = Integer.parseInt(sRowItems[j]);
				s[i][j] = sItem;
			}
		}

		int result = formingMagicSquare(s);
//
//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();

		scanner.close();
	}
}
