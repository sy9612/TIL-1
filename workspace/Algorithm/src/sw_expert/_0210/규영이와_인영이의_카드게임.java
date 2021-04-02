package sw_expert._0210;

import java.util.Arrays;
import java.util.Scanner;

public class 규영이와_인영이의_카드게임 {
	static int[] card;
	static int win = 0;
	static int lose = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<= T; tc++) {
			win = 0;
			lose = 0;
			card = new int[9];
			
			boolean check[] = new boolean[19];
						
			
			for(int i=0; i<9; i++) {
				card[i] = sc.nextInt();
				check[card[i]] = true;
			}
			
			
			
			int iyCard[] = new int[9];
			int iycnt= 0;
			for(int i=1; i< 19; i++) {
				if(check[i] == false) {
					iyCard[iycnt++] = i;
				}
			}
			
			int [] result = new int[9];
			boolean visited[] = new boolean[9];
			
			perm(0,visited, result, iyCard);
			
			System.out.println("#" + tc + " " + win + " " + lose);
			
		}
	}
	
	static void perm(int idx, boolean visited[], int result[], int iyCard[]) {
		if(idx == result.length) {
			int gy = 0;
			int iy = 0;
			for(int i=0; i<9; i++) {
				if(card[i] < result[i])
					iy += (card[i] + result[i]);
				else
					gy += (card[i] + result[i]);
			}
			
			if(gy> iy)
				win++;
			else if(gy < iy)
				lose++;
			//System.out.print(Arrays.toString(result));
			return;
		}
		
		for(int i=0; i<iyCard.length; i++) {
			//i번째가 아직 고르지 않은 것이라면
			if(!visited[i]) {
				//i번쨰를 고른 것으로 체크
				visited[i] = true;
				//i번째를 현재 순서인 idx에 담고 다음 순서로 이동
				result[idx] = iyCard[i];
				perm(idx+1, visited, result, iyCard);
				//다시 순서로 돌아오면 false로 바꾸고 다음 검사
				visited[i] = false;
			}
		}
	}

}
