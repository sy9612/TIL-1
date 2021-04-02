package BAEKJOON;

import java.util.Scanner;

public class 월드컵_6987 {
	private static int[][] worldcup;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result[] = new int[4];
		for (int tc = 0; tc <= 3; tc++) {
			worldcup = new int[6][3];

			int win = 0;
			int draw = 0;
			int lose = 0;
			r = 0;

			for (int i = 0; i < worldcup.length; i++) {
				worldcup[i][0] = sc.nextInt();
				worldcup[i][1] = sc.nextInt();
				worldcup[i][2] = sc.nextInt();

				win += worldcup[i][0];
				draw += worldcup[i][1];
				lose += worldcup[i][2];
			}

			if (win != lose) 
				continue;
			

			if (win + draw + lose != 30)
				continue;
			

			dfs(0,1);
			result[tc] = r;

		
		}
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

	static int r ;
	private static void dfs(int teamA, int teamB) {
		// TODO Auto-generated method stub

		if(teamB == 6) {
			dfs(teamA+1,teamA+2);
			return;
		}
		
		if(teamA >= 5) {
			for (int i = 0; i < worldcup.length; i++) {
				for (int j = 0; j < worldcup[i].length; j++) {
					if(worldcup[i][j] > 0)
					{
						return;
					}
				}
			}
			r = 1;
			return;
		}
		
		if(worldcup[teamA][0] > 0 && worldcup[teamB][2] > 0) {
			worldcup[teamA][0]--;
			worldcup[teamB][2]--;
			dfs(teamA, teamB+1);		
			worldcup[teamA][0]++;
			worldcup[teamB][2]++;
		}
		if(worldcup[teamA][1] > 0 && worldcup[teamB][1] > 0) {
			worldcup[teamA][1]--;
			worldcup[teamB][1]--;
			dfs(teamA, teamB+1);		
			worldcup[teamA][1]++;
			worldcup[teamB][1]++;
		}
		if(worldcup[teamA][2] > 0 && worldcup[teamB][0] > 0) {
			worldcup[teamA][2]--;
			worldcup[teamB][0]--;
			dfs(teamA, teamB+1);		
			worldcup[teamA][2]++;
			worldcup[teamB][0]++;
		}
		

	}
}
