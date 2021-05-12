package BAEKJOON;

import java.io.*;

public class 칸토어집합_4779 {
	static StringBuilder rs;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String st = "";

		while ((st = br.readLine()) != null) {
			int N = Integer.parseInt(st);
			rs = new StringBuilder("");
			double len = Math.pow(3, N);

			if (len == 1) {
				System.out.println("-");
				continue;
			}

			cantor(len);
			System.out.println(rs.toString());
		}
	}

	private static void cantor_black(double len) {
		// TODO Auto-generated method stub

		for (double i = 0; i < len; i++)
			rs.append(" ");

	}

	private static void cantor(double len) {
		// TODO Auto-generated method stub

		if(len == 0) return;
		if (len == 1) {
			rs.append("-");
			return;
		}

		cantor(len / 3);
		cantor_black(len / 3);
		cantor(len / 3);

	}
}
