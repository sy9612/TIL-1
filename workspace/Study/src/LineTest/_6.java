package LineTest;

import java.io.*;
import java.util.Scanner;

public class _6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a[] = new String[4];
		String b[] = new String[4];

		System.out.println(solution(a, b));
	}

	public static String[] solution(String[] directory, String[] command) {
		String[] answer = {};

		for (int i = 0; i < command.length; i++) {
			String sub = command[i].substring(0, command[i].indexOf(" "));
			String com = command[i].substring(command[i].indexOf(" ")+1);

			File Folder = new File(com);
			switch (sub) {
			case "mkdir":
				if (!Folder.exists()) {
					try {
						Folder.mkdir(); // 폴더 생성합니다.
					} catch (Exception e) {
						e.getStackTrace();
					}
				}
				break;
			case "rm":
				break;
			case "cp":
				break;
			}

		}
		return answer;
	}
}
