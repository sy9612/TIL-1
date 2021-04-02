package Line2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] table = { "SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA" };

		String[] la = { "JAVA", "JAVASCRIPT"};

		int[] pre = { 7, 5 };

		solution(table, la, pre);
	}
	
	static class Node implements Comparable<Node>{
		String job;
		int result;
		
		Node(String job, int result){
			this.job  = job;
			this.result = result;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(this.result == o.result) {
				return this.job.compareTo(o.job);
			}
			else return o.result - this.result;
			
		}
	}

	public static String solution(String[] table, String[] languages, int[] preference) {
		String answer = "";
		
		String[][] tb = new String[5][6];
		
		
		ArrayList<Node> result = new ArrayList<>();
		for (int i = 0; i < table.length; i++) {
			tb[i] = table[i].split(" ");
			result.add(new Node(tb[i][0], 0));
		}
		
		
		
		
		for (int i = 0; i < tb.length; i++) {
			for (int j = 1; j < tb[i].length; j++) {
				for (int k = 0; k < languages.length; k++) {
					if(tb[i][j].equals(languages[k])) {
						result.get(i).result += (6-j) * preference[k];
					}
				}
			}
		}
		
		
		Collections.sort(result);
		
		answer = result.get(0).job;
		//System.out.println(result.get(0).job);
	
		
		return answer;
	}
}
